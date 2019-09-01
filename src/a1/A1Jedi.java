package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);


		// read in the input for items
		int numberOfItems = scan.nextInt();
		String[] listOfItemNames = new String[numberOfItems]; // can then have if statements to see if input matches an item
		int[] arrayOfCustomerCounts = new int[numberOfItems];
		int[] arrayOfTotalQuantities = new int[numberOfItems];
		boolean[] arrayOfAlreadyBought = new boolean[numberOfItems];

		// for each item in the store, read in the info for that item
		for (int i = 0; i < numberOfItems; i++) {
			String nameOfItem = scan.next();  // get the name of each item 
			double priceOfItem = scan.nextDouble(); // get the price of each item
			listOfItemNames[i] = nameOfItem; // add name to array
		}

		// get the input for customers
		int numberOfCustomers = scan.nextInt();
		String[] listOfNames = new String[numberOfCustomers];
		int totalQuantity = 0; 

		// for each customer
		for (int i = 0; i < numberOfCustomers; i++) {

			// make each index false bc customer has not bought any item yet
			for (int storeItem = 0; storeItem < arrayOfAlreadyBought.length; storeItem++) {
				arrayOfAlreadyBought[storeItem] = false;
			}

			String firstName = scan.next();
			String lastName = scan.next();
			int numberOfItemsBought = scan.nextInt(); 

			// for each different type of item bought
			for (int j = 0; j < numberOfItemsBought; j++) {    
				int quantityOfItem = scan.nextInt();
				String nameOfItem = scan.next();

				// go through store items and compare to what customer bought
				for (int storeItem = 0; storeItem < listOfItemNames.length; storeItem++) {  
					if (nameOfItem.equals(listOfItemNames[storeItem])) {
						if (!arrayOfAlreadyBought[storeItem]) { // if they haven't bought the item, increase customerCount by 1
							arrayOfCustomerCounts[storeItem] ++;
						}
						arrayOfAlreadyBought[storeItem] = true;
						arrayOfTotalQuantities[storeItem] += quantityOfItem;
						break;
					}
				}
			}
		}

		// print output
		for (int i = 0; i < listOfItemNames.length; i++) {
			if (arrayOfCustomerCounts[i] == 0) {
				System.out.println("No customers bought " + listOfItemNames[i]);
			} else {

				System.out.println(arrayOfCustomerCounts[i] + " customers bought " 
						+ arrayOfTotalQuantities[i] + " " + listOfItemNames[i]);
			}

		}


	}


}
