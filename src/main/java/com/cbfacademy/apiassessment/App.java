package com.cbfacademy.apiassessment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@ComponentScan(basePackages = "com.cbfacademy.apiassessment")
public class App implements CommandLineRunner{

	private WatchlistRepository repository;

	 @Autowired
	 public App (WatchlistRepository repository){
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
// 		// repository.save(new Watchlist(null, "Gold", "GLD", true, "pending buy", "USD", 10-12-2020, 1200, 6, 234, 249, 234, 250));
// 		repository.save(new Watchlist("Gold", "GLD", true, "pending buy", "USD", null, 1200, 0, 6, 249, 234, 250));
// 		                 System.out.println("----------------------------");
//                     for (Watchlist watch : repository.findAll()){
//                         System.out.println(watch);
//                     }
//                     // System.err.println();

//                     // System.out.println("Stock found by Symbol('GLD'):");
//                     // System.out.println("----------------------------");
//                     // System.out.println(repository.find("GLD"));

//                     // System.out.println("Stock found by findByStockName('Gold'):");
//                     // System.out.println("----------------------------");
//                     // for(Watchlist watchModel : repository.findByStockName("Gold")){
//                     //     System.out.println(watchModel);
// 					// 	System.out.println();
	}
}