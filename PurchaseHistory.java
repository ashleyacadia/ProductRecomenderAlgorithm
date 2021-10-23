package onlineShopApplication;

import java.util.ArrayList;

/**
 * This class contains the purchase history of a customer
 * 
 * @author Ashley C
 *
 */

public class PurchaseHistory {
	private ArrayList<Product> purchases = new ArrayList<Product>();

	public PurchaseHistory() {
		this.purchases = null;
	}

	public PurchaseHistory(ArrayList<Product> purchases) {
		this.purchases = purchases;

	}

	/**
	 * gets purchase history ArrayList of customer
	 * 
	 * @return purchases
	 */
	public ArrayList<Product> getPurchases() {
		return purchases;
	}

	/**
	 * Formats the return string
	 * 
	 * @return String
	 */
	public String toString() {
		return "Purchase history:" + purchases;
	}
}
