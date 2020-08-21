package computer_shop;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author abetlej
 *         <p>
 *         Frame in which user chooses their username and is then logged into
 *         system
 *         </p>
 */
public class StartFrame extends JFrame {

	private JPanel contentPane;
	private JList jlUsernames;
	private JLabel lblChooseUsername;
	private static HashMap<String, User> UserMap;
	private JComboBox cbUsernames;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserMap = new HashMap<>();

					ReadingFromUserAccountsFile rfuaf = new ReadingFromUserAccountsFile(UserMap);
					rfuaf.readFile();

					StartFrame frame = new StartFrame();
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
	public StartFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 843, 481);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlDkShadow);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		DefaultListModel<String> listModel = new DefaultListModel<>();
		for (String key : UserMap.keySet()) {
			listModel.addElement(key);
		}

		lblChooseUsername = new JLabel("Please choose your username");
		lblChooseUsername.setForeground(new Color(255, 204, 0));
		lblChooseUsername.setBackground(new Color(255, 204, 0));
		lblChooseUsername.setFont(new Font("Courier New", Font.BOLD, 20));
		lblChooseUsername.setBounds(240, 150, 332, 39);
		contentPane.add(lblChooseUsername);

		cbUsernames = new JComboBox();
		cbUsernames.setForeground(new Color(255, 204, 0));
		cbUsernames.setFont(new Font("Courier New", Font.BOLD, 18));
		cbUsernames.setBackground(SystemColor.controlDkShadow);
		for (String key : UserMap.keySet()) {
			cbUsernames.addItem(key);
		}
		cbUsernames.setBounds(326, 194, 175, 39);
		contentPane.add(cbUsernames);

		JButton btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = (String) cbUsernames.getSelectedItem();
				if (UserMap.get(username) instanceof Admin) {
					System.out.println("Admin");
					AdminFrame af1 = new AdminFrame();
					af1.setVisible(true);
					dispose();
				} else {
					System.out.println("Customer");
					Customer c1 = (Customer) UserMap.get(username);
					CustomerFrame cf1 = new CustomerFrame(c1, readListFromFile());
					cf1.setVisible(true);
					for(Product p: readListFromFile()) {
						System.out.println(p.toStringAdmin());
					}

					dispose();
				}
			}
		});
		btnLogIn.setForeground(Color.BLACK);
		btnLogIn.setFont(new Font("Courier New", Font.BOLD, 16));
		btnLogIn.setBackground(new Color(255, 204, 0));
		btnLogIn.setBounds(326, 273, 175, 46);
		contentPane.add(btnLogIn);
	}

	/**
	 * 
	 * @return list of all products currently saved in Stock.txt file
	 */
	public ArrayList<Product> readListFromFile() {
		ArrayList<Product> arraylist = new ArrayList<>();
		ReadingFromStockFile rfsf = new ReadingFromStockFile(arraylist);
		rfsf.readFile();
		rfsf.sortStock(arraylist);
		return arraylist;
	}
}
