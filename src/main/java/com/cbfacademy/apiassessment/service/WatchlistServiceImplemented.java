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
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cbfacademy.apiassessment.exceptions.FailureToIOJsonException;
import com.cbfacademy.apiassessment.exceptions.ItemNotFoundException;
import com.cbfacademy.apiassessment.model.CreateWatchlist;
import com.cbfacademy.apiassessment.model.Watchlist;
import com.cbfacademy.apiassessment.serialize.WriteToJson;
// import com.cbfacademy.apiassessment.service.ReadFromJson;
import com.fasterxml.jackson.databind.ObjectMapper;


// implements the business logic of how to make the endpoints work
@Service
public class WatchlistServiceImplemented implements WatchlistService {

    private static final Logger log = LoggerFactory.getLogger(WatchlistServiceImplemented.class);
    private CreateWatchlist createWatchlist;
    private ObjectMapper mapper;
    private Watchlist watchlist;
    private WriteToJson response;
    
    // private ReadFromJson readList;

    // public WatchlistServiceImplemented(  ReadFromJson readList) {
        @Autowired
        public WatchlistServiceImplemented(CreateWatchlist createWatchlist, ObjectMapper mapper, Watchlist watchlist, WriteToJson response) {
        this.createWatchlist = new CreateWatchlist();
        this.mapper = mapper;
        this.response = response;
        this.watchlist = watchlist;

        // this.readList = readList;
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

// fetches the data from updated watchlist for use in business logic
    public CreateWatchlist getWatchlistData(){
        return createWatchlist;
    }

    
    @Override
    // POST
    // Gets data from user input, creates a WriteToJson object and writes the response to json returning a http status created if it succeeds.
    public ResponseEntity<WriteToJson> create() throws FailureToIOJsonException{
        // UUID CreateWatchlist = createWatchlist.getUuid();
        CreateWatchlist createList = getWatchlistData();
        response = new WriteToJson(createList, mapper);
        try {
            response.writeToJson();
        } catch (FailureToIOJsonException e) {
            log.error("File is unable to be written to json, exception ocurred in watchlist service implementation.");
            e.printStackTrace();
            throw new FailureToIOJsonException("Exception occurred while sending data over to json writer.");
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // @Override
    // public ResponseEntity<List<Watchlist>> getAllWatchlist() {
    //   List<Watchlist> list;
    //    list = new ArrayList<>();
    //    list.add(new CreateWatchlist(null, "Gold", "XAU", true, "TestStatus", "GBP", LocalDate.now(), 100, 50.0, 2.0, 60.0, 62.0, 70.0));
    //     return new ResponseEntity<>(list, HttpStatus.OK);
    //     }
        
    // //GET
    // public ResponseEntity<List<Watchlist>> getAllWatchlist() {
    //     List<Watchlist> watchlist;
    //     try{
    //         watchlist = readList.readFromJson("JsonWatchlist.json");
    //     } catch (FailureToIOJsonException e) {
    //         log.error("Failed to return deserialized watchlist at controller");
    //         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    //     return new ResponseEntity<>(watchlist, HttpStatus.OK);
    // }
    
    // public Student update(Long id, Student student) {
    //     student.setId(id);
    //     Student oldStudent = repository.replace(id, student);
    //     return oldStudent == null ? null : student;
    // }
    //**PUT
    // public ResponseEntity<ReadFromJson> updateWatchlist() throws ItemNotFoundException{
    //     CreateWatchlist currentWatchlist = null; //variable that holds files deserialized .findById(id).orElse(null)
    //     if(currentWatchlist = null){
    //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //     } else {
    //          create(CreateWatchlist updateWatchlist);
    //     // return new ResponseEntity<>(response, HttpStatus.OK);
    //         }
    //     return new ResponseEntity<>(updatedWatchlist, HttpStatus.OK);
    //     }
        
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
    
    
// }
