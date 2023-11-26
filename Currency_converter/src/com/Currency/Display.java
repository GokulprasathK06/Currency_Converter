package com.Currency;

import java.util.Scanner;



public class Display {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		currencyConverter converter = new currencyConverter ();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Currency Converter!");

        try {
            // Print available currencies
            converter.printCurrencyList();

            // Get user input
            System.out.print("Enter the amount: ");
            double amount = scanner.nextDouble();

            System.out.print("Enter the source currency: ");
            String fromCurrency = scanner.next().toUpperCase();

            System.out.print("Enter the target currency: ");
            String toCurrency = scanner.next().toUpperCase();

            // Check if the entered currencies are valid
            try {
                double convertedAmount = converter.convert(amount, fromCurrency, toCurrency);

                System.out.printf("%.2f %s is equal to %.2f %s\n", amount, fromCurrency, convertedAmount, toCurrency);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid currency selection: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Invalid input. Please enter valid numeric values.");
        } finally {
            scanner.close();
        }
	}

}
