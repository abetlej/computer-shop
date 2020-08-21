package computer_shop;

import java.util.*;
import java.io.File;

/**
 * 
 * @author abetlej
 *         <p>
 *         Used to manage <code>Product</code>s read from Stock.txt file
 *         </p>
 */
public class ReadingFromStockFile {
	private String fileName;
	private ArrayList<Product> ProductArray;
	private ArrayList<Barcode> BarcodeArray;

	/**
	 * 
	 * @param ProductArray
	 */
	public ReadingFromStockFile(ArrayList<Product> ProductArray) {
		this.fileName = "Stock.txt";
		this.ProductArray = ProductArray;
		this.BarcodeArray = new ArrayList<Barcode>();
	}

	/**
	 * reading from Stock.txt file
	 */
	public void readFile() {
		Scanner fileScanner = null;
		try {
			File inputFile = new File(this.fileName);
			fileScanner = new Scanner(inputFile);
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				if (line != "") {
					String arrayLine[] = line.split(",");
					// creating parameters used for both types of product
					Barcode Barcode = new Barcode(Integer.parseInt(arrayLine[0].trim()));
					BarcodeArray.add(Barcode);
					String Brand = arrayLine[3].trim();
					String Colour = arrayLine[4].trim();
					Connectivity connectivity = Connectivity.valueOf((arrayLine[5].trim()).toUpperCase());
					int Quantity = Integer.parseInt(arrayLine[6].trim());
					double OriginalCost = Double.parseDouble(arrayLine[7].trim());
					double RetailPrice = Double.parseDouble(arrayLine[8].trim());
					// checking whether the object is a Mouse or a Keyboard
					MouseOrKeyboard mouseOrKeyboard = MouseOrKeyboard.valueOf((arrayLine[1].trim()).toUpperCase());
					// creating Mouse Object
					if (mouseOrKeyboard == MouseOrKeyboard.MOUSE) {
						MouseType Type = MouseType.valueOf((arrayLine[2].trim()).toUpperCase());
						int Buttons = Integer.parseInt(arrayLine[9].trim());
						ProductArray.add(new Mouse(Barcode, Type, Brand, Colour, connectivity, Quantity, OriginalCost,
								RetailPrice, Buttons));
					}
					// creating Keyboard Object
					if (mouseOrKeyboard == MouseOrKeyboard.KEYBOARD) {
						KeyboardType Type = KeyboardType.valueOf((arrayLine[2].trim()).toUpperCase());
						Layout layout = Layout.valueOf((arrayLine[9].trim()).toUpperCase());
						ProductArray.add(new Keyboard(Barcode, Type, Brand, Colour, connectivity, Quantity,
								OriginalCost, RetailPrice, layout));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			fileScanner.close();
		}
	}

	/**
	 * 
	 * @param productArray Sorting product based on quantity
	 */
	public void sortStock(ArrayList<Product> productArray) {
		QuantityComparator qc = new QuantityComparator();
		Collections.sort(productArray, qc);
	}

	/**
	 * 
	 * @return array of all barcodes already saved in Stock.txt
	 */
	public ArrayList<Barcode> getBarcodeArray() {
		return BarcodeArray;
	}
}
