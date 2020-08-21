package computer_shop;

/**
 * 
 * @author abetlej
 *         <p>
 *         Mouse product
 *         </p>
 */
public class Mouse extends Product {
	private int Buttons;
	private MouseType Type;

	/**
	 * 
	 * @param Barcode
	 * @param Type
	 * @param Brand
	 * @param Colour
	 * @param Connectivity
	 * @param Quantity
	 * @param OriginalCost
	 * @param RetailPrice
	 * @param Buttons
	 */
	public Mouse(Barcode Barcode, MouseType Type, String Brand, String Colour, Connectivity Connectivity, int Quantity,
			double OriginalCost, double RetailPrice, int Buttons) {
		super(Barcode, Brand, Colour, Connectivity, Quantity, OriginalCost, RetailPrice);
		// checking if the parameters are right
		if (Buttons >= 0) {
			this.Type = Type;
			this.Buttons = Buttons;
		}
	}

	/**
	 * 
	 * @return number of buttons
	 */
	public int getButtons() {
		return this.Buttons;
	}

	/**
	 * 
	 * @return mouse's type
	 */
	public MouseType getType() {
		return this.Type;
	}

	@Override
	public String toStringCustomer() {
		return ("Barcode: " + this.getBarcode() + ", Brand: " + this.getBrand() + ", Colour: " + this.getColour()
				+ ", Connectivity: " + this.getConnectivity().toString().toLowerCase() + ", Quantity: "
				+ this.getQuantity() + ", Price: " + this.getRetailPrice() + ", Type: "
				+ this.Type.toString().toLowerCase() + ", Buttons: " + this.Buttons);
	}

	@Override
	public String toStringAdmin() {
		return ("Barcode: " + this.getBarcode() + ", Brand: " + this.getBrand() + ", Colour: " + this.getColour()
				+ ", Connectivity: " + this.getConnectivity().toString().toLowerCase() + ", Quantity: "
				+ this.getQuantity() + ", Original Cost: " + this.getOriginalCost() + ", Price: "
				+ this.getRetailPrice() + ", Type: " + this.Type.toString().toLowerCase() + ", Buttons: "
				+ this.Buttons);
	}

	@Override
	public String toFileLine() {
		return (this.getBarcode() + ", mouse, " + this.getType().toString().toLowerCase() + ", " + this.getBrand()
				+ ", " + this.getColour() + ", " + this.getConnectivity().toString().toLowerCase() + ", "
				+ this.getQuantity() + ", " + this.getOriginalCost() + ", " + this.getRetailPrice() + ", "
				+ this.getButtons());
	}
}
