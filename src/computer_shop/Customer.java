package computer_shop;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author abetlej
 *         <p>
 *         A user with rights to purchase products
 *         </p>
 */
public class Customer extends User {
	private ShoppingBasket ShoppingBasket;

	Customer(int UserId, String Username, String Surname, Address Address) {
		super(UserId, Username, Surname, Address);
		this.ShoppingBasket = new ShoppingBasket();
	}

	/**
	 * 
	 * @return customer's shopping basket
	 */
	public ShoppingBasket getShoppingBasket() {
		return ShoppingBasket;
	}
}