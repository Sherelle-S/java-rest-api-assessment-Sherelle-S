package com.cbfacademy.apiassessment.controllers;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbfacademy.apiassessment.Watchlist;
import com.cbfacademy.apiassessment.WatchlistRepository;

@RestController
@RequestMapping("/showlist")
public class GetController {

    private final WatchlistRepository watchlistRepository;

    // @GetMapping("/showList")
    // // here we the method is the watchlistModel Bean
    // // This data must be written to a JSON file and the data should append the data on each post request.
    // // json data should be rendered in an algo format of search or sort.
    // // create a file that writes to JSON
    // public Watchlist getWatchlist(){
    //     return new Watchlist(
    //         "Silver",
    //     	"SLV",
    //     	true,
    //     	"Hold",
    //     	"GBP",
    //     	LocalDate.of(2018, Month.JUNE, 15),
    //     	600,
    //     	.95,
    //     	1.38,
    //     	2.287,
    //     	1.237,
    //     	2.912);
    // }

    //     @GetMapping("/showList/{id}")
    // Watchlist one(@PathVariable String id){
    //     return repository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    // }

    @Autowired
    public GetController (WatchlistRepository watchlistRepository){
        this.watchlistRepository = watchlistRepository;
    }

    @GetMapping("/showlist")
    public List<Watchlist> getAllPosts(){
        return watchlistRepository.findAll();
    }

}
