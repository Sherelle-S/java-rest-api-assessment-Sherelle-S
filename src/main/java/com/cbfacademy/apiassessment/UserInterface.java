package com.cbfacademy.apiassessment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import com.cbfacademy.apiassessment.Exceptions.InvalidInputException;

public class UserInterface {
    try (Scanner scanner = new Scanner(System.in)) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = null;
		// do a method for client interractivity
		System.out.println("please enter the name of the stock item?");
		String itemName = scanner.nextLine();

		System.out.println("what is the item symbol?");
		String Acronym = scanner.nextLine();

		System.out.println("Do you currently own this item? Please type true or false");
		boolean owner = scanner.nextBoolean();
		scanner.nextLine();

		System.out.println("What is it's current status, please type N/A if unapplicable");//pending sale or pending buy
		String currentStatus = scanner.nextLine();

		System.out.println("What currency is/will the stock owned in?");
		String currencyOwned = scanner.nextLine();

		System.out.println("Please enter the date you purchase this item (dd/MM/yyyy)");
		String dateStr = scanner.next();
		try {
			date = LocalDate.parse(dateStr, formatter);
		} catch (DateTimeParseException e) {
			throw new InvalidInputException("Invalid date input, correct format if dd/MM/yyyy");
		}
	
		System.out.println("How many units of this stock do you own? Please type 0 if not owned");
		int units = scanner.nextInt();

		System.out.println("How much profit has the stock made? Please type 0 if not owned");
		double profitAmount = scanner.nextDouble();

		System.out.println("Stock price at open");
		double openingPrice = scanner.nextDouble();

		System.out.println("Stock price at closing");
		double closingPrice = scanner.nextDouble();

		System.out.println("Intraday high");
		double intradayHigh = scanner.nextDouble();
    } catch (Exception e) {
        System.err.println("You have given an invalid input, please try again.");
        e.printStackTrace();
        // TODO: handle exception
    }
}
