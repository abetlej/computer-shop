package computer_shop;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author abetlej
 *         <p>
 *         Used to allow <code>Admin</code> to view all the
 *         <code>Product</code>s and add new ones
 *         </p>
 */
public class AdminFrame extends JFrame {

	private JPanel contentPane;
	private JTable jtProducts;
	private DefaultTableModel dtmProducts;
	private JLabel lblProducts;
	private JButton btnAddMouse;
	private JButton btnAddKeyboard;
	private JLabel lblAddProducts;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminFrame frame = new AdminFrame();
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
	public AdminFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 978, 603);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlDkShadow);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 87, 840, 291);
		contentPane.add(scrollPane);

		jtProducts = new JTable();
		jtProducts.setFont(new Font("Courier New", Font.PLAIN, 16));
		jtProducts.setBackground(UIManager.getColor("ScrollPane.background"));
		scrollPane.setViewportView(jtProducts);
		dtmProducts = new DefaultTableModel();
		dtmProducts.setColumnIdentifiers(new Object[] { "Barcode", "Brand", "Colour", "Connectivity", "Quantity",
				"Price", "Original Cost", "Type", "Layout/Buttons" });
		jtProducts.setModel(dtmProducts);

		lblProducts = new JLabel("Products");
		lblProducts.setForeground(new Color(255, 204, 0));
		lblProducts.setFont(new Font("Courier New", Font.BOLD, 26));
		lblProducts.setBounds(48, 50, 197, 30);
		contentPane.add(lblProducts);

		btnAddMouse = new JButton("Add MOUSE");
		btnAddMouse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddMouseFrame amf1 = new AddMouseFrame(getBarcodeArray()); // opens frame used to add mouse
				amf1.setVisible(true);
				dispose();
			}
		});
		btnAddMouse.setBackground(new Color(255, 204, 0));
		btnAddMouse.setFont(new Font("Courier New", Font.BOLD, 16));
		btnAddMouse.setBounds(333, 407, 174, 43);
		contentPane.add(btnAddMouse);

		btnAddKeyboard = new JButton("Add KEYBOARD");
		btnAddKeyboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddKeyboardFrame akf1 = new AddKeyboardFrame(getBarcodeArray()); // opens frame used to add keyboard
				akf1.setVisible(true);
				dispose();
			}
		});
		btnAddKeyboard.setFont(new Font("Courier New", Font.BOLD, 16));
		btnAddKeyboard.setBackground(new Color(255, 204, 0));
		btnAddKeyboard.setBounds(333, 466, 174, 43);
		contentPane.add(btnAddKeyboard);

		lblAddProducts = new JLabel("Add products");
		lblAddProducts.setForeground(new Color(255, 204, 0));
		lblAddProducts.setFont(new Font("Courier New", Font.BOLD, 22));
		lblAddProducts.setBackground(SystemColor.controlDkShadow);
		lblAddProducts.setBounds(127, 421, 165, 68);
		contentPane.add(lblAddProducts);
		showList(readListFromFile());

		System.out.println(getBarcodeArray());
	}

	/**
	 * 
	 * @return a list of all <code>Product</code>s already stored in Stock.txt file
	 */
	public ArrayList<Product> readListFromFile() {
		ArrayList<Product> arraylist = new ArrayList<>();
		ReadingFromStockFile rfsf = new ReadingFromStockFile(arraylist);
		rfsf.readFile();
		rfsf.sortStock(arraylist);
		return arraylist;
	}

	/**
	 * 
	 * @return a list of all <code>Barcode</code>s <code>Product</code>'s already
	 *         stored in Stock.txt file
	 */
	public ArrayList<Barcode> getBarcodeArray() {
		ArrayList<Product> arraylist = new ArrayList<>();
		ReadingFromStockFile rfsf = new ReadingFromStockFile(arraylist);
		rfsf.readFile();
		return (rfsf.getBarcodeArray());
	}

	/**
	 * 
	 * @param arraylist list of products read from a file This method is used to
	 *                  display <code>Product</code>s in a table
	 */
	public void showList(ArrayList<Product> arraylist) {
		dtmProducts.setRowCount(0);
		for (Product p : arraylist) {
			int Barcode = p.getBarcode();
			String Brand = p.getBrand();
			String Colour = p.getColour();
			String Connectivity = p.getConnectivity().toString().toLowerCase();
			int Quantity = p.getQuantity();
			double Price = p.getRetailPrice();
			double OriginalCost = p.getOriginalCost();
			String Type;
			String Extra;
			if (p instanceof Mouse) {
				Mouse m = (Mouse) p;
				Type = m.getType().toString().toLowerCase();
				Extra = String.valueOf(m.getButtons());
			} else {
				Keyboard k = (Keyboard) p;
				Type = k.getType().toString().toLowerCase();
				Extra = k.getLayout().toString();
			}
			Object[] rowData = new Object[] { Barcode, Brand, Colour, Connectivity, Quantity, Price, OriginalCost, Type,
					Extra };
			dtmProducts.addRow(rowData);
		}
	}
}
