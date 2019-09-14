import java.util.Scanner;

public class MakeChangeApp {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		double itemPrice, cashIn;
		int priceTimesOneHundred, cashTimesOneHundred, priceCashInDiff, twenties = 0, tens = 0, fives = 0, ones = 0;
		int quarters = 0, dimes = 0, nickels = 0, pennies = 0;
		
		System.out.print("How much is the item?> $");
		itemPrice = kb.nextDouble();
		System.out.println();
		
		System.out.print("How much cash is being used to pay?> $");
		cashIn = kb.nextDouble();
		System.out.println();
		
		if (cashIn < itemPrice) {
			System.err.println("More cash is needed to complete the transaction.");
		}
		
		if (cashIn == itemPrice) {
			System.out.println("That's the exact amount needed. No change will be returned.");
		}
		
		if (cashIn > itemPrice) {
			cashTimesOneHundred = (int)(cashIn * 100);
			priceTimesOneHundred = (int)(itemPrice * 100);
			
			priceCashInDiff = cashTimesOneHundred - priceTimesOneHundred;			
			
			if (priceCashInDiff > 20) {
				twenties = priceCashInDiff/2000;
				tens = (priceCashInDiff - (twenties * 2000)) / 1000;
				fives = (priceCashInDiff - (twenties * 2000 + tens * 1000)) / 500;
				ones = (priceCashInDiff - (twenties * 2000 + tens * 1000 + fives * 500)) / 100;
				quarters = (priceCashInDiff - (twenties * 2000 + tens * 1000 + fives * 500 + ones * 100)) / 25;
				dimes = (priceCashInDiff - (twenties * 2000 + tens * 1000 + fives * 500 + ones * 100 + quarters * 25)) / 10;
				nickels = (priceCashInDiff - (twenties * 2000 + tens * 1000 + fives * 500 + ones * 100 + quarters * 25 + dimes * 10)) / 5;
				pennies = (priceCashInDiff - (twenties * 2000 + tens * 1000 + fives * 500 + ones * 100 + quarters * 25 + dimes * 10 + nickels * 5));
			}
			
			System.out.println("Total change: ");
			System.out.println();
			System.out.println("Twenties: " + twenties);
			System.out.println("Tens: " + tens);
			System.out.println("Fives: " + fives);
			System.out.println("Ones: " + ones);
			System.out.println("Quarters: " + quarters);
			System.out.println("Dimes: " + dimes);
			System.out.println("Nickels: " + nickels);
			System.out.println("Pennies: " + pennies);
		}

		kb.close();
	}
}
