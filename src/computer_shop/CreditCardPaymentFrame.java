package computer_shop;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author abetlej
 *         <p>
 *         Frame used for credit card payments.
 *         </p>
 */
public class CreditCardPaymentFrame extends JFrame {
	private Customer customer;
	private ArrayList<Product> ProductArray;

	private JPanel contentPane;
	private JTextField jtCardNumber;
	private JTextField jtSecurityCode;
	private JLabel lblTitle;

	/**
	 * Launch the application.
	 */
	public static void main(Customer customer, ArrayList<Product> ProductArray) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreditCardPaymentFrame frame = new CreditCardPaymentFrame(customer, ProductArray);
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
	public CreditCardPaymentFrame(Customer customer, ArrayList<Product> ProductArray) {
		this.customer = customer;
		this.ProductArray = ProductArray;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 879, 526);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlDkShadow);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTitle = new JLabel("Credit Card Payment");
		lblTitle.setBounds(209, 60, 633, 37);
		lblTitle.setForeground(new Color(255, 204, 0));
		lblTitle.setFont(new Font("Courier New", Font.BOLD, 32));
		contentPane.add(lblTitle);

		JLabel lblCardNumber = new JLabel("Card number:");
		lblCardNumber.setForeground(new Color(255, 204, 0));
		lblCardNumber.setFont(new Font("Courier New", Font.BOLD, 22));
		lblCardNumber.setBounds(119, 144, 178, 38);
		contentPane.add(lblCardNumber);

		JLabel lblSecurityCode = new JLabel("Security code:");
		lblSecurityCode.setForeground(new Color(255, 204, 0));
		lblSecurityCode.setFont(new Font("Courier New", Font.BOLD, 22));
		lblSecurityCode.setBounds(119, 227, 196, 38);
		contentPane.add(lblSecurityCode);

		jtCardNumber = new JTextField();
		jtCardNumber.setColumns(10);
		jtCardNumber.setBounds(353, 150, 305, 26);
		contentPane.add(jtCardNumber);

		jtSecurityCode = new JTextField();
		jtSecurityCode.setColumns(10);
		jtSecurityCode.setBounds(353, 235, 305, 26);
		contentPane.add(jtSecurityCode);

		JButton btnPay = new JButton("Pay");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreditCardPayment ccp = new CreditCardPayment(jtCardNumber.getText().toString(),
						jtSecurityCode.getText().toString());
				if (ccp.checkCardNumber() && ccp.checkSecurityCode()) {// checking if user's inputs are correct
					WritingToFile wtf = new WritingToFile(customer, "purchased", "Credit Card"); // writing to
																									// ActivityLog.txt
																									// file
					wtf.addOnTopOfFile();
					double total = customer.getShoppingBasket().getTotal();
					PaymentCompletedFrame pcf = new PaymentCompletedFrame(total, ccp, customer, ProductArray);
					pcf.setVisible(true); // opening a new frame with message about payment being done
					WritingToFile wtsf = new WritingToFile("Stock.txt", ProductArray);
					wtsf.writeStockFile(); // changing the quantity in stock file
					dispose();
				} else {
					lblTitle.setText("Wrong card details!"); // changing frame's title to error message
				}
			}
		});
		btnPay.setFont(new Font("Courier New", Font.BOLD, 16));
		btnPay.setBackground(new Color(255, 204, 0));
		btnPay.setBounds(372, 334, 115, 46);
		contentPane.add(btnPay);
	}

}
