// package com.cbfacademy.apiassessment;

// import java.time.LocalDate;
// import java.time.format.DateTimeFormatter;
// import java.time.format.DateTimeParseException;
// import java.util.InputMismatchException;
// import java.util.Scanner;

// import com.cbfacademy.apiassessment.Exceptions.InvalidInputException;

// // class deals with getting interaction inputs from user and handling errors that may occur when retrieving details from user.
// public class UserInteractions {
// 	private Scanner scanner;

// 	public UserInteractions(Scanner scanner) {
// 		this.scanner = scanner;
// 	}

// 		public String inputStockName() throws InvalidInputException{
// 			System.out.println("please enter the name of the stock item?");
// 			String stockName = scanner.nextLine();
// 			if(stockName.isEmpty()){
// 				throw new InvalidInputException("Invalid stock name entered.");
// 			}
// 			return scanner.nextLine();
// 		}
		
// 		public String inputSymbol() throws InvalidInputException{
// 			System.out.println("what is the item symbol?");
// 			String symbol = scanner.nextLine();
// 			if(symbol.isEmpty()){
// 				throw new InvalidInputException("Invalid symbol entered.");
// 			}
// 			return scanner.nextLine().toUpperCase();
// 		}
	
// 		public boolean userOwnership() throws InvalidInputException{
// 			try {
// 				System.out.println("Do you currently own this item? Please type true or false");
// 				boolean owned = scanner.nextBoolean();
// 				scanner.next();
// 				if(owned != true && owned != false){
// 					throw new InvalidInputException("Invalid boolean input entered.");
// 				}
// 				return owned;
// 			} catch (InputMismatchException e) {
// 				throw new InvalidInputException("Unexpected input received, type boolean expected.");
// 			}
// 		}

// 		public String inputStatus() throws InvalidInputException{
// 			System.out.println("What is it's current status, please type N/A if unapplicable");//pending sale or pending buy
// 			String status = scanner.nextLine();
// 			if(status.isEmpty()){
// 				throw new InvalidInputException("Invalid status string entered.");
// 			}
// 			return status;
// 		}
	
// 		public String userCurrency() throws InvalidInputException{
// 			System.out.println("What currency is/will the stock owned in?");
// 			String currency = scanner.nextLine().toUpperCase();
// 			if(currency.isEmpty()){
// 				throw new InvalidInputException("Invalid currency string entered.");
// 			}
// 			return currency;
// 		}

// 		public LocalDate userPurchaseDate() throws DateTimeParseException{
// 			LocalDate date = null;
// 			try {
// 				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
// 				System.out.println("Please enter the date you purchase this item (dd/MM/yyyy)");
// 				String dateStr = scanner.next();
// 				date = LocalDate.parse(dateStr, formatter);
// 			} catch (DateTimeParseException | InputMismatchException e){
// 				System.out.println("Error ocurred while parsing date.");
// 			};	
// 			return date;
// 		}

// 		public int userUnits() throws InvalidInputException{
// 			try {
// 			System.out.println("How many units of this stock do you own? Please type 0 if not owned");
// 			int units = scanner.nextInt();
// 				if(units < 0){
// 					throw new InvalidInputException("Invalid input for units, please give a number greater than 0.");
// 				}
// 			return units;
// 			} catch (InputMismatchException e){
// 				throw new InvalidInputException("Unexpected input received, type integer expected.");

// 			}
// 		}

// 		public double userProfit() throws InvalidInputException{
// 			try {
// 			System.out.println("How much profit has the stock made? Please type 0 if not owned");
// 			double profit = scanner.nextDouble();
// 				if (Double.isNaN(profit)) {
// 					throw new InvalidInputException("Invalid input for profit entered.");
// 				}
//             return profit;
//         	} catch (InputMismatchException e) {
// 				throw new InvalidInputException("Unexpected input received, type double expected.");
// 			}
			
// 		}

// 		public double openingPrice() throws InvalidInputException{
// 			try {
// 			System.out.println("Stock price at open");
// 			double opening = scanner.nextDouble();
// 				if (Double.isNaN(opening)) {
// 					throw new InvalidInputException("Invalid input for opening entered.");
// 				}
//             return opening;
//         	} catch (InputMismatchException e) {
// 				throw new InvalidInputException("Unexpected input received, type double expected.");
// 			}
// 		}

// 		public double closingPrice() throws InvalidInputException{
// 			try {
// 			System.out.println("Stock price at closing?");
// 			double closing = scanner.nextDouble();
// 				if (Double.isNaN(closing)) {
// 					throw new InvalidInputException("Invalid input for closing entered.");
// 				}
//             return closing;
//         	} catch (InputMismatchException e) {
// 				throw new InvalidInputException("Unexpected input received, type double expected.");
// 			}
// 		}

// 		public double dailyHigh() throws InvalidInputException{
// 			try {
// 			System.out.println("What is the intraday high?");
// 			double high = scanner.nextDouble();
// 				if (Double.isNaN(high)) {
// 					throw new InvalidInputException("Invalid input for high entered.");
// 				}
//             return high;
//         	} catch (InputMismatchException e) {
// 				throw new InvalidInputException("Unexpected input received, type double expected.");
// 			}
// 		}

// 		public void closeScanner(){
// 			scanner.close();
// 		}
    
// }
