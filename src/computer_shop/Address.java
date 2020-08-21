package computer_shop;

/**
 * 
 * @author abetlej
 *         <p>
 *         A class used to store information about <code>User</code>'s address
 *         </p>
 */
public class Address {
	private int HouseNumber;
	private String Postcode;
	private String City;

	/**
	 * @param HouseNumber
	 * @param Postcode
	 * @param City
	 */
	public Address(int HouseNumber, String Postcode, String City) {
		this.HouseNumber = HouseNumber;
		this.Postcode = Postcode;
		this.City = City;
	}

	/**
	 * @return postcode
	 */
	public String getPostcode() {
		return this.Postcode;
	}

	/**
	 * @return house number
	 */
	public int getHouseNumber() {
		return this.HouseNumber;
	}

	/**
	 * @return city
	 */
	public String getCity() {
		return this.City;
	}
}
