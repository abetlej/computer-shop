package computer_shop;

/**
 * 
 * @author abetlej
 *         <p>
 *         Class used for payments by card.
 *         </p>
 */
public class CreditCardPayment extends PaymentMethod {
	private String CardNumber;
	private String SecurityCode;

	/**
	 * @param CardNumber
	 * @param SecurityCode
	 */
	public CreditCardPayment(String CardNumber, String SecurityCode) {
		this.CardNumber = CardNumber;
		this.SecurityCode = SecurityCode;
	}

	/**
	 * 
	 * @return true if card number's length equals 16
	 */
	public boolean checkCardNumber() {
		return (CardNumber.length() == 16);
	}

	/**
	 * 
	 * @return true if security number's length equals 3
	 */
	public boolean checkSecurityCode() {
		return (SecurityCode.length() == 3);
	}

	@Override
	public String showMessage(double total) {
		return (total + " paid using Credit Card");
	}
}
