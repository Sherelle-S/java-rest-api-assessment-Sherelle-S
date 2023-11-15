// package com.cbfacademy.apiassessment.updateItem;

// import java.io.IOException;
// import java.util.List;
// import java.util.UUID;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Service;

// import com.cbfacademy.apiassessment.appendingActions.ReadExistingWatchlist;
// import com.cbfacademy.apiassessment.appendingActions.RunAppendingActions;
// import com.cbfacademy.apiassessment.appendingActions.UpdateAndWrite;
// import com.cbfacademy.apiassessment.exceptions.FailedToIOWatchlistException;
// import com.cbfacademy.apiassessment.exceptions.JsonWatchlistParsingException;
// import com.cbfacademy.apiassessment.model.Watchlist;
// import com.fasterxml.jackson.core.JsonProcessingException;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

// @Service
// public class RunUpdatingActivities {

//     private static final Logger log = LoggerFactory.getLogger(RunUpdatingActivities.class);
//     // private ObjectMapper mapper;
//     // private ReadExistingWatchlist readList;
//     // private UpdateAndWrite updateAndWrite;
//     // private UpdateByName updateByName;
//     // private UuidViaName uuidViaName;
    
//     // @Autowired
//     // public RunUpdatingActivities( ObjectMapper mapper, ReadExistingWatchlist readList, UpdateAndWrite updateAndWrite, UpdateByName updateByName, UuidViaName uuidViaName) {
//     //     this.mapper =  mapper;
//     //     this.mapper.registerModule(new JavaTimeModule());
//     //     this.readList = readList;
//     //     this.updateAndWrite = updateAndWrite;
//     //     this.updateByName = updateByName;
//     //     this.uuidViaName = uuidViaName;
//     // }

//     // public void runUpdatingActivities(List<Watchlist> watchlist, String stockName, String jsonRepo, UUID uuid) throws JsonWatchlistParsingException, FailedToIOWatchlistException{
//     //      try{
//     //         List<Watchlist> existingWatchlist = readList.readExistingWatchlist(jsonRepo, mapper);
//     //         updateByName.updateItemsByName(stockName, existingWatchlist);
//     //         updateAndWrite.writeUpdatedWatchlist(jsonRepo, mapper, existingWatchlist);
//     //         log.info("Run updating activities is complete.");
//     //     }catch (JsonProcessingException e){
//     //         log.error("Exception ocured while updating json file with modified entry.", e.getMessage());
//     //         throw new JsonWatchlistParsingException("Exception triggered while processing PUT request.", e.getMessage());
//     //     }catch (IOException e){
//     //         log.error("IOException triggered while processing PUT request.", e.getMessage());
//     //         throw new FailedToIOWatchlistException(e.getMessage());
//     //     }
//     // }
// }
