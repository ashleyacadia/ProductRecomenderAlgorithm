package onlineShopApplication;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
//import javax.swing.*;
//import javax.swing.event.ListSelectionListener;
//
//import java.awt.*;
//import java.awt.event.*;

public class OnlineShopApp {

//	public OnlineShopApp(String title) {
//		super(title); // Set title of window
//		getContentPane().setLayout(null);
//		setDefaultCloseOperation(EXIT_ON_CLOSE); // allow window to close
//		setSize(500, 500); // Set size of window
//		setResizable(false);
//		
//		JButton addButton = new JButton("Select");
//		addButton.setLocation(175, 10);
//		addButton.setSize(100, 25);
//		getContentPane().add(addButton);
//		ButtonListener click = new ButtonListener();
//
//		// Add the JList
//		String[] actions = {"1. Add product to cart",
//		"2. View your shopping cart",
//		"3. Finalize your purchase",
//		"4. Quit",};
//		JList<String> actionList = new JList(actions);
//		actionList.setLocation(10, 45);
//		actionList.setSize(250, 150);
//		getContentPane().add(actionList);}
//		ListSelectionListener listener = null;

//		listSelectionModel= actionList.getSelectionModel();
//		
//		.addListSelectionListener(listener);
//		public interface listSelection(ListSelectionEvent e) {
//		
//	}
//		}
//	
//	

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		//setting up window
//		OnlineShopApp frame;
//		frame = new OnlineShopApp("Online Shop");// Create window
//		frame.setVisible(true); // Show window
//		//end of window
		ProductDatabase productList = new ProductDatabase(generateSampleDatabase());
		ArrayList<PurchaseHistory> history = new ArrayList<PurchaseHistory>();
		onlineShop shop = new onlineShop(productList, history);

		// Read text file histories
		System.out.println("Reading purchase transcript: purchase-history(2).txt");
		printLine();
		try {
			history = readPurchaseHistoryData(productList, "purchase-history(2).txt");
		} catch (IOException e) {
			System.err.println("Something went wrong! Check file location " + e);
		} catch (NumberFormatException e) {
			System.err.println("Error with formatting data. " + e);
		} catch (ProductNotFoundException e) {
			System.err.println("No such product found. " + e);
		}

