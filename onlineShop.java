package onlineShopApplication;

import java.util.ArrayList;

/**
 * OnlineShop class holds a database of products, a cart, and a recommender
 * system. It handles total amount owed and completed transactions.
 * 
 * @author Ashley C
 *
 */
public class onlineShop {
	private ProductDatabase productDB;
	private ArrayList<Product> cart = new ArrayList<Product>();
	private RecommenderSystem recommender;

	public onlineShop(ProductDatabase productDataBase, ArrayList<PurchaseHistory> purchaseHistory) {
		this.productDB = productDataBase;
		this.cart = new ArrayList<Product>();
		this.recommender = new RecommenderSystem();
	}

	/**
	 * returns an array list of products which have been recommended based on the
	 * user's cart items.
	 * 
	 * @return ArrayList<Product>
	 */
	public ArrayList<Product> getRecommendedProducts() {
		return this.recommender.productRecommenderAlgorithm(cart, 2);
	}

	/**
	 * Returns a boolean when called. This relates to whether the item was
	 * successfully added to the cart or not.
	 * 
	 * @param product
	 * @return boolean
	 */
	public boolean addToCart(Product product) {
		return this.cart.add(product);
	}

	/**
	 * This returns a list of the products in the database
	 * 
	 * @return ArrayList<Product>
	 */
	public ArrayList<Product> getProductListing() {
		return this.productDB.getDatabase();
	}

	/**
	 * Returns an array list of products which is populated by the user's selected
	 * items
	 * 
	 * @return
	 */
	public ArrayList<Product> getShoppingCart() {
		return this.cart;
	}

	/**
	 * Calculates and returns the total of price values in user's cart array
	 * 
	 * @return total
	 */
	public double amountOwing() {
		int size = this.cart.size();
		double total = 0.00;
		for (int itemList = 0; itemList < size; itemList++) {
			total = total + this.cart.get(itemList).getPrice();
		}
		return total;
	}

	/**
	 * This clears the user's cart array list upon completion of transaction.
	 */
	public void completeTransaction() {
		this.getShoppingCart().clear();
	}
}
