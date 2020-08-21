package computer_shop;

import java.util.*;

/**
 * 
 * @author abetlej
 *         <p>
 *         Each customer is assigned a shopping basket that stores item she/he
 *         wants to buy
 *         </p>
 */
public class ShoppingBasket {
	private double total;

	HashMap<Product, Integer> BasketItems = new HashMap<>();// mapping the amount of product user wants to buy to
															// product

	/**
	 * Adding product to basket
	 * 
	 * @param p      product selected by user
	 * @param amount how many products of this type customer wants to buy
	 */
	public boolean addToBasket(Product p, int amount) {
		boolean notInBasket = true;
		boolean addingToBasket = true;
		if (p.getQuantity() - amount >= 0) {
			for (Product key : BasketItems.keySet()) {
				if (key.getBarcode() == p.getBarcode()) {
					int quantity = BasketItems.get(key);
					quantity += amount;
					BasketItems.replace(key, quantity);
					p.setQuantity(amount); // changing product's quantity
					notInBasket = false;
				}
			}
			if (notInBasket) {
				BasketItems.put(p, amount);
				p.setQuantity(amount); // changing product's quantity
			}
		} else {
			QuantityErrorFrame qef = new QuantityErrorFrame();
			qef.setVisible(true);
			addingToBasket = false;
		}
		return addingToBasket;
	}

	/**
	 * Clearing basket
	 */
	public void emptyBasket() {
		BasketItems.clear();
	}

	/**
	 * 
	 * @return map of products in basket and amount user wants to buy
	 */
	public HashMap<Product, Integer> getBasketItems() {
		return this.BasketItems;
	}

	/**
	 * 
	 * @return total value of products in basket in GBP
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * 
	 * @param total updating total
	 */
	public void setTotal(double total) {
		this.total = total;
	}
}
