package com.cbfacademy.apiassessment.serialize;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import com.cbfacademy.apiassessment.model.CreateWatchlist;
import com.cbfacademy.apiassessment.model.Watchlist;

public class WriteToJsonFile {
    
    private CreateWatchlist createList;
    
    public void writeListToJson(){
        String jsonRepo = "JsonWatchlist.json";
        try (FileWriter writer = new FileWriter(jsonRepo, true)createList) {
            writer.write(createList.toJ)
        } catch (IOException e) {
                log.error("Serialized watchlist failed to write to Json file.", e);
                throw new FailureToIOJsonException("IOException occurred while attempting to write new data to JSON.", e);
            }

    }
}
