package com.cbfacademy.apiassessment;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// import com.cbfacademy.apiassessment.WatchlistRepository;
// annotations tell spring this is the class where everything will run from, its also a controller with the ability to map requests, componentScan let spring know this is a base class, everything show be variable from here.
@SpringBootApplication
@RestController
@ComponentScan(basePackages = "com.cbfacademy.apiassessment")
public class App implements CommandLineRunner{

	public static void main(String[] args) {
		
		SpringApplication.run(App.class, args);
	}

	@GetMapping("/greeting")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
			return String.format("Hello %s", name);
	}

	@GetMapping(value = "/welcome")
	public String welcome(){
		return welcomeInstructions();
	}

	public String welcomeInstructions() {
    return "<html><body><strong>Welcome to my Watchlist API built to Create Read Update and Delete items from your watchlist.</strong>"
            + "<br><br>"
            + "The best way to interact with this API is via Postman."
            + "<br><br>"
            + "While using this API, please use <strong>http://localhost:8080/watchlist/</strong> as the base route. Endpoints are as follows:"
            + "<ul>"
            + "<li> <a href='http://localhost:8080/watchlist/'>/watchlist/</a> - To read all the latest data from your watchlist</li>"
            + "<li> <a href='http://localhost:8080/watchlist/sortedWatchlist'>/watchlist/sortedWatchlist</a> - For a sorted watchlist</li>"
            + "<li> <a href='http://localhost:8080/watchlist/searchName/{name}'>/watchlist/searchName/{name}</a> - To search the watchlist for items by name</li>"
            + "<li> <a href='http://localhost:8080/watchlist/addEntry'>/watchlist/addEntry</a> - To add a new entry to the watchlist</li>"
            + "<li> <a href='http://localhost:8080/watchlist/updateEntry/{uuid}'>/watchlist/updateEntry/{uuid}</a> - To update an entry (use the UUID to specify the item)</li>"
            + "<li> <a href='http://localhost:8080/watchlist/deleteEntry/{uuid}'>/watchlist/deleteEntry/{uuid}</a> - To delete an entry (use the UUID to specify the item)</li>"
            + "</ul>"
            + "</body></html>";
}

	@Override
    public void run(String... args) throws Exception {
		}
	}
