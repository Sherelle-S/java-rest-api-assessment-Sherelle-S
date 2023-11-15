package com.cbfacademy.apiassessment.appendingActions;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cbfacademy.apiassessment.exceptions.FailedToIOWatchlistException;
import com.cbfacademy.apiassessment.exceptions.JsonWatchlistParsingException;
import com.cbfacademy.apiassessment.model.Watchlist;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;

// Responsible to controlling the components that append a new entry to the json file
@Component 
public class AppendNewEntry {

    private static final Logger log = LoggerFactory.getLogger(AppendNewEntry.class);

    private AddWatchlistItem appendEntry;
    private ObjectMapper mapper;
    private ReadExistingWatchlist readList;
    private UpdateAndWrite updateAndWrite;

    @Autowired
       public AppendNewEntry(AddWatchlistItem appendEntry, ObjectMapper mapper, ReadExistingWatchlist readList,
            UpdateAndWrite updateAndWrite) {
        this.appendEntry = appendEntry;
        this.mapper = mapper;
        this.readList = readList;
        this.updateAndWrite = updateAndWrite;
    }

    public void appendWatchlist(List<Watchlist> watchlist, String jsonRepo) throws IOException{

        try {
            List<Watchlist> existingWatchlist = readList.readExistingWatchlist(jsonRepo, mapper);
            for(Watchlist entry : watchlist){
                existingWatchlist.add(entry);
            }
            log.info("ExistingWatchlist in AppendWatchlist: {}", existingWatchlist);
            // appendEntry.appendNewWatchlist(watchlist, existingWatchlist);
            updateAndWrite.writeUpdatedWatchlist(jsonRepo, mapper, existingWatchlist);
        } catch (JacksonException e) {
            log.error("Exception while trying to process json request with jackson", e.getMessage());
            throw new JsonWatchlistParsingException("Exception ocurred while trying to parse json file.", e.getMessage());
        } catch (IOException e) {
            log.error("Exception occurred while running Appending components to watchlist");
            throw new FailedToIOWatchlistException("IOException ocurred while running appendWatchlist method.", e.getMessage());
        }
    }
}

