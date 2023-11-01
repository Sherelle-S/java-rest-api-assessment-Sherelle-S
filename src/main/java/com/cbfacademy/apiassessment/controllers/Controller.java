package com.cbfacademy.apiassessment.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbfacademy.apiassessment.WatchlistRepository;
import com.cbfacademy.apiassessment.model.Watchlist;

@RestController //tells spring this is a rest controller
@RequestMapping("/watchlist") //base usrl for rquests
public class Controller {
    @Autowired //injects an instance of watchlistRepository
    private WatchlistRepository watchlistRepository;

    @GetMapping("/")
    public List<Watchlist> getAllWatchlist(){ //handles get requests
        return watchlistRepository.findAll();
    }

    @GetMapping("/{id}") //get user by id returns a 404 if not found
    public ResponseEntity<Watchlist> getWatchlistById(@PathVariable String id){
        Watchlist watchlist = watchlistRepository.findById(id).orElse(null);
        if(watchlist == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(watchlist, HttpStatus.OK);
        //  watchlistRepository.findById(id);
    }

    
    @PostMapping("") //posts new user and call save to the repo passing the user object as a param
    public ResponseEntity<Watchlist> createWatchlist(@RequestBody Watchlist watchlist){
        Watchlist savedWatchlist = watchlistRepository.save(watchlist);
        return new ResponseEntity<>(savedWatchlist, HttpStatus.CREATED);
        // return watchlistRepository.save(watchlist);
    }

    
    @PutMapping("/{id}") //updates a user
    public ResponseEntity<Watchlist> updateWatchlist(@PathVariable ("id") String id, @RequestBody Watchlist watchlist){//updateWatchlist) {
        Watchlist currentWatchlist = watchlistRepository.findById(id).orElse(null);
        if(currentWatchlist == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentWatchlist.setStockName(watchlist.getStockName());
        currentWatchlist.setSymbol(watchlist.getSymbol());
        currentWatchlist.setOwned(watchlist.isOwned());
        currentWatchlist.setStatus(watchlist.getStatus());
        currentWatchlist.setCurrency(watchlist.getCurrency());
        currentWatchlist.setDatePurchased(watchlist.getDatePurchased());
        currentWatchlist.setUnitsOwned(watchlist.getUnitsOwned());
        currentWatchlist.setProfit(watchlist.getProfit());
        currentWatchlist.setOpen(watchlist.getOpen());
        currentWatchlist.setClose(watchlist.getClose());
        currentWatchlist.setIntradayHigh(watchlist.getIntradayHigh());
        Watchlist updatedWatchlist = watchlistRepository.save(watchlist);
        return new ResponseEntity<>(updatedWatchlist, HttpStatus.OK);
        // return watchlistRepository.findById(id)
        // .map(watchlist -> {
        //     watchlist.setTask(updateWatchlist.getTask());
        //     watchlist.setCompleted(updateWatchlist.isCompleted());
        //     return watchlistRepository.save(watchlist);
        // })
        // .orElseGet(() -> {
        //     updateWatchlist.setId(id);
        //     return watchlistRepository.save(updateWatchlist);
        // });
    }

    @DeleteMapping("/{id}") //deletes a user by its is
    public ResponseEntity<HttpStatus> deleteWatchlist(@PathVariable("id") String id){
        Watchlist watchlist = watchlistRepository.findById(id).orElse(null);
        if(watchlist == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        watchlistRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}