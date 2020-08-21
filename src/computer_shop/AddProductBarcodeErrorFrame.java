package computer_shop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author abetlej
 *         <p>
 *         An error message displayed if <code>Barcode</code> entered by
 *         <code>Admin</code> is already saved in Stock.txt file
 *         </p>
 */
public class AddProductBarcodeErrorFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProductBarcodeErrorFrame frame = new AddProductBarcodeErrorFrame();
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
	public AddProductBarcodeErrorFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 913, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlDkShadow);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Item with this Barcode is already in stock!");
		lblNewLabel.setForeground(new Color(255, 204, 0));
		lblNewLabel.setFont(new Font("Courier New", Font.BOLD, 16));
		lblNewLabel.setBackground(SystemColor.controlDkShadow);
		lblNewLabel.setBounds(25, 91, 830, 45);
		contentPane.add(lblNewLabel);

		JButton btnMessageRead = new JButton("OK");
		btnMessageRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnMessageRead.setFont(new Font("Courier New", Font.BOLD, 16));
		btnMessageRead.setBackground(new Color(255, 204, 0));
		btnMessageRead.setBounds(369, 157, 115, 38);
		contentPane.add(btnMessageRead);
	}

}
