package computer_shop;

import java.util.ArrayList;

/**
 * 
 * @author abetlej
 *         <p>
 *         User to sort products in stock based on customer's preferences
 *         </p>
 */
public class SearchQuery {
	private ArrayList<Product> InputList;
	private ArrayList<Product> ResultList;
	private String typeOfSearch;

	/**
	 * 
	 * @param InputList    list of all products in sotck
	 * @param typeOfSearch specifies what custmoer is lookinf for, can be: UK
	 *                     Layout/Logitech/both
	 */
	public SearchQuery(ArrayList<Product> InputList, String typeOfSearch) {
		this.InputList = InputList;
		this.typeOfSearch = typeOfSearch;
		if (typeOfSearch == "Logitech") {
			this.ResultList = showLogitech(InputList);
		} else if (typeOfSearch == "UKLayout") {
			this.ResultList = showUKLayout(InputList);
		} else {
			this.ResultList = showUKLayoutAndLogitech(InputList);
		}
	}

	/**
	 * 
	 * @return products that are in category customer is searching for
	 */
	public ArrayList<Product> getResultList() {
		return this.ResultList;
	}

	/**
	 * 
	 * @param arraylist list of products
	 * @return keyboards with UK layout made by Logitech
	 */
	public ArrayList<Product> showUKLayoutAndLogitech(ArrayList<Product> arraylist) {
		ArrayList<Product> result = new ArrayList<>();
		for (Product p : arraylist) {
			if (p instanceof Keyboard) {
				Keyboard k = (Keyboard) p;
				if (k.getLayout() == Layout.UK && k.getBrand().toLowerCase().equals("logitech")) {
					result.add(p);
				}
			}
		}
		return result;
	}

	/**
	 * 
	 * @param arraylist list of products
	 * @return list of keyboards with UK layout
	 */
	public ArrayList<Product> showUKLayout(ArrayList<Product> arraylist) {
		ArrayList<Product> result = new ArrayList<>();
		for (Product p : arraylist) {
			if (p instanceof Keyboard) {
				Keyboard k = (Keyboard) p;
				if (k.getLayout() == Layout.UK) {
					result.add(p);
				}
			}
		}
		return result;
	}

	/**
	 * 
	 * @param arraylist list of products
	 * @return list of Logitech products that are in stock
	 */
	public ArrayList<Product> showLogitech(ArrayList<Product> arraylist) {
		ArrayList<Product> result = new ArrayList<>();
		for (Product p : arraylist) {
			if (p.getBrand().toLowerCase().equals("logitech")) {
				result.add(p);
			}
		}
		return result;
	}

}
