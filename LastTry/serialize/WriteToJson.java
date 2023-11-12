package com.cbfacademy.apiassessment.serialize;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.cbfacademy.apiassessment.exceptions.FailureToIOJsonException;
import com.cbfacademy.apiassessment.model.AddListEntry;
import com.cbfacademy.apiassessment.model.CreateWatchlist;
import com.cbfacademy.apiassessment.model.Watchlist;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

// holds the logic that writes new watchlist  entries to json repository. method carries the logic of how to serialize to json
@Service
public class WriteToJson {

    private CreateWatchlist createList;
    private ObjectMapper mapper;
    private static final Logger log = LoggerFactory.getLogger(WriteToJson.class);    

    // registersModel at the same time object mapper is initialized to stop the Java 8 date/time type `java.time.LocalDate` not supported by default issue.
    @Autowired
    public WriteToJson(CreateWatchlist createList, ObjectMapper mapper) {
        this.createList = createList;
        this.mapper = mapper;
        this.mapper.registerModule(new JavaTimeModule());
    }

    public void writeToJson() throws FailureToIOJsonException {
        // public void writeToJson(List<Watchlist> watchlist, String outputFile) throws FailureToIOJsonException {

        if(mapper == null){
            mapper = new ObjectMapper();
        }
        
        File file = new File("JsonWatchlist.json");
        try {
                 CreateWatchlist createWatchlist = new CreateWatchlist(null, "Vodaphone", "VOD", true, "TestStatus", "GBP", LocalDate.now(), 100, 50.0, 2.0, 60.0, 62.0, 70.0);
        List<Watchlist> newEntry = new ArrayList<>();
        newEntry.add(createWatchlist);

        AddListEntry serializedWatchlist = new AddListEntry();
        serializedWatchlist.setNewEntry(newEntry);
            final String working = mapper.writeValueAsString(serializedWatchlist);
            Files.write(file.toPath(), Arrays.asList(working), StandardOpenOption.CREATE);
            } catch (IOException e) {
            log.error("serialized watchlist failed to write to Json file.", e);
            throw new FailureToIOJsonException("IOException occurred while attempting to write new data to JSON.", e);
        }
    }
    // }
    //     ObjectMapper mapper = new ObjectMapper();
    //     String outputFile = "JsonWatchlist.json";
    //     File file = new File(outputFile);
    //     try {
    //     CreateWatchlist createWatchlist = new CreateWatchlist(null, "Vodaphone", "VOD", true, "TestStatus", "GBP", LocalDate.now(), 100, 50.0, 2.0, 60.0, 62.0, 70.0);
    //     List<Watchlist> newEntry = new ArrayList<>();
    //     newEntry.add(createWatchlist);

    //     AddListEntry serializedWatchlist = new AddListEntry();
    //     serializedWatchlist.setNewEntry(newEntry);

    //     String JsonDataString = mapper.writeValue(Paths.get(outputFile).toFile(), newEntry);
    //     // mapper.writeValueAsString(serializedWatchlist);

    //     } catch (JsonProcessingException e) {
    //         // TODO Auto-generated catch block
    //         e.printStackTrace();
    //     }


    // }

    // // public void writeToJson() throws FailureToIOJsonException {
    // //     ObjectMapper objectMapper = new ObjectMapper();
    // //     String outputFile = "JsonWatchlist.json";
    // //     File file = new File(outputFile);
    // //     try {

    // //         if (file.exists()) {
    // //             // If the file exists, read the current data
    // //             List<CreateWatchlist>currentData = objectMapper.readValue(file, new TypeReference<List<CreateWatchlist>>() {});
    // //             currentData.add(createWatchlist);
    // //             objectMapper.writeValue(file, currentData);
    // //         } else {
    // //             List<CreateWatchlist> newData = new ArrayList<>();
    // //             newData.add(createWatchlist);
    // //             objectMapper.writeValue(file, newData);
    // //         }

    // //     } catch (IOException e) {
    // //         log.error("copy of user watchlist failed to write to Json file.", e);
    // //         throw new FailureToIOJsonException("IOException occurred while attempting to write input to JSON.", e);
    // //     } 
    // // }
}
