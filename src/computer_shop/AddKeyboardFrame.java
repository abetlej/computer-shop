package computer_shop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

/**
 * @author abetlej
 *         <p>
 *         A frame used to allow <code>Admin</code> user to add a new
 *         <code>Keyboard</code> to stock. Displays fields that
 *         <code>Admin</code> needs to complete in order to add new
 *         <code>Keyboard</code>:
 *         <ul>
 *         <li>Barcode</li>
 *         <li>Brand</li>
 *         <li>Colour</li>
 *         <li>Connectivity</li>
 *         <li>Quantity</li>
 *         <li>Retail Price</li>
 *         <li>Original Cost</li>
 *         <li>Type</li>
 *         <li>Layout</li>
 *         </ul>
 *         </p>
 */
public class AddKeyboardFrame extends JFrame {
	private ArrayList<Barcode> BarcodeArray;

	private JPanel contentPane;
	private JTextField jtBarcode;
	private JTextField jtBrand;
	private JTextField jtColour;
	private JTextField jtRetailPrice;
	private JTextField jtOriginalCost;
	private JSpinner jsQuantity;
	private JComboBox cbConnectivity;
	private JComboBox cbType;
	private JComboBox cbLayout;

	/**
	 * Launch the application.
	 */
	public static void main(ArrayList<Barcode> BarcodeArray) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddKeyboardFrame frame = new AddKeyboardFrame(BarcodeArray);
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
	public AddKeyboardFrame(ArrayList<Barcode> BarcodeArray) {
		this.BarcodeArray = BarcodeArray;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 639);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlDkShadow);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBarcode = new JLabel("Barcode");
		lblBarcode.setBackground(SystemColor.controlDkShadow);
		lblBarcode.setForeground(new Color(255, 204, 0));
		lblBarcode.setFont(new Font("Courier New", Font.BOLD, 16));
		lblBarcode.setBounds(61, 62, 125, 35);
		contentPane.add(lblBarcode);

		JLabel lblBrand = new JLabel("Brand");
		lblBrand.setForeground(new Color(255, 204, 0));
		lblBrand.setFont(new Font("Courier New", Font.BOLD, 16));
		lblBrand.setBackground(SystemColor.controlDkShadow);
		lblBrand.setBounds(61, 113, 125, 35);
		contentPane.add(lblBrand);

		JLabel lblColour = new JLabel("Colour");
		lblColour.setForeground(new Color(255, 204, 0));
		lblColour.setFont(new Font("Courier New", Font.BOLD, 16));
		lblColour.setBackground(SystemColor.controlDkShadow);
		lblColour.setBounds(61, 164, 125, 35);
		contentPane.add(lblColour);

		JLabel lblConnectivity = new JLabel("Connectivity");
		lblConnectivity.setForeground(new Color(255, 204, 0));
		lblConnectivity.setFont(new Font("Courier New", Font.BOLD, 16));
		lblConnectivity.setBackground(SystemColor.controlDkShadow);
		lblConnectivity.setBounds(61, 215, 125, 35);
		contentPane.add(lblConnectivity);

		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setForeground(new Color(255, 204, 0));
		lblQuantity.setFont(new Font("Courier New", Font.BOLD, 16));
		lblQuantity.setBackground(SystemColor.controlDkShadow);
		lblQuantity.setBounds(61, 266, 125, 35);
		contentPane.add(lblQuantity);

		JLabel lblRetailPrice = new JLabel("Retail Price");
		lblRetailPrice.setForeground(new Color(255, 204, 0));
		lblRetailPrice.setFont(new Font("Courier New", Font.BOLD, 16));
		lblRetailPrice.setBackground(SystemColor.controlDkShadow);
		lblRetailPrice.setBounds(61, 317, 125, 35);
		contentPane.add(lblRetailPrice);

		JLabel lblOriginalCost = new JLabel("Original Cost");
		lblOriginalCost.setForeground(new Color(255, 204, 0));
		lblOriginalCost.setFont(new Font("Courier New", Font.BOLD, 16));
		lblOriginalCost.setBackground(SystemColor.controlDkShadow);
		lblOriginalCost.setBounds(61, 368, 155, 35);
		contentPane.add(lblOriginalCost);

		JLabel lblType = new JLabel("Type");
		lblType.setForeground(new Color(255, 204, 0));
		lblType.setFont(new Font("Courier New", Font.BOLD, 16));
		lblType.setBackground(SystemColor.controlDkShadow);
		lblType.setBounds(61, 419, 125, 35);
		contentPane.add(lblType);

		jtBarcode = new JTextField();
		jtBarcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtBarcode.setBounds(261, 65, 146, 26);
		contentPane.add(jtBarcode);
		jtBarcode.setColumns(10);

		jtBrand = new JTextField();
		jtBrand.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtBrand.setColumns(10);
		jtBrand.setBounds(261, 116, 146, 26);
		contentPane.add(jtBrand);

		jtColour = new JTextField();
		jtColour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtColour.setColumns(10);
		jtColour.setBounds(261, 167, 146, 26);
		contentPane.add(jtColour);

		jtRetailPrice = new JTextField();
		jtRetailPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtRetailPrice.setColumns(10);
		jtRetailPrice.setBounds(261, 320, 146, 26);
		contentPane.add(jtRetailPrice);

		jtOriginalCost = new JTextField();
		jtOriginalCost.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtOriginalCost.setColumns(10);
		jtOriginalCost.setBounds(261, 371, 146, 26);
		contentPane.add(jtOriginalCost);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					// getting user's input
					Barcode Barcode = new Barcode(Integer.parseInt(jtBarcode.getText()));
					System.out.println(Barcode);
					String Brand = jtBrand.getText();
					String Colour = jtColour.getText();
					Connectivity connectivity = Connectivity.valueOf(cbConnectivity.getSelectedItem().toString());
					int Quantity = Integer.parseInt(jsQuantity.getValue().toString());
					double OriginalCost = Double.parseDouble(jtOriginalCost.getText());
					double RetailPrice = Double.parseDouble(jtRetailPrice.getText());
					KeyboardType Type = KeyboardType.valueOf(cbType.getSelectedItem().toString());
					Layout layout = Layout.valueOf(cbLayout.getSelectedItem().toString());
					if (Barcode.checkIfCorrect(Barcode.getValue())) {
						// checking if item with this barcode is already in stock
						if (!(checkIfBarcodeInArray(BarcodeArray, Barcode))) {// if it is not in stock it is added to
																				// stock
							Keyboard k1 = new Keyboard(Barcode, Type, Brand, Colour, connectivity, Quantity,
									OriginalCost, RetailPrice, layout);
							System.out.println(k1.toFileLine());
							WritingToFile wtf = new WritingToFile("Stock.txt", k1.toFileLine());
							wtf.addToFile();
							AdminFrame af1 = new AdminFrame();
							af1.setVisible(true);
							dispose();
						} else {// if it is in stock the error message is displayed
							System.out.println("Product with this barcode is already in stock");
							AddProductBarcodeErrorFrame apbef = new AddProductBarcodeErrorFrame();
							apbef.setVisible(true);

						}
					}
				} catch (NumberFormatException e) { // if
					AddProductErrorFrame apef = new AddProductErrorFrame();
					apef.setVisible(true);
				}
			}
		});
		btnAdd.setBackground(new Color(255, 204, 0));
		btnAdd.setFont(new Font("Courier New", Font.BOLD, 18));
		btnAdd.setBounds(201, 540, 146, 35);
		contentPane.add(btnAdd);

		JLabel lblInfo = new JLabel("Add Keyboard details");
		lblInfo.setForeground(new Color(255, 204, 0));
		lblInfo.setFont(new Font("Courier New", Font.BOLD, 24));
		lblInfo.setBackground(SystemColor.controlDkShadow);
		lblInfo.setBounds(95, 16, 327, 33);
		contentPane.add(lblInfo);

		jsQuantity = new JSpinner();
		jsQuantity.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		jsQuantity.setBounds(271, 262, 98, 40);
		contentPane.add(jsQuantity);

		cbConnectivity = new JComboBox();
		cbConnectivity.setModel(new DefaultComboBoxModel(Connectivity.values()));
		cbConnectivity.setBounds(261, 218, 146, 26);
		contentPane.add(cbConnectivity);

		cbType = new JComboBox();
		cbType.setModel(new DefaultComboBoxModel(KeyboardType.values()));
		cbType.setBounds(261, 422, 146, 26);
		contentPane.add(cbType);

		JLabel lblLayout = new JLabel("Layout");
		lblLayout.setForeground(new Color(255, 204, 0));
		lblLayout.setFont(new Font("Courier New", Font.BOLD, 16));
		lblLayout.setBackground(SystemColor.controlDkShadow);
		lblLayout.setBounds(61, 470, 125, 35);
		contentPane.add(lblLayout);

		cbLayout = new JComboBox();
		cbLayout.setModel(new DefaultComboBoxModel(Layout.values()));
		cbLayout.setBounds(261, 473, 146, 26);
		contentPane.add(cbLayout);
	}

	/**
	 * @param BarcodeArray An array of all the barcodes of products that are saved
	 *                     in Stock.txt file
	 * @param Barcode      A barcode of a new product
	 * @return true if barcode is already saved in a file and false otherwise
	 */
	public boolean checkIfBarcodeInArray(ArrayList<Barcode> BarcodeArray, Barcode Barcode) {
		boolean InArray = false;
		for (Barcode b : BarcodeArray) {
			if (b.getValue() == Barcode.getValue()) {
				InArray = true;
			}
		}
		return InArray;
	}
}
