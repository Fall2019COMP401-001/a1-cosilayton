package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// read in number of customers
		int count = scan.nextInt();
		String[] names = new String[count];
		double[] prices = new double[count];
		
		// get input
		for (int j = 0; j < count; j++) {

			// read in full name of customer
			String firstName = scan.next();
			String lastName = scan.next();

			// read in total number of different items
			int items = scan.nextInt();

			// information on each type of item
			double customerSum = 0;
			for (int i = 0; i < items; i++) {
				int quantity = scan.nextInt();
				scan.next(); // reads the next word without saving it
				double price = scan.nextDouble();

				double totalPrice = quantity * price;
				customerSum = customerSum + totalPrice;
			}
			// compiling the names to print and total sum spent 
			String nameToPrint = firstName.charAt(0) + ". " + lastName;
			names[j] = nameToPrint;
			prices[j] = customerSum;
			
		}
		
		// print output
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i] + ": " + String.format("%.2f", prices[i])); 
		}

	}
}
