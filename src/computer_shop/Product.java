package computer_shop;

/**
 * 
 * @author abetlej
 *         <p>
 *         Product that can be bought in the shop
 *         </p>
 */
public abstract class Product {
	private Barcode Barcode;
	private String Brand;
	private String Colour;
	private Connectivity Connectivity;
	private int Quantity;
	private double OriginalCost;
	private double RetailPrice;

	/**
	 * 
	 * @param Barcode
	 * @param Brand
	 * @param Colour
	 * @param Connectivity
	 * @param Quantity
	 * @param OriginalCost
	 * @param RetailPrice
	 */
	public Product(Barcode Barcode, String Brand, String Colour, Connectivity Connectivity, int Quantity,
			double OriginalCost, double RetailPrice) {
		this.Barcode = Barcode;
		this.Brand = Brand;
		this.Colour = Colour;
		this.Connectivity = Connectivity;
		this.Quantity = Quantity;
		this.OriginalCost = OriginalCost;
		this.RetailPrice = RetailPrice;
	}

	/**
	 * 
	 * @return barcode
	 */
	public int getBarcode() {
		return this.Barcode.getValue();
	}

	/**
	 * 
	 * @return product's brand
	 */
	public String getBrand() {
		return this.Brand;
	}

	/**
	 * 
	 * @return product's colour
	 */
	public String getColour() {
		return this.Colour;
	}

	/**
	 * 
	 * @return product's connectivity
	 */
	public Connectivity getConnectivity() {
		return this.Connectivity;
	}

	/**
	 * 
	 * @return product's quantity
	 */
	public int getQuantity() {
		return this.Quantity;
	}

	/**
	 * 
	 * @return product's original cost
	 */
	public double getOriginalCost() {
		return this.OriginalCost;
	}

	/**
	 * 
	 * @return product's retail price
	 */
	public double getRetailPrice() {
		return this.RetailPrice;
	}

	/**
	 * 
	 * @param amount how many products of this type user wants to buy
	 */
	public void setQuantity(int amount) {
		if (this.Quantity - amount >= 0) {
			this.Quantity -= amount;
		} else {
			System.out.println("Not possible! As this makes the quantity negative!");
		}
	}

	/**
	 * 
	 * @return all information about product but original cost
	 */
	public String toStringCustomer() {
		return ("Barcode: " + this.Barcode.getValue() + ", Brand: " + this.Brand + ", Colour: " + this.Colour
				+ ", Connectivity: " + this.Connectivity.toString().toLowerCase() + ", Quantity: " + this.Quantity
				+ ", Price: " + this.RetailPrice);
	}

	/**
	 * 
	 * @return all information about product
	 */
	public String toStringAdmin() {
		return ("Barcode: " + this.Barcode.getValue() + ", Brand: " + this.Brand + ", Colour: " + this.Colour
				+ ", Connectivity: " + this.Connectivity.toString().toLowerCase() + ", Quantity: " + this.Quantity
				+ ", Original Cost: " + this.OriginalCost + ", Price: " + this.RetailPrice);
	}

	/**
	 * 
	 * @return all information about product in Stock.txt line format
	 */
	public String toFileLine() {
		return (this.Barcode.getValue() + ", " + this.Brand + ", " + this.Colour + ", "
				+ this.Connectivity.toString().toLowerCase() + ", " + this.Quantity + ", " + this.OriginalCost + ", "
				+ this.RetailPrice);
	}

}