		// in this loop until user would like to exit
		boolean appContinue = true;
		while (appContinue) {
//main menu
			System.out.println("Online shop functionality");
			System.out.println("1. Add product to cart");
			System.out.println("2. View your shopping cart");
			System.out.println("3. Finalise your purchase");
			System.out.println("4. Quit");
			System.out.println("Please select an action from the list (1-4)");

			// check for correct input
			int selection = 0;
			boolean input = false;
			while (!input) {
				input = scan.hasNextInt();
				if (!input) {
					System.out.println("Incorrect entry please try again:");
					scan.nextLine();
				} else if (input) {
					selection = scan.nextInt();
					if (selection <= 5 && selection >= 1) {
						input = true;

					} else if (selection < 1 || selection > 5) {
						input = false;
						System.out.println("Incorrect input, please enter a number (1-4)");
					}
				}
			}

			// product selection
			if (selection == 1) {
				printLine();
				{
					System.out.println("Please select which product you would like?");
					for (int c = 0; c < shop.getProductListing().size(); c++) {
						System.out.println(c + 1 + ". " + shop.getProductListing().get(c));
					}
//					System.out.println("2. " + productList.get(1).toString());
//					System.out.println("3. " + productList.get(2).toString());
//					System.out.println("4. " + productList.get(3).toString());
//					System.out.println("5. " + productList.get(4).toString());
					System.out.println("Please select an action from the list (1-5)");

					// check for correct input
					boolean productInput = false;
					int productSelection = 0;
					while (!productInput) {
						productInput = scan.hasNextInt();
						if (!productInput) {
							System.out.println("Incorrect entry please try again:");
							scan.nextLine();
						} else if (productInput) {
							productSelection = scan.nextInt();
							if (productSelection <= 5 && productSelection >= 1) {
								productInput = true;
							} else if (productSelection < 1 || productSelection > 5) {
								System.out.println("There is no product listed for " + productSelection
										+ " please enter a number (1-5)");
								scan.nextLine();
								productInput = false;
							}
						}
					}
					boolean addedToCart = shop.addToCart(shop.getProductListing().get(productSelection - 1));
					if (addedToCart) {
						System.out.println(
								shop.getProductListing().get(productSelection - 1) + " has been added to your cart!");
					} else if (!addedToCart) {
						System.out.println("An error occured.");
					}
				}
				printLine();
			}

			// Viewing contents of cart
			else if (selection == 2) {
				printLine();
				boolean empty = shop.getShoppingCart().isEmpty();
				if (!empty) {
					System.out.println("The contents of your cart (sorted by price):");
					Collections.sort(shop.getShoppingCart());
					int size = shop.getShoppingCart().size();
					for (int x = 0; x < size; x++) {
						System.out.println(x + 1 + ") " + shop.getShoppingCart().get(x).toString());
					}

				} else if (empty) {
					System.out.println("Your cart is empty.");
				}
				printLine();
			}

			// Finalizing purchases
			else if (selection == 3) {
				printLine();
				boolean empty = shop.getShoppingCart().isEmpty();
				if (!empty) {
					System.out.println("The contents of your cart (sorted by price):");
					Collections.sort(shop.getShoppingCart());

					int size = shop.getShoppingCart().size();
					for (int t = 0; t < size; t++) {
						System.out.println(t + 1 + ") " + shop.getShoppingCart().get(t).toString());
					}
					double total = shop.amountOwing();
					System.out.println("Total amount owing: $" + total);
					System.out.println("Pay full amount?");
					System.out.println("1. Yes");
					System.out.println("2. No, back to main menu");
					System.out.println("Please select an option (1 or 2)");

					// Checking for correct input
					int choice = 0;
					boolean productInput = false;
					while (!productInput) {
						productInput = scan.hasNextInt();
						if (!productInput) {
							System.out.println("Incorrect entry please try again:");
							scan.nextLine();
						} else if (productInput) {
							choice = scan.nextInt();
							if (choice <= 2 && choice >= 1) {
								input = true;
							} else if (choice < 1 || choice < 2) {
								input = false;
								System.out.println("No menu item " + choice + ". Please enter a number(1 or 2)");
							}
						}
					}

					// Completing purchase
					if (choice == 1) {
						System.out.println("Thank you for your purchase. ");
						System.out.println("Some other products you may be interested in:");
						RecommenderSystem suggest = new RecommenderSystem(history, productList);
						ArrayList<Product> suggested = new ArrayList<Product>(
								suggest.productRecommenderAlgorithm(shop.getShoppingCart(), 2));

						System.out.println(suggested.toString());
						shop.completeTransaction();
					}
				} else if (empty) {
					System.out.println("Your cart is empty.");
					printLine();
				}
			}
			// Quit program else if
			else if (selection == 4) {
				printLine();
				appContinue = false;
			}
		}
		System.out.println("Goodbye!");
		printLine();

	}

	private static ArrayList<Product> generateSampleDatabase() {
		// TODO Auto-generated method stub
		ArrayList<Product> items = new ArrayList<Product>();
		Product shoes = new productOne(123, 75.00, "Shoes.", "Magical 'one size fits all' sizing");
		Product hat = new productTwo(187, 30.00, "Hat.", "One size fits all");
		Product drink = new productThree(199, 3.00, "Drink.", "Large");
		Product watch = new productFour(200, 50.00, "Watch.", "One size fits all");
		Product bbq = new productFive(865, 320.00, "Barbeque.", "Small");

		items.add(shoes);
		items.add(hat);
		items.add(drink);
		items.add(watch);
		items.add(bbq);

		return items;
	}

	public static ArrayList<PurchaseHistory> readPurchaseHistoryData(ProductDatabase pb, String filename)
			throws ProductNotFoundException, IOException, NumberFormatException {
		ArrayList<PurchaseHistory> purchaseHistory = new ArrayList<PurchaseHistory>();

		FileReader fileReader = new FileReader(filename);
		Scanner fileScanner = new Scanner(fileReader);

		boolean end = false;

		while (!end) {

			if (!fileScanner.hasNextLine()) {
				end = true;
			} else {
				ArrayList<Product> hxOfProducts = new ArrayList<Product>();

				int fromFile = fileScanner.nextInt();

				for (int count = 0; count < fromFile; count++) {
					hxOfProducts.add(pb.get(fileScanner.nextInt()));
				}
				purchaseHistory.add(new PurchaseHistory(hxOfProducts));
			}
		}
		fileScanner.close();
		return purchaseHistory;
	}

	public static void printLine() {
		System.out.println("------------------------------------------------");
	}
}
