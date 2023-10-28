package com.cbfacademy.apiassessment;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cbfacademy.apiassessment.Exceptions.ItemNotFoundException;

@RestController
public class WatchlistController {

    private final WatchListRepository repository;
    UserInterface userInterface = new UserInterface();

    @Autowired
    public WatchlistController(WatchListRepository repository){
        this.repository = repository;
    }

    // Get method
    // use localhost 8080 to return the page
    // localhost:8080/watchlist
    // @GetMapping("/form")
    // public String showForm(Model model){
    //     model.addAttribute("Watchlist", new WatchList());
    //     return "index.html";
    // } 

    @GetMapping("/showList")
    // here we the method is the watchlistModel Bean
    // This data must be written to a JSON file and the data should append the data on each post request.
    // json data should be rendered in an algo format of search or sort.
    // create a file that writes to JSON
    public WatchList getWatchlist(){
        return new WatchList(
            "Silver",
        	"SLV",
        	true,
        	"Hold",
        	"GBP",
        	LocalDate.of(2018, Month.JUNE, 15),
        	600,
        	.95,
        	1.38,
        	2.287,
        	1.237,
        	2.912);
    }

    // @GetMapping("/showList")
    // public List<WatchList> getWatchlist(){

    //     return repository.findAll();
    //     // List<WatchList> watchlist = new ArrayList<>();
    //     // watchlist.add(new WatchList(
    //     //     "American Dollars", 
    //     //     "USD", 
    //     //     true, 
    //     //     null, 
    //     //     "USD",
    //     //     LocalDate.of( 2021, Month.AUGUST, 10), 
    //     //     1520, 
    //     //     0.5, 
    //     //     1.20, 
    //     //     10, 
    //     //     11, 
    //     //     12));
    //     //     watchlist.add(new WatchList(
    //     //     "Silver",
    //     // 	"SLV",
    //     // 	true,
    //     // 	"Hold",
    //     // 	"GBP",
    //     // 	LocalDate.of(2018, Month.JUNE, 15),
    //     // 	600,
    //     // 	.95,
    //     // 	1.38,
    //     // 	2.287,
    //     // 	1.237,
    //     // 	2.912));
    //     //     return watchlist;
        
    // }

    // method for using html form
    // @PostMapping("/submitForm")
    // public String formDetails(@ModelAttribute WatchList watchList){
    //     repository.save(watchList);
    //     return "redirect:/showList";
    // }

    @PostMapping("/addEntry")
    WatchList newWatchListItem(@RequestBody WatchList newWatchListItem){
        WatchList watchList = userInterface.enterDetails();
            return repository.save(watchList);
        }
        // return repository.save(newWatchListItem);
    // public ResponseEntity<?> newWatchListItem(@RequestBody WatchList neWatchList){
        
    //     EntityModel<WatchList> entityModel = assembler.toModel(repository.save(newWatchListItem(neWatchList)));

    //     return ResponseEntity
    //     .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
    //     .body(entityModel);
    

    @GetMapping("/showList/{id}")
    WatchList one(@PathVariable String id){
        return repository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    // @PutMapping("/update-List/{id}")
    // WatchList replaceWatchList(@RequestBody WatchList newWatchListItem, @PathVariable Long id){
    //     // return SearchAlgo.
    //     // // your search algo should go here
    //     // .orElseGet(() -> {
    //     //     newWatchListItem.setId(id);
    //     //     return repository.save(newWatchListItem);
    //     // });
    // }

    @DeleteMapping("/deleteEntry/{id}")
    void deleteWatchlistItem(@PathVariable String id){
        repository.deleteById(id);
    }
    // // Create path variables
    // @GetMapping("{stockName}/{symbol}")
    // public WatchList watchListPathVariable(@PathVariable("stockName") String stockName, @PathVariable("symbol") String symbol){
    //     return new WatchList(stockName, symbol);
    // }
    
    // public WatchList watchListQueryParam(@RequestParam(name = "stockName") String stockName, @RequestParam( symbol = "symbol") String symbol){
    //     return new WatchList(stockName, symbol, false, stockName, symbol, null, null, 0, 0, 0, 0, 0);
    // }
}
