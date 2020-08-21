package computer_shop;

/**
 * 
 * @author abetlej
 *         <p>
 *         Class used for payment using Pay Pal
 *         </p>
 */
public class PayPalPayment extends PaymentMethod {
	private String Email;

	/**
	 * 
	 * @param Email user's email address
	 */
	public PayPalPayment(String Email) {
		this.Email = Email;
	}

	/**
	 * 
	 * @return true if input is an email address
	 */
	public boolean checkIfEmail() {
		return (Email.indexOf('@') > 0);
	}

	@Override
	public String showMessage(double total) {
		return (total + " paid using PayPal");
	}
}
