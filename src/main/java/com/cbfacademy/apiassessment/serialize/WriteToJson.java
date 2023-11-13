package com.cbfacademy.apiassessment.serialize;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbfacademy.apiassessment.model.CreateWatchlist;
import com.cbfacademy.apiassessment.model.Watchlist;

@Service
public class WriteToJson {

    private CreateWatchlist createList;
    private static final Logger log = LoggerFactory.getLogger(WriteToJson.class);

        // registersTypeAdapter at the same time GsonBuilder is initialized to stop the 'java.time.LocalDate#year' accessible; issue.

    // @Autowired
    // public WriteToJson(CreateWatchlist createList) {
    //     this.createList = createList;
    // }

    // Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new DateTypeAdapter()).create();

    // String jsonString = gson.toJson(createList);

    // public void writeToJson() throws FailureToIOJsonException {
    //     String jsonRepo = "JsonWatchlist.json";
    //     try {
    //         CreateWatchlist createWatchlist = new CreateWatchlist();
    //         // List<Watchlist> newEntry = new ArrayList<>();
    //         List<Watchlist> existingListData = gson.fromJson("JSON STRING", new TypeToken<List<Watchlist>>() {}.getType());
    //         existingListData.add(createWatchlist);

    //         try (FileWriter writer = new FileWriter(jsonRepo, true)) {
    //             gson.toJson(existingListData, writer);
    //         } catch (IOException e) {
    //             log.error("Serialized watchlist failed to write to Json file.", e);
    //             throw new FailureToIOJsonException("IOException occurred while attempting to write new data to JSON.", e);
    //         }

    //     } catch (IOException e) {
    //         log.error("Failed to add createWatchlist to the new entry array", e);
    //         throw new FailureToIOJsonException("Exception occurred while trying to write createWatchlist to the addEntry array.", e);
    //     }
    // }
}
