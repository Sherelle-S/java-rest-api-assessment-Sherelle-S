package com.cbfacademy.apiassessment.crudActions.appendingActions.createEntry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cbfacademy.apiassessment.crudActions.appendingActions.sharedCrudMethods.WriteToJsonFile;
import com.cbfacademy.apiassessment.exceptions.FailedToIOWatchlistException;
import com.cbfacademy.apiassessment.exceptions.JsonWatchlistParsingException;
import com.cbfacademy.apiassessment.model.Watchlist;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Component
public class CreateFirstItem {
    
    private static final Logger log = LoggerFactory.getLogger(RunCreatingActions.class);
    
    @Autowired
    private AddWatchlistItem addWatchlistItem;
    private ObjectMapper mapper;
    private WriteToJsonFile writeToJson;

    
    public CreateFirstItem(AddWatchlistItem addWatchlistItem, ObjectMapper mapper, WriteToJsonFile writeToJson) {
        this.addWatchlistItem = addWatchlistItem;
        this.mapper = mapper;
        this.mapper = mapper.registerModule(new JavaTimeModule());
        this.writeToJson = writeToJson;
    }

    public void CreateFirstEntry(List<Watchlist> watchlist, String jsonRepo) throws IOException{
        try {
            List<Watchlist> newWatchlistEntry = new ArrayList<>();
            newWatchlistEntry = addWatchlistItem.appendToWatchlist(watchlist, newWatchlistEntry);
            writeToJson.writeToJson(jsonRepo, mapper, newWatchlistEntry);
        } catch (JacksonException e) {
            log.error("Exception while trying to process json request with jackson", e.getMessage());
            throw new JsonWatchlistParsingException("Exception ocurred while trying to parse json file.", e.getMessage());
        } catch (IOException e) {
            log.error("Exception occurred while running Appending components to watchlist");
            throw new FailedToIOWatchlistException("IOException ocurred while running appendWatchlist method.", e.getMessage());
        }
    }
}
