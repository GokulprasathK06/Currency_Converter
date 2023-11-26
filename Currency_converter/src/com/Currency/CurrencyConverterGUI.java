package com.Currency;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;



public class CurrencyConverterGUI {
	 private currencyConverter converter;
	    private JFrame frame;
	    private JTextField amountField;
	    private JComboBox<String> fromCurrencyComboBox;
	    private JComboBox<String> toCurrencyComboBox;
	    private JLabel resultLabel;

	    public CurrencyConverterGUI() {
	        converter = new currencyConverter();

	        frame = new JFrame("Currency Converter");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setLayout(new GridLayout(5, 2, 10, 10));

	        JLabel amountLabel = new JLabel("Enter Amount:");
	        amountField = new JTextField();
	        JLabel fromLabel = new JLabel("From Currency:");
	        fromCurrencyComboBox = new JComboBox<>(converter.getAvailableCurrencies().toArray(new String[0]));
	        JLabel toLabel = new JLabel("To Currency:");
	        toCurrencyComboBox = new JComboBox<>(converter.getAvailableCurrencies().toArray(new String[0]));
	        JButton convertButton = new JButton("Convert");
	        resultLabel = new JLabel("Result:");

	        convertButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                convertCurrency();
	            }
	        });

	        frame.add(amountLabel);
	        frame.add(amountField);
	        frame.add(fromLabel);
	        frame.add(fromCurrencyComboBox);
	        frame.add(toLabel);
	        frame.add(toCurrencyComboBox);
	        frame.add(new JLabel()); // Empty space for layout purposes
	        frame.add(convertButton);
	        frame.add(resultLabel);

	        frame.pack();
	        frame.setLocationRelativeTo(null); // Center the frame on the screen
	        frame.setVisible(true);
	    }

	    private void convertCurrency() {
	        try {
	            double amount = Double.parseDouble(amountField.getText());
	            String fromCurrency = (String) fromCurrencyComboBox.getSelectedItem();
	            String toCurrency = (String) toCurrencyComboBox.getSelectedItem();

	            double convertedAmount = converter.convert(amount, fromCurrency, toCurrency);

	            resultLabel.setText(String.format("Result: %.2f %s is equal to %.2f %s",
	                    amount, fromCurrency, convertedAmount, toCurrency));
	        } catch (NumberFormatException ex) {
	            resultLabel.setText("Invalid input. Please enter a valid numeric amount.");
	        } catch (IllegalArgumentException ex) {
	            resultLabel.setText("Invalid currency selection: " + ex.getMessage());
	        }
	    }

	    public static void main(String[] args) {
	    	try {
	    		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    	}
	    	catch(Throwable exception) {
	    		exception.printStackTrace();
	    	}
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                new CurrencyConverterGUI();
	            }
	        });
	    }
}
