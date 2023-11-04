package com.cbfacademy.apiassessment.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/watchlist")
public class WatchlistController {

    // @Autowired
    // private CRUDWatchlistRepository watchlistRepository;
    // // this may need to be a service private WatchlistService service;

    @GetMapping("/")
    public Watchlist read(@PathVariable String id) {
        return service.find(id);
    }

    @PostMapping(value = "/addEntry", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody // may need to remove this to put in own personal serialization to deserialization points
    public deserializeToJSON postResponseJsonContent(
        @RequestBody CreateItem createItem) {
        return new deserializeToJSON("JSON FILES");
    }

    
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

    @GetMapping("/{id}")
    public ResponseEntity<Watchlist> read(@PathVariable("id") Long id) {
        Watchlist foundWatchlist = service.read(id);
        if (foundWatchlist == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(foundWatchlist);
        }
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody // may need to remove this to put in own personal serialization to deserialization points
    public deserializeToJSON postResponseJsonContent(
        @RequestBody UpdateItem updateItem) {
        return new deserializeToJSON("JSON FILES");
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
    public ResponseEntity<Object> deleteWatchlist(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
