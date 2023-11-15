package com.cbfacademy.apiassessment.serializingActions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbfacademy.apiassessment.exceptions.InvalidInputException;
import com.cbfacademy.apiassessment.model.Watchlist;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

// file is responsible for writing serialized object to json file
@Service
public class WriteToJsonFile {

    private static final Logger log = LoggerFactory.getLogger(WriteToJsonFile.class);
    private ObjectMapper mapper;
    @Autowired
    private SerializeWatchlist serializeWatchlist;

    // register JavaTimeModule with mapper 
    public WriteToJsonFile(ObjectMapper mapper) {
        this.mapper = mapper;
        this.mapper = mapper.registerModule(new JavaTimeModule());
    }
    
    public void writeListToJson(List<Watchlist> watchlist, String jsonRepo) throws InvalidInputException{
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(jsonRepo, true))) {
            String jsonString = serializeWatchlist.serialize(watchlist);
            writer.write(jsonString);
            writer.newLine();
        } catch (IOException e) {
                log.error("Serialized watchlist failed to write to Json file.", e);
                throw new InvalidInputException("IOException occurred while attempting to write new data to JSON.", e);
        }
    }
}
