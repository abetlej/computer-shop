package computer_shop;

import java.util.*;
import java.io.File;

/**
 * 
 * @author abetlej
 *         <p>
 *         Used to manage <code>User</code>s read from UserAccounts.txt file
 *         </p>
 */
public class ReadingFromUserAccountsFile {
	private String fileName;
	private HashMap<String, User> UserMap;

	/**
	 * 
	 * @param UserMap map that maps user to her/his user ID
	 */
	public ReadingFromUserAccountsFile(HashMap<String, User> UserMap) {
		this.fileName = "UserAccounts.txt";
		this.UserMap = UserMap;
	}

	/**
	 * Reading from UserAccounts.txt file
	 */
	public void readFile() {
		Scanner fileScanner = null;
		try {
			File inputFile = new File(fileName);
			fileScanner = new Scanner(inputFile);
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String arrayLine[] = line.split(",");
				// creating parameters used for both types of product
				int UserId = Integer.parseInt(arrayLine[0].trim());
				String Username = arrayLine[1].trim();
				String Surname = arrayLine[2].trim();
				int HouseNumber = Integer.parseInt(arrayLine[3].trim());
				String Postcode = arrayLine[4].trim();
				String City = arrayLine[5].trim();
				// checking whether the object is an Admin or a Customer
				String AdminOrCustomer = arrayLine[6].trim();
				if (UserMap.containsKey(Username)) {
					System.out.println("Username \"" + Username + "\" is repeated");
					UserMap.remove(Username);
				} else {
					// creating Admin Object
					if (AdminOrCustomer.equals("admin")) {
						UserMap.put(Username,
								(new Admin(UserId, Username, Surname, new Address(HouseNumber, Postcode, City))));
					}
					// creating Customer Object
					if (AdminOrCustomer.equals("customer")) {
						UserMap.put(Username,
								(new Customer(UserId, Username, Surname, new Address(HouseNumber, Postcode, City))));
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
}
