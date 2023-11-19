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

	// public String welcomeInstructions() {
	// 	return "<h2>Welcome to my Watchlist API</h2>" +
	// 		   "<p>Built to <b>Create</b>, <b>Read</b>, <b>Update</b>, and <b>Delete</b> items from your watchlist.</p>" +
	// 		   "<p>The best way to explore the endpoints for this API is via Postman.</p>" +
	// 		   "<p>While using this API, please use <b><code>http://localhost:8080/watchlist/</code></b> as the base route. Endpoints are as follows:</p>" +
	// 		   "<ul>" +
	// 		   "<li><a href='http://localhost:8080/watchlist/showWatchlist'>/watchlist/showWatchlist</a> - To read all the latest data from your watchlist.</li>" +
	// 		   "<li><a href='http://localhost:8080/watchlist/sortedWatchlist'>/watchlist/sortedWatchlist</a> - For a sorted watchlist.</li>" +
	// 		   "<li><a href='http://localhost:8080/watchlist/searchName/{name}'>/watchlist/searchName/{name}</a> - To search the watchlist for items by name.</li>" +
	// 		   "<li><a href='http://localhost:8080/watchlist/addEntry'>/watchlist/addEntry</a> - To add a new entry to the watchlist.</li>" +
	// 		   "<li><a href='http://localhost:8080/watchlist/updateEntry/{uuid}'>/watchlist/updateEntry/{uuid}</a> - To update an entry. It's important to use the right UUID.</li>" +
	// 		   "<li><a href='http://localhost:8080/watchlist/deleteEntry/{uuid}'>/watchlist/deleteEntry/{uuid}</a> - To delete an entry. You'll need the UUID to ensure deletion of the correct item.</li>" +
	// 		   "</ul>" +
	// 		   "<p>The key-value pairs accepted in this watchlist API are:</p>" +
	// 		   "<ul>" +
	// 		   "<li><b>UUID</b> - Automatically assigned and does not need to be inputted by the user.</li>" +
	// 		   "<li><b>stockName</b> - Name of the stock you want to watch.</li>" +
	// 		   "<li><b>symbol</b> - Symbol of the stock you want to watch.</li>" +
	// 		   "<li><b>currency</b> - Currency that you purchased the stock in.</li>" +
	// 		   "<li><b>datePurchased</b> - A string in the date pattern <i>dd/MM/yyyy</i>.</li>" +
	// 		   "<li><b>wantsVolStock</b> - How much stock you would like to acquire.</li>" +
	// 		   "<li><b>ownsVolStock</b> - The amount of stocks that you currently own.</li>" +
	// 		   "<li><b>purchasePrice</b> - The price at which you purchased the stock.</li>" +
	// 		   "<li><b>currentPrice</b> - Its current price.</li>" +
	// 		   "<li><b>profit</b> - This field is dynamically calculated based on user-provided data.</li>" +
	// 		   "<li><b>pointsChange</b> - Dynamically calculated by an algorithm based on opening and closing prices.</li>" +
	// 		   "<li><b>open</b> - The price of the stock when the market opened.</li>" +
	// 		   "<li><b>close</b> - The price of the stock when the market closed.</li>" +
	// 		   "<li><b>intradayHigh</b> - The intraday high.</li>" +
	// 		   "</ul>" +
	// 		   "<p>When updating the API, the following fields are able to be changed in a PUT request:</p>" +
	// 		   "<ul>" +
	// 		   "<li>Symbol</li>" +
	// 		   "<li>Currency</li>" +
	// 		   "<li>OwnsVolStock</li>" +
	// 		   "<li>WantsVolStock</li>" +
	// 		   "<li>Current Price</li>" +
	// 		   "<li>Purchase Price</li>" +
	// 		   "<li>Open</li>" +
	// 		   "<li>Close</li>" +
	// 		   "<li>Intraday high</li>" +
	// 		   "</ul>";
	// }
	

	// public String welcomeInstructions() {
	// 	return "<html>" +
	// 		   "<head>" +
	// 		   "<style>" +
	// 		   "body { font-family: Arial, sans-serif; background-color: #f4f4f4; color: #333; margin: 20px; }" +
	// 		   "h2 { color: #0066cc; }" +
	// 		   "p { line-height: 1.6; }" +
	// 		   "ul { list-style-type: none; padding-left: 20px; }" +
	// 		   "li { margin-bottom: 8px; }" +
	// 		   "a { color: #009900; text-decoration: none; }" +
	// 		   "a:hover { text-decoration: underline; }" +
	// 		   "b { color: #990000; }" +
	// 		   "i { font-style: italic; }" +
	// 		   "code { background-color: #f8f8f8; padding: 2px 4px; border-radius: 3px; }" +
	// 		   "</style>" +
	// 		   "</head>" +
	// 		   "<body>" +
	// 		   "<h2>Welcome to my Watchlist API</h2>" +
	// 		   "<p>Built to <b>Create</b>, <b>Read</b>, <b>Update</b>, and <b>Delete</b> items from your watchlist.</p>" +
	// 		   "<p>The best way to explore the endpoints for this API is via <b>Postman</b>.</p>" +
	// 		   "<p>While using this API, please use <code>http://localhost:8080/watchlist/</code> as the base route. Endpoints are as follows:</p>" +
	// 		   "<ul>" +
	// 		   "<li><a href='http://localhost:8080/watchlist/showWatchlist'>/watchlist/showWatchlist</a> - To read all the latest data from your watchlist.</li>" +
	// 		   "<li><a href='http://localhost:8080/watchlist/sortedWatchlist'>/watchlist/sortedWatchlist</a> - For a sorted watchlist.</li>" +
	// 		   "<li><a href='http://localhost:8080/watchlist/searchName/{name}'>/watchlist/searchName/{name}</a> - To search the watchlist for items by name.</li>" +
	// 		   "<li><a href='http://localhost:8080/watchlist/addEntry'>/watchlist/addEntry</a> - To add a new entry to the watchlist.</li>" +
	// 		   "<li><a href='http://localhost:8080/watchlist/updateEntry/{uuid}'>/watchlist/updateEntry/{uuid}</a> - To update an entry. It's important to use the right UUID.</li>" +
	// 		   "<li><a href='http://localhost:8080/watchlist/deleteEntry/{uuid}'>/watchlist/deleteEntry/{uuid}</a> - To delete an entry. You'll need the UUID to ensure deletion of the correct item.</li>" +
	// 		   "</ul>" +
	// 		   "<p>The key-value pairs accepted in this watchlist API are:</p>" +
	// 		   "<ul>" +
	// 		   "<li><b>UUID</b> - Automatically assigned and does not need to be inputted by the user.</li>" +
	// 		   "<li><b>stockName</b> - Name of the stock you want to watch.</li>" +
	// 		   "<li><b>symbol</b> - Symbol of the stock you want to watch.</li>" +
	// 		   "<li><b>currency</b> - Currency that you purchased the stock in.</li>" +
	// 		   "<li><b>datePurchased</b> - A string in the date pattern <i>dd/MM/yyyy</i>.</li>" +
	// 		   "<li><b>wantsVolStock</b> - How much stock you would like to acquire.</li>" +
	// 		   "<li><b>ownsVolStock</b> - The amount of stocks that you currently own.</li>" +
	// 		   "<li><b>purchasePrice</b> - The price at which you purchased the stock.</li>" +
	// 		   "<li><b>currentPrice</b> - Its current price.</li>" +
	// 		   "<li><b>profit</b> - This field is dynamically calculated based on user-provided data.</li>" +
	// 		   "<li><b>pointsChange</b> - Dynamically calculated by an algorithm based on opening and closing prices.</li>" +
	// 		   "<li><b>open</b> - The price of the stock when the market opened.</li>" +
	// 		   "<li><b>close</b> - The price of the stock when the market closed.</li>" +
	// 		   "<li><b>intradayHigh</b> - The intraday high.</li>" +
	// 		   "</ul>" +
	// 		   "<p>When updating the API, the following fields are able to be changed in a PUT request:</p>" +
	// 		   "<ul>" +
	// 		   "<li><i>Symbol</i></li>" +
	// 		   "<li><i>Currency</i></li>" +
	// 		   "<li><i>OwnsVolStock</i></li>" +
	// 		   "<li><i>WantsVolStock</i></li>" +
	// 		   "<li><i>Current Price</i></li>" +
	// 		   "<li><i>Purchase Price</i></li>" +
	// 		   "<li><i>Open</i></li>" +
	// 		   "<li><i>Close</i></li>" +
	// 		   "<li><i>Intraday high</i></li>" +
	// 		   "</ul>" +
	// 		   "</body>" +
	// 		   "</html>";
	// }
	public String welcomeInstructions() {
		return "<html>" +
			   "<head>" +
			   "<style>" +
			   "body { font-family: Arial, sans-serif; background-color: #f4f4f4; color: #333; margin: 20px; }" +
			   "h2 { color: #0066cc; }" +
			   "p { line-height: 1.6; }" +
			   "ul { list-style-type: none; padding-left: 20px; }" +
			   "li { margin-bottom: 8px; }" +
			   "a { color: #009900; text-decoration: none; }" +
			   "a:hover { text-decoration: underline; }" +
			   "b { color: #990000; }" +
			   "i { font-style: italic; }" +
			   "code { background-color: #f8f8f8; padding: 2px 4px; border-radius: 3px; }" +
			   "</style>" +
			   "</head>" +
			   "<body>" +
			   "<h2>Welcome to the Watchlist API</h2>" +
			   "<p>Empowering users to <b>Create</b>, <b>Read</b>, <b>Update</b>, and <b>Delete</b> items from their watchlist.</p>" +
			   "<p>For seamless exploration of API endpoints, leverage <b>Postman</b>.</p>" +
			   "<p>While using this API, utilize <code>http://localhost:8080/watchlist/</code> as the base route. Endpoints include:</p>" +
			   "<ul>" +
			   "<li><a href='http://localhost:8080/watchlist/showWatchlist'>/watchlist/showWatchlist</a> - Read all the latest data from your watchlist.</li>" +
			   "<li><a href='http://localhost:8080/watchlist/sortedWatchlist'>/watchlist/sortedWatchlist</a> - Access a sorted watchlist.</li>" +
			   "<li><a href='http://localhost:8080/watchlist/searchName/{name}'>/watchlist/searchName/{name}</a> - Search the watchlist for items by name.</li>" +
			   "<li><a href='http://localhost:8080/watchlist/addEntry'>/watchlist/addEntry</a> - Add a new entry to the watchlist.</li>" +
			   "<li><a href='http://localhost:8080/watchlist/updateEntry/{uuid}'>/watchlist/updateEntry/{uuid}</a> - Update an entry. Use the correct UUID.</li>" +
			   "<li><a href='http://localhost:8080/watchlist/deleteEntry/{uuid}'>/watchlist/deleteEntry/{uuid}</a> - Delete an entry. UUID is crucial for accurate deletion.</li>" +
			   "</ul>" +
			   "<p>The key-value pairs accepted in this watchlist API are:</p>" +
			   "<ul>" +
			   "<li><b>UUID</b> - Automatically assigned and does not require user input.</li>" +
			   "<li><b>stockName</b> - Name of the watched stock.</li>" +
			   "<li><b>symbol</b> - Symbol of the watched stock.</li>" +
			   "<li><b>currency</b> - Currency of stock purchase.</li>" +
			   "<li><b>datePurchased</b> - A string following the date pattern <i>dd/MM/yyyy</i>.</li>" +
			   "<li><b>wantsVolStock</b> - Desired stock acquisition amount.</li>" +
			   "<li><b>ownsVolStock</b> - Current quantity of owned stocks.</li>" +
			   "<li><b>purchasePrice</b> - Price at which the stock was purchased.</li>" +
			   "<li><b>currentPrice</b> - Current stock price.</li>" +
			   "<li><b>profit</b> - Dynamically calculated based on user-provided data.</li>" +
			   "<li><b>pointsChange</b> - Algorithmically calculated based on opening and closing prices.</li>" +
			   "<li><b>open</b> - Stock price at market open.</li>" +
			   "<li><b>close</b> - Stock price at market close.</li>" +
			   "<li><b>intradayHigh</b> - Highest stock price during the day.</li>" +
			   "</ul>" +
			   "<p>For API updates, the following fields can be changed in a PUT request:</p>" +
			   "<ul>" +
			   "<li><i>Symbol</i></li>" +
			   "<li><i>Currency</i></li>" +
			   "<li><i>OwnsVolStock</i></li>" +
			   "<li><i>WantsVolStock</i></li>" +
			   "<li><i>Current Price</i></li>" +
			   "<li><i>Purchase Price</i></li>" +
			   "<li><i>Open</i></li>" +
			   "<li><i>Close</i></li>" +
			   "<li><i>Intraday high</i></li>" +
			   "</ul>" +
			   "</body>" +
			   "</html>";
	}
	
	

	@Override
    public void run(String... args) throws Exception {
		}
	}
