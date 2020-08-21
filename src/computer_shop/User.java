package computer_shop;

import java.util.ArrayList;

/**
 * 
 * @author abetlej
 *         <p>
 *         Someone who uses the system Can be: admin/customer
 *         </p>
 */
public abstract class User {
	private int UserId;
	private String Username;
	private String Surname;
	private Address Address;

	/**
	 * 
	 * @param UserId
	 * @param Username
	 * @param Surname
	 * @param Address
	 */
	public User(int UserId, String Username, String Surname, Address Address) {
		this.UserId = UserId;
		this.Username = Username;
		this.Surname = Surname;
		this.Address = Address;
	}

	/**
	 * 
	 * @return user's username
	 */
	public String getUsername() {
		return this.Username;
	}

	/**
	 * 
	 * @return user's ID
	 */
	public int getUserId() {
		return this.UserId;
	}

	/**
	 * 
	 * @return user's address
	 */
	public Address getAddress() {
		return this.Address;
	}

	/**
	 * 
	 * @return formatted information about user
	 */
	public String toString() {
		return "Username: " + this.Username + ", Surname: " + this.Surname + ", Address: "
				+ this.Address.getHouseNumber() + ", " + this.Address.getCity() + ", " + this.Address.getPostcode();
	}
}
