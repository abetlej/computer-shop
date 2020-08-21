package computer_shop;

import java.util.Comparator;

/**
 * 
 * @author abetlej
 *         <p>
 *         Used to sort <code>Product</code>s based on their
 *         <code>Barcode</code> (from the lowest number to the highest)
 *         </p>
 */
public class BarcodeComparator implements Comparator<Product> {
	@Override
	public int compare(Product p1, Product p2) {
		if (p1.getBarcode() < p2.getBarcode())
			return -1;
		if (p1.getBarcode() > p2.getBarcode())
			return 1;
		else
			return 0;
	}
}
