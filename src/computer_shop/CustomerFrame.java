package computer_shop;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 * 
 * @author abetlej
 *         <p>
 *         Used to allow <code>Customer</code> to view all the
 *         <code>Product</code>s and add them to <code>ShoppingBasket</code>
 *         </p>
 */
public class CustomerFrame extends JFrame {
	private Customer customer;
	private ArrayList<Product> ProductArray;
	private double total;
	/**
	 * 
	 */
	private JPanel contentPane;
	private JTable jtProducts;
	private DefaultTableModel dtmProducts;
	private JCheckBox chckbxUKLayout;
	private JCheckBox chckbxLogitech;
	private JTable jtBasket;
	private static DefaultTableModel dtmBasket;
	private JSpinner spinner;
	private JLabel lblTotalValue;

	int row_num;

	/**
	 * Launch the application.
	 */
	public static void main(Customer customer, ArrayList<Product> productArray) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerFrame frame = new CustomerFrame(customer, productArray);
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
	public CustomerFrame(Customer customer, ArrayList<Product> productArray) {
		this.customer = customer;
		this.ProductArray = productArray;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1151, 607);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlDkShadow);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblProducts = new JLabel("Product List");
		lblProducts.setForeground(new Color(255, 204, 0));
		lblProducts.setBackground(new Color(255, 204, 0));
		lblProducts.setFont(new Font("Courier New", Font.BOLD, 20));
		lblProducts.setBounds(30, 29, 214, 49);
		contentPane.add(lblProducts);

		JLabel lblBasket = new JLabel("Your basket");
		lblBasket.setForeground(new Color(255, 204, 0));
		lblBasket.setFont(new Font("Courier New", Font.BOLD, 20));
		lblBasket.setBounds(948, 29, 145, 49);
		contentPane.add(lblBasket);

		JButton btnAddToBasket = new JButton("Add to basket");
		btnAddToBasket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				row_num = jtProducts.getSelectedRow();
				if (row_num >= 0) {
					String barcode = jtProducts.getValueAt(row_num, 0).toString();
					for (Product p : ProductArray) { // looking for product with selected barcode
						if (String.valueOf(p.getBarcode()).equals(barcode)) {
							System.out.println(p.toStringCustomer());
							int amount = Integer.parseInt(spinner.getValue().toString());
							if (customer.getShoppingBasket().addToBasket(p, amount)) { // adding selected item to
																						// customer's basket
								total += amount * p.getRetailPrice(); // calculations for new total value
								total = total * 100;
								total = Math.round(total);
								total = total / 100;
								customer.getShoppingBasket().setTotal(total);
								lblTotalValue.setText(String.valueOf(total)); // changing label to a new total value
							}
							spinner.setValue(1);
						}
					}
					// changing basket table displayed in the frame
					CustomerFrame.getDTMBasket().setRowCount(0);
					Set<Map.Entry<Product, Integer>> basketEntries = customer.getShoppingBasket().getBasketItems()
							.entrySet();
					Iterator<Map.Entry<Product, Integer>> basketIterator = basketEntries.iterator();
					while (basketIterator.hasNext()) {
						Map.Entry<Product, Integer> entry = basketIterator.next();
						int Barcode = entry.getKey().getBarcode();
						int quantity = entry.getValue();
						double totalPrice = entry.getKey().getRetailPrice() * quantity;
						Object[] rowData = new Object[] { Barcode, quantity, totalPrice };
						CustomerFrame.addToDTM(rowData);
					}
					QuantityComparator qc = new QuantityComparator(); // sorting an array of products based on their new
																		// quantity values
					Collections.sort(ProductArray, qc);
					showList(ProductArray);
				}
			}
		});
		btnAddToBasket.setBackground(new Color(255, 204, 0));
		btnAddToBasket.setForeground(new Color(0, 0, 0));
		btnAddToBasket.setFont(new Font("Courier New", Font.BOLD, 16));
		btnAddToBasket.setBounds(525, 432, 198, 33);
		contentPane.add(btnAddToBasket);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 152, 683, 264);
		contentPane.add(scrollPane);

		jtProducts = new JTable();
		jtProducts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtProducts.setBorder(null);
		jtProducts.setFont(new Font("Courier New", Font.PLAIN, 14));
		jtProducts.setBackground(UIManager.getColor("ScrollPane.background"));
		scrollPane.setViewportView(jtProducts);
		jtProducts.setFocusable(false);
		jtProducts.setRowSelectionAllowed(true);
		dtmProducts = new DefaultTableModel();
		dtmProducts.setColumnIdentifiers(new Object[] { "Barcode", "Brand", "Colour", "Connectivity", "Quantity",
				"Price", "Type", "Layout/Buttons" });
		jtProducts.setModel(dtmProducts);
		showList(ProductArray);

		chckbxUKLayout = new JCheckBox("UK Layout");
		chckbxUKLayout.addActionListener(new ActionListener() {
			// changes in checkbox for UK layout
			public void actionPerformed(ActionEvent e) {
				if (chckbxUKLayout.isSelected()) {
					if (chckbxLogitech.isSelected()) { // user wants to the Logitech keyboards with UK Layout
						SearchQuery sq = new SearchQuery(ProductArray, "UKLayoutAndLogitech");
						showList(sq.getResultList());
					} else { // user wants to see keyboards with UK layout
						SearchQuery sq = new SearchQuery(ProductArray, "UKLayout");
						showList(sq.getResultList());
					}
				} else {
					if (chckbxLogitech.isSelected()) { // user wants to see Logitech products
						SearchQuery sq = new SearchQuery(ProductArray, "Logitech");
						showList(sq.getResultList());
					} else { // user does not want to search for any specific product
						showList(ProductArray);
					}
				}
			}
		});
		chckbxUKLayout.setFont(new Font("Courier New", Font.PLAIN, 16));
		chckbxUKLayout.setForeground(new Color(255, 204, 0));
		chckbxUKLayout.setBackground(SystemColor.controlDkShadow);
		chckbxUKLayout.setBounds(159, 101, 139, 29);
		contentPane.add(chckbxUKLayout);

		chckbxLogitech = new JCheckBox("By Logitech");
		chckbxLogitech.addActionListener(new ActionListener() {
			// changes in checkbox for Logitech
			public void actionPerformed(ActionEvent e) {
				if (chckbxLogitech.isSelected()) {
					if (chckbxUKLayout.isSelected()) {// user wants to the Logitech keyboards with UK Layout
						SearchQuery sq = new SearchQuery(ProductArray, "UKLayoutAndLogitech");
						showList(sq.getResultList());
					} else { // user wants to see Logitech products
						SearchQuery sq = new SearchQuery(ProductArray, "Logitech");
						showList(sq.getResultList());
					}
				} else {
					if (chckbxUKLayout.isSelected()) { // user wants to see keyboards with UK layout
						SearchQuery sq = new SearchQuery(ProductArray, "UKLayout");
						showList(sq.getResultList());
					} else {// user does not want to search for any specific product
						showList(ProductArray);
					}
				}
			}
		});
		chckbxLogitech.setBackground(SystemColor.controlDkShadow);
		chckbxLogitech.setForeground(new Color(255, 204, 0));
		chckbxLogitech.setFont(new Font("Courier New", Font.PLAIN, 16));
		chckbxLogitech.setBounds(305, 104, 163, 29);
		contentPane.add(chckbxLogitech);

		JLabel lblFilter = new JLabel("Filter:");
		lblFilter.setForeground(new Color(255, 204, 0));
		lblFilter.setFont(new Font("Courier New", Font.PLAIN, 16));
		lblFilter.setBackground(SystemColor.controlDkShadow);
		lblFilter.setBounds(40, 82, 108, 20);
		contentPane.add(lblFilter);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(829, 107, 270, 208);
		contentPane.add(scrollPane_1);

		jtBasket = new JTable();
		scrollPane_1.setViewportView(jtBasket);
		jtBasket.setFont(new Font("Courier New", Font.PLAIN, 16));
		dtmBasket = new DefaultTableModel();
		dtmBasket.setColumnIdentifiers(new Object[] { "Barcode", "Quantity", "Total price" });
		jtBasket.setModel(dtmBasket);

		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setForeground(new Color(255, 204, 0));
		lblAmount.setFont(new Font("Courier New", Font.BOLD, 18));
		lblAmount.setBounds(79, 437, 77, 28);
		contentPane.add(lblAmount);

		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner.setBounds(171, 428, 77, 39);
		contentPane.add(spinner);

		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setForeground(new Color(255, 204, 0));
		lblTotal.setFont(new Font("Courier New", Font.BOLD, 26));
		lblTotal.setBounds(839, 335, 116, 39);
		contentPane.add(lblTotal);

		lblTotalValue = new JLabel("0.0");
		lblTotalValue.setForeground(new Color(255, 204, 0));
		lblTotalValue.setFont(new Font("Courier New", Font.BOLD, 23));
		lblTotalValue.setBounds(948, 337, 145, 34);
		contentPane.add(lblTotalValue);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			// customer wants to cancel her/his shopping
			public void actionPerformed(ActionEvent e) {
				WritingToFile wtf = new WritingToFile(customer, "cancelled");
				wtf.addOnTopOfFile(); // writing to ActivityLog.txt file
				resetDTMBasket(); // emptying basket table display
				customer.getShoppingBasket().emptyBasket();
				total = 0;
				lblTotalValue.setText(String.valueOf(total));
				StartFrame st = new StartFrame();
				showList(st.readListFromFile());
				resetProductArray();
			}
		});
		btnCancel.setBackground(new Color(255, 204, 0));
		btnCancel.setFont(new Font("Courier New", Font.BOLD, 16));
		btnCancel.setBounds(840, 378, 115, 38);
		contentPane.add(btnCancel);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			// customer wants to save her/his shopping
			public void actionPerformed(ActionEvent e) {
				WritingToFile wtf = new WritingToFile(customer, "saved");
				wtf.addOnTopOfFile(); // writing to ActivityLog.txt file
				resetDTMBasket(); // emptying basket table display
				customer.getShoppingBasket().emptyBasket();
				total = 0;
				lblTotalValue.setText(String.valueOf(total));
				StartFrame st = new StartFrame();
				showList(st.readListFromFile());
				resetProductArray();
			}
		});
		btnSave.setFont(new Font("Courier New", Font.BOLD, 16));
		btnSave.setBackground(new Color(255, 204, 0));
		btnSave.setBounds(978, 378, 115, 38);
		contentPane.add(btnSave);

		JButton btnPayPalPayment = new JButton("PayPal");
		btnPayPalPayment.addActionListener(new ActionListener() {
			// user wants to pay using Pay Pal
			public void actionPerformed(ActionEvent e) {
				if (!(customer.getShoppingBasket().getBasketItems().isEmpty())) {
					PayPalPaymentFrame pppf = new PayPalPaymentFrame(customer, ProductArray);
					pppf.setVisible(true);
					dispose();
				}
			}
		});
		btnPayPalPayment.setFont(new Font("Courier New", Font.BOLD, 16));
		btnPayPalPayment.setBackground(new Color(255, 204, 0));
		btnPayPalPayment.setBounds(829, 480, 115, 38);
		contentPane.add(btnPayPalPayment);

		JButton btnCreditCard = new JButton("Credit Card");
		btnCreditCard.addActionListener(new ActionListener() {
			// user wants to pay by credit card
			public void actionPerformed(ActionEvent e) {
				if (!(customer.getShoppingBasket().getBasketItems().isEmpty())) {
					CreditCardPaymentFrame ccpf = new CreditCardPaymentFrame(customer, ProductArray);
					ccpf.setVisible(true);
					dispose();
				}
			}
		});
		btnCreditCard.setFont(new Font("Courier New", Font.BOLD, 16));
		btnCreditCard.setBackground(new Color(255, 204, 0));
		btnCreditCard.setBounds(961, 480, 153, 38);
		contentPane.add(btnCreditCard);

		JLabel lblPayment = new JLabel("Payment");
		lblPayment.setForeground(new Color(255, 204, 0));
		lblPayment.setFont(new Font("Courier New", Font.BOLD, 18));
		lblPayment.setBounds(925, 445, 108, 36);
		contentPane.add(lblPayment);

		JLabel lblNewLabel = new JLabel("Click on the product and then change the amount");
		lblNewLabel.setForeground(SystemColor.controlHighlight);
		lblNewLabel.setFont(new Font("Courier New", Font.PLAIN, 16));
		lblNewLabel.setBounds(200, 43, 477, 20);
		contentPane.add(lblNewLabel);

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
			Object[] rowData = new Object[] { Barcode, Brand, Colour, Connectivity, Quantity, Price, Type, Extra };
			dtmProducts.addRow(rowData);
		}
	}

	/**
	 * 
	 * @param dataRow product's characteristics displayed in basket table
	 */
	public static void addToDTM(Object[] dataRow) {
		dtmBasket.addRow(dataRow);
	}

	/**
	 * 
	 * @return DTM for basket table
	 */
	public static DefaultTableModel getDTMBasket() {
		return dtmBasket;
	}

	/**
	 * "empties" basket table
	 */
	public void resetDTMBasket() {
		dtmBasket.setRowCount(0);
	}

	public void resetProductArray() {
		StartFrame st = new StartFrame();
		this.ProductArray = st.readListFromFile();
	}
}
