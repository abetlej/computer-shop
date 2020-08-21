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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;

/**
 * 
 * @author abetlej
 *         <p>
 *         Used to inform user that her/his purchase
 *         </p>
 */
public class PaymentCompletedFrame extends JFrame {
	private Customer customer;
	private ArrayList<Product> ProductArray;
	private double total;
	private PaymentMethod PaymentMethod;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(double total, PaymentMethod PaymentMethod, Customer customer,
			ArrayList<Product> ProductArray) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentCompletedFrame frame = new PaymentCompletedFrame(total, PaymentMethod, customer,
							ProductArray);
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
	public PaymentCompletedFrame(double total, PaymentMethod PaymentMethod, Customer customer,
			ArrayList<Product> ProductArray) {
		this.total = total;
		String message = PaymentMethod.showMessage(total);
		this.customer = customer;
		this.ProductArray = ProductArray;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 969, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlDkShadow);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblInfo = new JLabel(message);
		lblInfo.setForeground(new Color(255, 204, 0));
		lblInfo.setFont(new Font("Courier New", Font.BOLD, 20));
		lblInfo.setBackground(SystemColor.controlDkShadow);
		lblInfo.setBounds(85, 95, 801, 71);
		contentPane.add(lblInfo);

		JButton btnBackToShop = new JButton("Back to shop");
		btnBackToShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				QuantityComparator qc = new QuantityComparator(); // sorting new product list
				Collections.sort(ProductArray, qc);
				customer.getShoppingBasket().emptyBasket();
				CustomerFrame cf = new CustomerFrame(customer, ProductArray); // opening new CustomerFrame for the same
																				// customer
				cf.setVisible(true);
				dispose();
			}
		});
		btnBackToShop.setFont(new Font("Courier New", Font.BOLD, 16));
		btnBackToShop.setBackground(new Color(255, 204, 0));
		btnBackToShop.setBounds(369, 163, 196, 50);
		contentPane.add(btnBackToShop);
	}
}
