package com.cbfacademy.apiassessment.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cbfacademy.apiassessment.exceptions.FailureToIOJsonException;
import com.cbfacademy.apiassessment.exceptions.ItemNotFoundException;
import com.cbfacademy.apiassessment.model.Watchlist;

@Service
public class WatchlistServiceImplemented implements WatchlistService {

    private static final Logger log = LoggerFactory.getLogger(WatchlistServiceImplemented.class);
    private UserWatchlist userWatchlist;
    
    public WatchlistServiceImplemented(UserWatchlist userWatchlist) {
        this.userWatchlist = userWatchlist;
    }
    // @Autowired
    // private WatchlistRepository watchlistRepository;

    // List<Watchlist> list;
    // public WatchlistServiceImplemented(){
    //     list = new ArrayList<>();
    //     list.add(new Watchlist(null, null, false, null, null, null, null, 0, 0, 0, 0, 0))
    // }


    // public List<Watchlist> readFromJson() {
    //    List<Watchlist> list;
    //    list = new ArrayList<>();
    //    list.add(new Watchlist("Gold", "XAU", true, "TestStatus", "GBP", LocalDate.now(), 100, 50.0, 2.0, 60.0, 62.0, 70.0));
    // return list;
    // }

// fetches the dater from updated watchlist for use in business logic
    public UserWatchlist getUserWatchlistData(){
        return userWatchlist;
    }

    
    @Override
    // POST
    // Gets data from user input, creates a WriteToJsons object and writes the response to json
    public ResponseEntity<WriteToJson> create() throws FailureToIOJsonException{
        UserWatchlist userWatchlist = getUserWatchlistData();
        WriteToJson response = new WriteToJson(userWatchlist);
        try {
            response.writeToJson();
        } catch (FailureToIOJsonException e) {
            log.error("File is unable to be written to json, exception ocurred in watchlist service implementation.");
            e.printStackTrace();
            throw new FailureToIOJsonException("Exception occurred while sending data over to json writer.");
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
 
    
    // public ResponseEntity<List<Watchlist>> getAllWatchlist() {
    //     List<Watchlist> watchlist = readFromJson();
    //     return new ResponseEntity<>(watchlist, HttpStatus.OK);
    // }
    // public Student update(Long id, Student student) {
    //     student.setId(id);
    //     Student oldStudent = repository.replace(id, student);
    //     return oldStudent == null ? null : student;
    // }
    //**PUT
    public ResponseEntity<ReadFromJson> updateWatchlist() throws ItemNotFoundException{
        Watchlist currentWatchlist = null; //variable that holds files deserialized .findById(id).orElse(null)
        if(currentWatchlist = null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
             create(Watchlist updateWatchlist);
        // return new ResponseEntity<>(response, HttpStatus.OK);
            }
        return new ResponseEntity<>(updatedWatchlist, HttpStatus.OK);
        }
        
    }


    // // public deserializeToJSON postResponseJsonContent(
    // //     @RequestBody UpdateList updateList) {
    // //     return new deserializeToJSON("JSON FILES");

    // public ResponseEntity<UpdateList> updateWatchlist(@PathVariable UUID id, @RequestBody Watchlist watchlist){
    //     Watchlist currentWatchlist = watchlistRepository.findById(id).orElse(null);
    //     if(currentWatchlist == null) {
    //         return 
    //     }
    //     currentWatchlist.setStockName(watchlist.getStockName());
    //     currentWatchlist.setSymbol(watchlist.getSymbol());
    //     currentWatchlist.setOwned(watchlist.isOwned());
    //     currentWatchlist.setStatus(watchlist.getStatus());
    //     currentWatchlist.setCurrency(watchlist.getCurrency());
    //     currentWatchlist.setDatePurchased(watchlist.getDatePurchased());
    //     currentWatchlist.setUnitsOwned(watchlist.getUnitsOwned());
    //     currentWatchlist.setProfit(watchlist.getProfit());
    //     currentWatchlist.setOpen(watchlist.getOpen());
    //     currentWatchlist.setClose(watchlist.getClose());
    //     currentWatchlist.setIntradayHigh(watchlist.getIntradayHigh());
    //     Watchlist updatedWatchlist = watchlistRepository.save(currentWatchlist);
    //     UpdateList response = new UpdateList(currentWatchlist, updatedWatchlist);

    //     return new ResponseEntity<>(response, HttpStatus.OK);
    // //     // return new ResponseEntity<>(updatedWatchlist, HttpStatus.OK);
    // // // @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    // // // @ResponseBody // may need to remove this to put in own personal serialization to deserialization points
    // // // public deserializeToJSON postResponseJsonContent(
    // // //     @RequestBody UpdateList updateList) {
    // // //     return new deserializeToJSON("JSON FILES");
    // }
    
// @Override
//     public ResponseEntity<UpdateList> updateWatchlist(UUID id, Watchlist watchlist) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'updateWatchlist'");
//     }
    
    
}
