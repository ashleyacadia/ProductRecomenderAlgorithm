package onlineShopApplication;

/**
 * This abstract class creates the blue print for product classes. They are to
 * be created and extended from this class.
 * 
 * @author Ashley C
 *
 */
public abstract class Product implements Comparable<Product> {
	private double price;
	private int code;
	private String name;
	private String size;

	/**
	 * sets new Product
	 */
	public Product() {
		this.code = 0;
		this.price = 0;
		this.name = null;
		this.size = null;
	}

	/**
	 * sets new product with initiating values
	 * 
	 * @param code
	 * @param price
	 */
	public Product(int code, double price, String name, String size) {
		this.code = code;
		this.price = price;
		this.name = name;
		this.size = size;
	}

	/**
	 * gets product's price
	 * 
	 * @return price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * sets product's price
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * gets product's code
	 * 
	 * @return code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * sets product's code
	 * 
	 * @param code
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * Compares Products
	 * 
	 * @param item
	 */
	@Override
	public int compareTo(Product e) {
		Double obj1 = this.getPrice();
		Double obj2 = e.getPrice();
		int result = obj1.compareTo(obj2);
		return result;
	}

	/**
	 * Formats the return string
	 * 
	 * @return String
	 */
	public String toString() {
		return this.name + " " + this.size + " (" + this.code + ")  price: $" + this.price;
	}

}
