package computer_shop;

/**
 * 
 * @author abetlej
 *         <p>
 *         Keyboard product
 *         </p>
 */
public class Keyboard extends Product {
	private Layout Layout;
	private KeyboardType Type;

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
	 * @param Layout
	 */
	public Keyboard(Barcode Barcode, KeyboardType Type, String Brand, String Colour, Connectivity Connectivity,
			int Quantity, double OriginalCost, double RetailPrice, Layout Layout) {
		super(Barcode, Brand, Colour, Connectivity, Quantity, OriginalCost, RetailPrice);
		this.Type = Type;
		this.Layout = Layout;
	}

	/**
	 * 
	 * @return keyboard layout
	 */
	public Layout getLayout() {
		return this.Layout;
	}

	/**
	 * 
	 * @return keyboard type
	 */
	public KeyboardType getType() {
		return this.Type;
	}

	@Override
	public String toStringCustomer() {
		return ("Barcode: " + this.getBarcode() + ", Brand: " + this.getBrand() + ", Colour: " + this.getColour()
				+ ", Connectivity: " + this.getConnectivity().toString().toLowerCase() + ", Quantity: "
				+ this.getQuantity() + ", Price: " + this.getRetailPrice() + ", Type: "
				+ this.Type.toString().toLowerCase() + ", Layout: " + this.Layout);
	}

	@Override
	public String toStringAdmin() {
		return ("Barcode: " + this.getBarcode() + ", Brand: " + this.getBrand() + ", Colour: " + this.getColour()
				+ ", Connectivity: " + this.getConnectivity().toString().toLowerCase() + ", Quantity: "
				+ this.getQuantity() + ", Original Cost: " + this.getOriginalCost() + ", Price: "
				+ this.getRetailPrice() + ", Type: " + this.Type.toString().toLowerCase() + ", Layout: " + this.Layout);
	}

	@Override
	public String toFileLine() {
		return (this.getBarcode() + ", keyboard, " + this.getType().toString().toLowerCase() + ", " + this.getBrand()
				+ ", " + this.getColour() + ", " + this.getConnectivity().toString().toLowerCase() + ", "
				+ this.getQuantity() + ", " + this.getOriginalCost() + ", " + this.getRetailPrice() + ", "
				+ this.getLayout().toString());
	}
}
