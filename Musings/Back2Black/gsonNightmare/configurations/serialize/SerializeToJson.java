package com.cbfacademy.apiassessment.serialize;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cbfacademy.apiassessment.exceptions.FailureToIOJsonException;
import com.cbfacademy.apiassessment.model.Watchlist;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SerializeToJson {

    private static final Logger log = LoggerFactory.getLogger(WriteToJson.class);
    Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new DateTypeAdapter()).create();
// see if we can take in the arrayList to be serialized as a parameter
    public void serializeToJson(List<Watchlist> incomingList) throws FailureToIOJsonException{
        String jsonRepo = "JsonWatchlist.json";

        try (FileWriter writer = new FileWriter(jsonRepo, true)) {
                // gson.toJson(existingListData, writer);
                gson.toJson(incomingList, writer);
            } catch (IOException e) {
                log.error("Serialized watchlist failed to write to Json file.", e);
                throw new FailureToIOJsonException("IOException occurred while attempting to write new data to JSON.", e);
            }
    }
}
