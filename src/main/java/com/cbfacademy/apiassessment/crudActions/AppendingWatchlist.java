package com.cbfacademy.apiassessment.crudActions;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cbfacademy.apiassessment.exceptions.FailedToIOWatchlistException;
import com.cbfacademy.apiassessment.exceptions.JsonWatchlistParsingException;
import com.cbfacademy.apiassessment.model.Watchlist;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;

// Responsible to controlling the components that append a new entry to the json file
@Component 
public class AppendingWatchlist {

    private static final Logger log = LoggerFactory.getLogger(AppendingWatchlist.class);

    private AppendEntry appendEntry;
    private ObjectMapper mapper;
    private ReadExistingWatchlist readList;
    private UpdateAndWrite updateAndWrite;

       public AppendingWatchlist(AppendEntry appendEntry, ObjectMapper mapper, ReadExistingWatchlist readList,
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

