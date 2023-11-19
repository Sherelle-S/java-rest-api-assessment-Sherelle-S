package com.cbfacademy.apiassessment.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cbfacademy.apiassessment.Watchlist;
import com.cbfacademy.apiassessment.WatchlistRepository;

@RestController
@RequestMapping("/watchlist")
public class WatchlistController {

    @Autowired
    private WatchlistRepository watchlistRepository;
    
    /** 
     * @return ResponseEntity<List<Watchlist>>
     */
    // // this may need to be a service private WatchlistService service;

     @GetMapping("/")
    public ResponseEntity<List<Watchlist>> getAllWatchlist() {
        Iterable<Watchlist> iterableWatchlist = watchlistRepository.findAll();
        List<Watchlist> watchlist = new ArrayList<>();
        
        iterableWatchlist.forEach(watchlist::add);
    return new ResponseEntity<>(watchlist, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    // public Watchlist read(@PathVariable String id) {
        // return service.find(id);
         public ResponseEntity<Watchlist> getWatchlistById(@PathVariable Long id){
        Watchlist watchlist = watchlistRepository.findById(id).orElse(null);
        if(watchlist == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(watchlist, HttpStatus.OK);
        //  watchlistRepository.findById(id);
    }

    //     @GetMapping("/{id}")
    // public ResponseEntity<Watchlist> read(@PathVariable("id") Long id) {
    //     Watchlist foundWatchlist = service.read(id);
    //     if (foundWatchlist == null) {
    //         return ResponseEntity.notFound().build();
    //     } else {
    //         return ResponseEntity.ok(foundWatchlist);
    //     }
    // }

    @PostMapping(value = "/addEntry", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody // may need to remove this to put in own personal serialization to deserialization points
    public ResponseEntity<deserializeToJSON> postResponseJsonContent(
        @RequestBody CreateItem createItem) {
        
        deserializeToJSON response = deserializeToJSON("JSON FILES");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    // Watchlist savedWatchlist = watchlistRepository.save(watchlist);
    // 

    
    // Entity<Watchlist> create(@RequestBody Watchlist watchlist) 
    //     throws URISyntaxException {
    //     Watchlist createdWatchlist = service.create(watchlist);
    //     if (createdWatchlist == null) {
    //         return ResponseEntity.notFound().build();
    //     } else {
    //         URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
    //         .path("/{id}")
    //         .buildAndExpand(createdWatchlist.getId())
    //         .toUri();

    //         return ResponseEntity.created(uri)
    //         .body(createdWatchlist);
    //     }
    // }


    @PutMapping("/{id}")
    public ResponseEntity<UpdateList> updateWatchlist(@PathVariable Long id, @RequestBody Watchlist watchlist){
        Watchlist currentWatchlist = watchlistRepository.findById(id).orElse(null);
        if(currentWatchlist == null) {
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
        Watchlist updatedWatchlist = watchlistRepository.save(currentWatchlist);
        UpdateList response = new UpdateList(currentWatchlist, updatedWatchlist);

        return new ResponseEntity<>(response, HttpStatus.OK);
        // return new ResponseEntity<>(updatedWatchlist, HttpStatus.OK);
    // @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    // @ResponseBody // may need to remove this to put in own personal serialization to deserialization points
    // public deserializeToJSON postResponseJsonContent(
    //     @RequestBody UpdateList updateList) {
    //     return new deserializeToJSON("JSON FILES");
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<Watchlist> update(@RequestBody Watchlist Watchlist, @PathVariable Long id) {
    //     Watchlist updatedWatchlist = service.update(id, Watchlist);
    //     if (updatedWatchlist == null) {
    //         return ResponseEntity.notFound().build();
    //     } else {
    //         return ResponseEntity.ok(updatedWatchlist);
    //     }
    // }

    @DeleteMapping("/{id}")
    // public ResponseEntity<Object> deleteWatchlist(@PathVariable Long id) {
    //     service.delete(id);
    //     return ResponseEntity.noContent().build();
    // }
    public ResponseEntity<HttpStatus> deleteWatchlist(@PathVariable("id") Long id){
        Watchlist watchlist = watchlistRepository.findById(id).orElse(null);
        if(watchlist == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        watchlistRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
