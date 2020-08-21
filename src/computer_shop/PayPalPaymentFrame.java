package computer_shop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

/**
 * 
 * @author abetlej
 *         <p>
 *         Frame used for Pay Pal payments.
 *         </p>
 */
public class PayPalPaymentFrame extends JFrame {
	private Customer customer;
	private ArrayList<Product> ProductArray;

	private JPanel contentPane;
	private JTextField jtEmail;
	private JLabel lblTitle;

	/**
	 * Launch the application.
	 */
	public static void main(Customer customer, ArrayList<Product> ProductArray) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PayPalPaymentFrame frame = new PayPalPaymentFrame(customer, ProductArray);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PayPalPaymentFrame(Customer customer, ArrayList<Product> ProductArray) {
		this.customer = customer;
		this.ProductArray = ProductArray;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 361);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlDkShadow);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setForeground(new Color(255, 204, 0));
		lblEmail.setFont(new Font("Courier New", Font.BOLD, 22));
		lblEmail.setBounds(134, 136, 106, 38);
		contentPane.add(lblEmail);

		lblTitle = new JLabel("PayPal Payment\r\n");
		lblTitle.setForeground(new Color(255, 204, 0));
		lblTitle.setFont(new Font("Courier New", Font.BOLD, 32));
		lblTitle.setBounds(283, 61, 422, 54);
		contentPane.add(lblTitle);

		jtEmail = new JTextField();
		jtEmail.setBounds(270, 142, 305, 26);
		contentPane.add(jtEmail);
		jtEmail.setColumns(10);

		JButton btnPay = new JButton("Pay");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PayPalPayment ppp = new PayPalPayment(jtEmail.getText().toString());
				if (ppp.checkIfEmail()) {// checking if user's inputs are correct
					WritingToFile wtf = new WritingToFile(customer, "purchased", "PayPal"); // writing to
																							// ActivityLog.txt file
					wtf.addOnTopOfFile();
					double total = customer.getShoppingBasket().getTotal();
					PaymentCompletedFrame pcf = new PaymentCompletedFrame(total, ppp, customer, ProductArray);
					pcf.setVisible(true); // opening a new frame with message about payment being done
					WritingToFile wtsf = new WritingToFile("Stock.txt", ProductArray);
					wtsf.writeStockFile(); // changing the quantity in stock file
					dispose();
				} else {
					lblTitle.setText("Wrong e-mail address!"); // changing frame's title to error message
				}
			}

		});
		btnPay.setBackground(new Color(255, 204, 0));
		btnPay.setFont(new Font("Courier New", Font.BOLD, 16));
		btnPay.setBounds(369, 216, 115, 46);
		contentPane.add(btnPay);
	}
}
