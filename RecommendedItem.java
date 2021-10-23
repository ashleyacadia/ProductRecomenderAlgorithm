package onlineShopApplication;

/**
 * This class creates a blue print for a recommended item. It enables a product
 * and frequency to be set.
 * 
 * @author Ashley C
 *
 */
public class RecommendedItem {
	protected Product product;
	protected int frequency;

	/**
	 * Initializes RecommendedItem and populates the variables
	 * 
	 * @param product
	 * @param frequency
	 */
	public RecommendedItem(Product product, int frequency) {
		this.product = product;
		this.frequency = frequency;
	}

	/**
	 * gets product
	 * 
	 * @return product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * set product
	 * 
	 * @param product
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * returns frequency of product when called
	 * 
	 * @return frequency
	 */
	public int getFrequency() {
		return frequency;
	}

	/**
	 * sets new frequency of product once brought
	 * 
	 * @param frequency
	 */

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

}
