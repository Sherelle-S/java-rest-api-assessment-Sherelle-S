package com.cbfacademy.apiassessment;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cbfacademy.apiassessment.CRUDWatchlistRepository;
import com.cbfacademy.apiassessment.model.Watchlist;

@SpringBootApplication
@RestController
@ComponentScan(basePackages = "com.cbfacademy.apiassessment")
public class App implements CommandLineRunner{


	 @Autowired
	 public App (CRUDWatchlistRepository repository){
		this.repository = repository;
	 }
	
	/** 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@GetMapping("/greeting")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
			return String.format("Hello %s", name);
			
	}

	@Override
    public void run(String... args) throws Exception {

		UserInput userInput = new UserInput(new UserInteractions(new Scanner(System.in)));

		Watchlist watchlist = userInput.useDetails();

		System.out.println("User input collected: " + watchlist);

		// so do you want to save your answers WatchlistRepository.save(watchlist);
		// ?may be a good time to serialize your data
		
		repository.deleteAll();

		

		// // repository.save(new Watchlist(null, null, false, null, null, null, null, 0, 0, 0, 0, 0));
		// // repository.save(new Watchlist("Gold", "GLD", true, "Hold", "GBP", 21/04/2020, 1200, 1.25, 1.29, 6.267, 6.287, 6.316));

        //             System.out.println("----------------------------");
        //             for (Watchlist watch : repository.findAll()){
        //                 System.out.println(watch);
        //             }
        //             System.err.println();

        //             System.out.println("Stock found by Symbol('GLD'):");
        //             System.out.println("----------------------------");
        //             System.out.println(repository.findBySymbol("GLD"));

        //             System.out.println("Stock found by findByStockName('Gold'):");
        //             System.out.println("----------------------------");
        //             for(Watchlist watchModel : repository.findByStockName("Gold")){
        //                 System.out.println(watchModel);
		// 				System.out.println();
        //             }
    
		
		
		

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
