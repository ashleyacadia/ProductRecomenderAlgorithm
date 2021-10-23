package onlineShopApplication;

import java.util.ArrayList;

/**
 * This class initializes an ArrayList of products
 * 
 * @author Ashley C
 *
 */
public class ProductDatabase {
	private ArrayList<Product> database = new ArrayList<Product>();

	public ProductDatabase() {
		this.database = null;
	}

	public ProductDatabase(ArrayList<Product> database) {
		this.database = database;
	}

	/**
	 * adds product to the array list
	 * 
	 * @param product
	 */
	public void put(Product product) {
		this.database.add(product);
	}

	/**
	 * gets product from integer entered
	 * 
	 * @param code
	 * @return Product
	 */
	public Product get(Integer code) {
		for (int count = 0; count < database.size(); count++) {
			if (database.get(count).getCode() == code) {
				return database.get(count);
			}
		}
		return null;
	}

	/**
	 * returns the array database
	 * 
	 * @return database
	 */
	public ArrayList<Product> getDatabase() {
		return database;
	}

}