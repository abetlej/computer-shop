package computer_shop;

/**
 * 
 * @author abetlej
 *         <p>
 *         Used when <code>Customer</code> wants to pay for items in her/his
 *         basket
 *         </p>
 */
public abstract class PaymentMethod {

	/**
	 * 
	 * @param total worth of all products in a basket
	 * @return a suitable message about how much was paid and using which method
	 */
	public String showMessage(double total) {
		return (total + " paid");
	}
}
