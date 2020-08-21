package computer_shop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author abetlej
 *         <p>
 *         Used when user tries to purchase more products than there are
 *         currently in stock
 *         </p>
 */
public class QuantityErrorFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuantityErrorFrame frame = new QuantityErrorFrame();
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
	public QuantityErrorFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 964, 311);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlDkShadow);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblInfo = new JLabel(
				"Please choose amount \r\nthat is smaller than/equal to \r\nquantity in our store :)");
		lblInfo.setBackground(SystemColor.controlDkShadow);
		lblInfo.setFont(new Font("Courier New", Font.BOLD, 18));
		lblInfo.setForeground(new Color(255, 204, 0));
		lblInfo.setBounds(68, 47, 827, 121);
		contentPane.add(lblInfo);

		JButton btnMessageRead = new JButton("OK");
		btnMessageRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose(); // close when read
			}
		});
		btnMessageRead.setFont(new Font("Courier New", Font.BOLD, 16));
		btnMessageRead.setBackground(new Color(255, 204, 0));
		btnMessageRead.setBounds(424, 139, 113, 55);
		contentPane.add(btnMessageRead);
	}
}
