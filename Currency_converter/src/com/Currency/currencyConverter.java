package com.Currency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class currencyConverter {
	private Map<String, Double> exchangeRates;

    public currencyConverter() {
        exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.73);
        exchangeRates.put("JPY", 110.11);
        exchangeRates.put("INR", 80.0); 
        exchangeRates.put("CAD", 1.26);  // Canadian Dollar
        exchangeRates.put("THB", 32.85); // Thai Baht
        exchangeRates.put("CNY", 6.39);  // Chinese Yuan
        exchangeRates.put("AUD", 1.32);  // Australian Dollar
        exchangeRates.put("NZD", 1.41);  // New Zealand Dollar
        exchangeRates.put("CHF", 0.91);  // Swiss Franc
        exchangeRates.put("SGD", 1.34);
    }
    public List<String> getAvailableCurrencies() {
        return new ArrayList<>(exchangeRates.keySet());
    }

    public double convert(double amount, String fromCurrency, String toCurrency) {
        double fromRate = getExchangeRate(fromCurrency);
        double toRate = getExchangeRate(toCurrency);

        // Convert from the source currency to the target currency
        return amount * (toRate / fromRate);
    }

    public void printCurrencyList() {
        System.out.println("Available Currencies: ");
        
        for (String currency : exchangeRates.keySet()) {
            System.out.println(currency + " ");
        }
        System.out.println();
    }

    public double getExchangeRate(String currency) {
        validateCurrency(currency);
        return exchangeRates.get(currency);
    }

    public void setExchangeRate(String currency, double rate) {
        validateCurrency(currency);
        exchangeRates.put(currency, rate);
    }

    private void validateCurrency(String currency) {
        if (!exchangeRates.containsKey(currency)) {
            throw new IllegalArgumentException("Invalid currency code: " + currency);
        }
    }

}
