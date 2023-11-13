package com.cbfacademy.apiassessment.serialize;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbfacademy.apiassessment.exceptions.InvalidInputException;
import com.cbfacademy.apiassessment.model.Watchlist;

@Service
public class WriteToJsonFile {
    
    private static final Logger log = LoggerFactory.getLogger(WriteToJsonFile.class);
    @Autowired
    private SerializeWatchlist serializeWatchlist;
    
    public void writeListToJson(Watchlist watchlist) throws InvalidInputException{
        String jsonRepo = "JsonWatchlist.json";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(jsonRepo, true))) {
            String jsoString = serializeWatchlist.formatWatchlist(watchlist);
            writer.write(jsoString);
            writer.newLine();
        } catch (IOException e) {
                log.error("Serialized watchlist failed to write to Json file.", e);
                throw new InvalidInputException("IOException occurred while attempting to write new data to JSON.", e);
            }
    }
}
