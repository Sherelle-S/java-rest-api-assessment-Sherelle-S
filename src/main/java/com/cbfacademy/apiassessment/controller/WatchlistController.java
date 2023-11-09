package com.cbfacademy.apiassessment.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cbfacademy.apiassessment.exceptions.FailureToIOJsonException;
import com.cbfacademy.apiassessment.exceptions.ItemNotFoundException;
import com.cbfacademy.apiassessment.model.Watchlist;
import com.cbfacademy.apiassessment.service.UserWatchlist;
import com.cbfacademy.apiassessment.service.WatchlistService;
import com.cbfacademy.apiassessment.service.WatchlistServiceImplemented;
import com.cbfacademy.apiassessment.service.WriteToJson;

@RestController
@RequestMapping("/watchlist")
public class WatchlistController {

    private static final Logger log = LoggerFactory.getLogger(WatchlistController.class);
    
    @Autowired
    private WatchlistService service;

    //  @GetMapping("/")
    // public ResponseEntity<List<Watchlist>> getAllWatchlist() {
    //     return service.getAllWatchlist();
    // }

    // @GetMapping("/{id}")
    // // public Watchlist read(@PathVariable String id) {
    //     // return service.find(id);
    //      public ResponseEntity<Watchlist> getWatchlistById(@PathVariable UUID id){
    //     Watchlist watchlist = watchlistRepository.findById(id).orElse(null);
    //     if(watchlist == null){
    //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //     }
    //     return new ResponseEntity<>(watchlist, HttpStatus.OK);
    //     //  watchlistRepository.findById(id);
    // }

    // //     @GetMapping("/{id}")
    // // public ResponseEntity<Watchlist> read(@PathVariable("id") UUID id) {
    // //     Watchlist foundWatchlist = service.read(id);
    // //     if (foundWatchlist == null) {
    // //         return ResponseEntity.notFound().build();
    // //     } else {
    // //         return ResponseEntity.ok(foundWatchlist);
    // //     }
    // // }

    @PostMapping(value = "/addEntry", produces = MediaType.APPLICATION_JSON_VALUE)
    // @ResponseBody // may need to remove this to put in own personal serialization to deserialization points
    public ResponseEntity<WriteToJson> create(@RequestBody UserWatchlist userWatchlist) throws FailureToIOJsonException {
        
        try {
            return service.create();
        } catch (FailureToIOJsonException e) {
            log.error("Failure to write to json at controller during post request", e);
            e.printStackTrace();
            throw new FailureToIOJsonException("Controller failed to pass on userWatchlist to service");
        }
    }

    //  @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    // // public ResponseEntity<UpdateList> updateWatchlist(@PathVariable UUID id, @RequestBody Watchlist watchlist){
    //     public ResponseEntity<ReadFromJson> updateWatchlist(@PathVariable UUID id, @RequestBody UserWatchlist userWatchlist) throws FailureToIOJsonException{

    //         try {
    //             return service.updateWatchlist(id, userWatchlist);
    //         } catch (ItemNotFoundException e) {
    //             log.error("search for item failed at controller level", e);
    //             e.printStackTrace();
    //             throw new FailureToIOJsonException("Exception occurred when processing put request in the controller");
    //         }
    // }
}
    // Watchlist savedWatchlist = watchlistRepository.save(watchlist);
    // 

    
    // // Entity<Watchlist> create(@RequestBody Watchlist watchlist) 
    // //     throws URISyntaxException {
    // //     Watchlist createdWatchlist = service.create(watchlist);
    // //     if (createdWatchlist == null) {
    // //         return ResponseEntity.notFound().build();
    // //     } else {
    // //         URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
    // //         .path("/{id}")
    // //         .buildAndExpand(createdWatchlist.getId())
    // //         .toUri();

    // //         return ResponseEntity.created(uri)
    // //         .body(createdWatchlist);
    // //     }
    // // }


   

//     // // @PutMapping("/{id}")
//     // // public ResponseEntity<Watchlist> update(@RequestBody Watchlist Watchlist, @PathVariable UUID id) {
//     // //     Watchlist updatedWatchlist = service.update(id, Watchlist);
//     // //     if (updatedWatchlist == null) {
//     // //         return ResponseEntity.notFound().build();
//     // //     } else {
//     // //         return ResponseEntity.ok(updatedWatchlist);
//     // //     }
//     // // }

//     // @DeleteMapping("/{id}")
//     // // public ResponseEntity<Object> deleteWatchlist(@PathVariable UUID id) {
//     // //     service.delete(id);
//     // //     return ResponseEntity.noContent().build();
//     // // }
//     // public ResponseEntity<HttpStatus> deleteWatchlist(@PathVariable("id") UUID id){
//     //     CreateWatchlist CreateWatchlist = watchlistRepository.findById(id).orElse(null);
//     //     if(watchlist == null){
//     //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//     //     }
//     //     watchlistRepository.deleteById(id);
//     //     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//     // }
// }