package computer_shop;

import java.util.Comparator;

/**
 * 
 * @author abetlej
 *         <p>
 *         Used to sort products based on their quantity (from highest to
 *         lowest)
 *         </p>
 */
public class QuantityComparator implements Comparator<Product> {
	@Override
	public int compare(Product p1, Product p2) {
		if (p1.getQuantity() < p2.getQuantity())
			return 1;
		if (p1.getQuantity() > p2.getQuantity())
			return -1;
		else
			return 0;
	}
}
