package com.cbfacademy.apiassessment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import com.cbfacademy.apiassessment.Exceptions.InvalidInputException;

public class UserInterface {

    private String stockName;
    private String symbol;
    private boolean owned;
    private String status;
    private String currency;
    private LocalDate datePurchased;
    private Integer unitsOwned;
    private double profit;
    private double pointsChange;
    private double open;
    private double close;
    private double high;

    protected WatchList enterDetails(){
        WatchList watchList = new WatchList();
        try (Scanner scanner = new Scanner(System.in)) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = null;
		// do a method for client interractivity
		System.out.println("please enter the name of the stock item?");
		watchList.setStockName(scanner.nextLine());

		System.out.println("what is the item symbol?");
		watchList.setSymbol(scanner.nextLine().toUpperCase());

		System.out.println("Do you currently own this item? Please type true or false");
		watchList.setOwned(scanner.nextBoolean());
		scanner.nextLine();

		System.out.println("What is it's current status, please type N/A if unapplicable");//pending sale or pending buy
		watchList.setStatus(scanner.nextLine());

		System.out.println("What currency is/will the stock owned in?");
		watchList.setCurrency(scanner.nextLine().toUpperCase());

		System.out.println("Please enter the date you purchase this item (dd/MM/yyyy)");
		String dateStr = scanner.next();
		try {
			watchList.setDatePurchased(date = LocalDate.parse(dateStr, formatter));
		} catch (DateTimeParseException e) {
			throw new InvalidInputException("Invalid date input, correct format if dd/MM/yyyy");
		}
	
		System.out.println("How many units of this stock do you own? Please type 0 if not owned");
		watchList.setUnitsOwned(scanner.nextInt());

		System.out.println("How much profit has the stock made? Please type 0 if not owned");
		watchList.setProfit(scanner.nextDouble());

        double pointsChange = watchList.getClose() - watchList.getOpen();
        watchList.setPointsChange(pointsChange);

		System.out.println("Stock price at open");
		watchList.setOpen(scanner.nextDouble());

		System.out.println("Stock price at closing");
		watchList.setClose(scanner.nextDouble());

		System.out.println("Intraday high");
		watchList.setIntradayHigh(scanner.nextDouble());

        return watchList;
        } catch (Exception e) {
        System.err.println("You have given an invalid input, please try again.");
        e.printStackTrace();
        // TODO: handle exception
    }
		return watchList;
    
    }
    
}
