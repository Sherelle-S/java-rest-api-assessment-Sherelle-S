package com.cbfacademy.apiassessment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
		

        

// UserInterface userInterface = new UserInterface();
// userInterface.enterDetails();
// 		WatchList watchlist = new WatchList();
//         repository.save(new WatchList(
//             itemName,
//         	Acronym,
//         	owner,
//         	currentStatus,
//         	currencyOwned,
//         	date,
//         	units,
//         	profitAmount,
//         	watchlist.getPointsChange(),
//         	openingPrice,
//         	closingPrice,
//         	intradayHigh));

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
