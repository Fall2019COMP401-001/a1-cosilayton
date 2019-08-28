package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// read in the input for items
		int numberOfItems = scan.nextInt();
		double[] listOfPrices = new double[numberOfItems];
		String[] listOfItemNames = new String[numberOfItems]; // can then have if statements to see if input matches an item

		// for each item in the store, read in the info for that item
		for (int i = 0; i < numberOfItems; i++) {
			String nameOfItem = scan.next();  // get the name of each item 
			double priceOfItem = scan.nextDouble(); // get the price of each item
			listOfItemNames[i] = nameOfItem; // add name to array
			listOfPrices[i] = priceOfItem; // add price to array
		}

		// get the input for customers
		int numberOfCustomers = scan.nextInt();
		String[] listOfNames = new String[numberOfCustomers];
		double[] listOfCustomerSums = new double[numberOfCustomers];

		// for each customer
		for (int i = 0; i < numberOfCustomers; i++) {
			double customerSum = 0;
			String firstName = scan.next();
			String lastName = scan.next();
			int numberOfItemsBought = scan.nextInt();

			// for each different type of item bought
			for (int j = 0; j < numberOfItemsBought; j++) {
				int quantityOfItem = scan.nextInt();
				String nameOfItem = scan.next();

				// locate this item among the items in the store
				for (int storeItem = 0; storeItem < listOfItemNames.length; storeItem++) {
					if (nameOfItem.equals(listOfItemNames[storeItem])) {
						double itemSum = quantityOfItem * listOfPrices[storeItem];
						customerSum = customerSum + itemSum;
					}
				}

			}
			listOfNames[i] = firstName + " " + lastName;
			listOfCustomerSums[i] = customerSum;
			
		}
		

		// find the people who spent the most and the least
		double biggest = listOfCustomerSums[0];
		double smallest = listOfCustomerSums[0];
		String biggestSpender = listOfNames[0];
		String smallestSpender = listOfNames[0];
		for (int i = 1; i < listOfNames.length; i++) {
			if (listOfCustomerSums[i] > biggest) {  // finding the biggest spender
				biggest = listOfCustomerSums[i];
				biggestSpender = listOfNames[i];
			} else if (listOfCustomerSums[i] < smallest){     // finding the smallest spender
				smallest = listOfCustomerSums[i]; 
				smallestSpender = listOfNames[i];
			}
		}

		// find the average
		double total = 0;
		for (int i = 0; i < listOfCustomerSums.length; i++) {
			total = total + listOfCustomerSums[i];
		}
		double average = total / listOfCustomerSums.length; // find the average by dividing by the total number


		// print output

		System.out.println("Biggest: " + biggestSpender + " (" + String.format("%.2f", biggest) + ")");
		System.out.println("Smallest: " + smallestSpender + " (" + String.format("%.2f", smallest) + ")");
		System.out.println("Average: " + String.format("%.2f", average));


	}

	public static void printArray(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void printArray(double[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
