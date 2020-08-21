package computer_shop;

import java.util.*;

/**
 * 
 * @author abetlej
 *         <p>
 *         A user with rights to add products to the stock and see the original
 *         cost
 *         </p>
 */
public class Admin extends User {
	public Admin(int UserId, String Username, String Surname, Address Address) {

		super(UserId, Username, Surname, Address);
	}

	/**
	 * Allows <code>Admin</code> to open a frame that would let him add a new
	 * <code>Mouse</code> to stock.
	 */
	public void addMouse() {
		Scanner inputScanner = new Scanner(System.in);
		System.out.println("Barcode: ");
		Barcode Barcode = new Barcode(inputScanner.nextInt());
		String Brand = inputScanner.next();
		String Colour = inputScanner.next();
		Connectivity connectivity = Connectivity.valueOf(inputScanner.next().toUpperCase());
		int Quantity = inputScanner.nextInt();
		double OriginalCost = inputScanner.nextDouble();
		double RetailPrice = inputScanner.nextDouble();
		MouseType Type = MouseType.valueOf(inputScanner.next().toUpperCase());
		int Buttons = inputScanner.nextInt();
		Mouse m1 = new Mouse(Barcode, Type, Brand, Colour, connectivity, Quantity, OriginalCost, RetailPrice, Buttons);
		inputScanner.close();
	}

	/**
	 * Allows <code>Admin</code> to open a frame that would let him add a new
	 * <code>Keyboard</code> to stock.
	 */
	public void addKeyboard() {
		Scanner inputScanner = new Scanner(System.in);
		System.out.println("Barcode: ");
		Barcode Barcode = new Barcode(inputScanner.nextInt());
		String Brand = inputScanner.next();
		String Colour = inputScanner.next();
		Connectivity connectivity = Connectivity.valueOf(inputScanner.next().toUpperCase());
		int Quantity = inputScanner.nextInt();
		double OriginalCost = inputScanner.nextDouble();
		double RetailPrice = inputScanner.nextDouble();
		KeyboardType Type = KeyboardType.valueOf(inputScanner.next().toUpperCase());
		Layout layout = Layout.valueOf(inputScanner.next().toUpperCase());
		Keyboard k1 = new Keyboard(Barcode, Type, Brand, Colour, connectivity, Quantity, OriginalCost, RetailPrice,
				layout);
		inputScanner.close();
	}
}
