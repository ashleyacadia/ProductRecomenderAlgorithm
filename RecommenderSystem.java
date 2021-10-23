package onlineShopApplication;

import java.util.ArrayList;

/**
 * RecommenderSystem class analyzes the user's cart products and creates a list
 * of recommended items based on product frequency in past transactions.
 * 
 * @author Ashley C
 *
 */
public class RecommenderSystem {

	private ArrayList<PurchaseHistory> purchaseHistories = new ArrayList<PurchaseHistory>();
	private ProductDatabase productDB;
	private ArrayList<RecommendedItem> recommended = new ArrayList<RecommendedItem>();

	public RecommenderSystem() {
		this.productDB = null;
		this.purchaseHistories = null;
		this.recommended = null;
	}

	/**
	 * Initialize RecommenderSystem
	 * 
	 * @param purchaseHistory
	 * @param productDataBase
	 */
	public RecommenderSystem(ArrayList<PurchaseHistory> purchaseHistory, ProductDatabase productDataBase) {
		this.purchaseHistories = purchaseHistory;
		this.productDB = productDataBase;
	}

	/**
	 * returns the product frequency when called.
	 * 
	 * @param product
	 * @return int
	 */
	public int getProductFreq(Product product) {
		return recommended.get(recommended.indexOf(product)).getFrequency();
	}

	/**
	 * updates the frequency of a product when brought
	 * 
	 * @param product
	 */
	public void updateProductFreq(Product product) {
		// confusion
		recommended.get(recommended.indexOf(product))
				.setFrequency(recommended.get(recommended.indexOf(product)).getFrequency() + 1);
	}

	/**
	 * An algorithm which returns an array of suggested products based on the user's
	 * cart items.
	 * 
	 * @param cart
	 * @param frequency
	 * @return recToCustomer
	 */
	public ArrayList<Product> productRecommenderAlgorithm(ArrayList<Product> cart, int frequency) {
		// unsure creating a new array list of items similar to ones purchased
		// freq less than 2 ignored.
		// freq over 2 add to list, compare
		ArrayList<Product> recToCustomer = new ArrayList<Product>();

		return recToCustomer;
	}
}
