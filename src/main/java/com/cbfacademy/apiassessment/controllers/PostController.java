package com.cbfacademy.apiassessment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cbfacademy.apiassessment.Watchlist;

@RestController
public class PostController {

    // @Autowired //spring framework will create a class for the object and map to it.
    // PostController repo;
    
    //  @PostMapping
    // public ResponseEntity<Watchlist> saveWatchlist(@RequestBody Watchlist watchlist){
    //     return new ResponseEntity<Watchlist>(implementService.saveWatchlist(watchlist), HttpStatus.CREATED);
    // }
    // Get method
    // use localhost 8080 to return the page
    // localhost:8080/watchlist
    // @GetMapping("/form")
    // public String showForm(Model model){
    //     model.addAttribute("Watchlist", new WatchList());
    //     return "index.html";
    // } 

}
