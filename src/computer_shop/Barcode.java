package computer_shop;

/**
 * 
 * @author abetlej
 *         <p>
 *         Used to create <code>Product</code>'s barcodes of length 6
 *         </p>
 */
public class Barcode {
	private int Value;

	/**
	 * 
	 * @param Value an integer that is meant to be a <code>Product</code>'s barcode
	 */
	public Barcode(int Value) {
		if (checkIfCorrect(Value)) {
			this.Value = Value;
		} else {
			System.out.println("Wrong barcode");
			AddProductErrorFrame apef = new AddProductErrorFrame();
			apef.setVisible(true);
		}
	}

	/**
	 * @param Value an integer that is meant to be a <code>Product</code>'s barcode
	 * @return true if integers length is equal to 6
	 */
	public boolean checkIfCorrect(int Value) {
		return (String.valueOf(Value).length() == 6);
	}

	/**
	 * 
	 * @return barcode's value
	 */
	public int getValue() {
		return this.Value;
	}
}
