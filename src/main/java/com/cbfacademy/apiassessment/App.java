package com.cbfacademy.apiassessment;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cbfacademy.apiassessment.Exceptions.InvalidInputException;

@SpringBootApplication
@RestController
public class App implements CommandLineRunner{

	 private WatchListRepository repository;

	 @Autowired
	 public App (WatchListRepository repository){
		this.repository = repository;
	 }
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@GetMapping("/greeting")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
			return String.format("Hello %s", name);
			
	}

	@Override
    public void run(String... args) throws Exception {
		try (Scanner scanner = new Scanner(System.in);) {
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
        

        


		WatchList watchlist = new WatchList();
        repository.save(new WatchList(
            itemName,
        	Acronym,
        	owner,
        	currentStatus,
        	currencyOwned,
        	date,
        	units,
        	profitAmount,
        	watchlist.getPointsChange(),
        	openingPrice,
        	closingPrice,
        	intradayHigh));

                    System.out.println("----------------------------");
                    for (WatchList watch : repository.findAll()){
                        System.out.println(watch);
                    }
                    System.err.println();

                    System.out.println("Stock found by Symbol('GLD'):");
                    System.out.println("----------------------------");
                    System.out.println(repository.findBySymbol("GLD"));

                    System.out.println("Stock found by findByStockName('Gold'):");
                    System.out.println("----------------------------");
                    for(WatchList watchModel : repository.findByStockName("Gold")){
                        System.out.println(watchModel);
						System.out.println();
                    }
    
		} catch (Exception e) {
			System.err.println("You have given an invalid input, please try again.");
			e.printStackTrace();
			// TODO: handle exception
		}
		
		

	// @GetMapping("/hi")
	// private List<WatchlistConstructor> hello() {
	// 	return List.of(
	// 		new WatchlistConstructor(
	// 			1,
	// 			"Gold",
	// 			"GLD",
	// 			true,
	// 			"Hold",
	// 			"GBP",
	// 			LocalDate.of(2020, Month.APRIL, 21),
	// 			1200,
	// 			1.25,
	// 			1.298,
	// 			6.267,
	// 			6.287,
	// 			6.316
	// 		)
	// 	);
	// }

	// @PostMapping("/create")
	// public 


	// @PutMapping("/update")
	// public

	// @DeleteMapping("/delete")
	// // public

	}
}
