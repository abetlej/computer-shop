package computer_shop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * @author abetlej
 *         <p>
 *         Used when one of files (Stock.txt/UserAccounts.txt/ActivityLog.txt)
 *         needs to be updated
 *         </p>
 */
public class WritingToFile {
	private String fileName;
	private String lineToWrite;
	private ArrayList<Product> ProductArray;
	private Customer customer;
	private HashMap<Product, Integer> BasketItems;
	private String ActivityType;
	private String PaymentMethod;

	/**
	 * 
	 * @param fileName    name of a file that will be updated
	 * @param lineToWrite line that will be added to a file
	 */
	public WritingToFile(String fileName, String lineToWrite) {
		this.fileName = fileName;
		this.lineToWrite = lineToWrite;
	}

	/**
	 * 
	 * @param fileName     name of a file that will be updated
	 * @param ProductArray list of products
	 */
	public WritingToFile(String fileName, ArrayList<Product> ProductArray) {
		this.fileName = fileName;
		this.ProductArray = ProductArray;
		;
	}

	/**
	 * 
	 * @param customer      customer that logged in to system
	 * @param ActivityType  which activity out of: save/cancel/pay is performed
	 * @param PaymentMethod if activity == pay, in which way customer pays for
	 *                      her/his shopping
	 */
	public WritingToFile(Customer customer, String ActivityType, String PaymentMethod) {
		this.customer = customer;
		this.BasketItems = customer.getShoppingBasket().getBasketItems();
		this.ActivityType = ActivityType;
		this.PaymentMethod = PaymentMethod;
	}

	/**
	 * 
	 * @param customer     customer that logged in to system
	 * @param ActivityType which activity out of: save/cancel/pay is performed
	 */
	public WritingToFile(Customer customer, String ActivityType) {
		this(customer, ActivityType, " ");
	}

	/**
	 * for adding a line at the end of file
	 */
	public void addToFile() {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(fileName, true));
			bw.write(this.lineToWrite + "\n");

		} catch (IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
			} catch (IOException e) {
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}

	/**
	 * updating Stock.txt file
	 */
	public void writeStockFile() {
		BufferedWriter bw = null;
		BarcodeComparator bc = new BarcodeComparator();
		Collections.sort(ProductArray, bc);
		try {
			bw = new BufferedWriter(new FileWriter(fileName));
			for (Product p : ProductArray) {
				bw.write(p.toFileLine() + "\n");
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
			} catch (IOException e) {
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}

	/**
	 * adding line at the top of a file
	 */
	public void addOnTopOfFile() {
		BufferedWriter bw = null;
		Scanner fileScanner = null;
		ArrayList<String> previousFileRecord = new ArrayList<>();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		try {
			File inputFile = new File("ActivityLog.txt");
			fileScanner = new Scanner(inputFile);
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				previousFileRecord.add(line);
			}
			bw = new BufferedWriter(new FileWriter("ActivityLog.txt"));
			java.util.Date today = java.util.Calendar.getInstance().getTime(); // getting today's date
			Set<Map.Entry<Product, Integer>> basketEntries = customer.getShoppingBasket().getBasketItems().entrySet();
			Iterator<Map.Entry<Product, Integer>> basketIterator = basketEntries.iterator();
			while (basketIterator.hasNext()) { // for all items in basket
				Map.Entry<Product, Integer> entry = basketIterator.next();
				int Barcode = entry.getKey().getBarcode();
				double retailPrice = entry.getKey().getRetailPrice();
				int quantity = entry.getValue();
				String line = customer.getUserId() + ", " + customer.getAddress().getPostcode() + ", " + Barcode + ", "
						+ retailPrice + ", " + quantity + ", " + ActivityType + ", " + PaymentMethod + ", "
						+ formatter.format(today);
				bw.write(line + "\n"); // adding new line at the top of file
			}
			for (String line : previousFileRecord) { // getting all the previous record saved in ActivityLog.txt
				bw.write(line + "\n");
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
			} catch (IOException e) {
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}
}
