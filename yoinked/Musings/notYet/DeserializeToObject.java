package com.cbfacademy.apiassessment.deserialize;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cbfacademy.apiassessment.exceptions.FailureToIOJsonException;
import com.cbfacademy.apiassessment.model.CreateWatchlist;
import com.cbfacademy.apiassessment.model.Watchlist;
import com.cbfacademy.apiassessment.serialize.DateTypeAdapter;
import com.cbfacademy.apiassessment.serialize.WriteToJson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

    // reuseable class that deserializes the data in JsonWatchlist into an arrayList that can be used by other methods

public class DeserializeToObject {

    // private CreateWatchlist createList;
    // private static final Logger log = LoggerFactory.getLogger(WriteToJson.class);   


    // @Autowired
    // public DeserializeToObject(CreateWatchlist createList) {
    //     this.createList = createList;
    // }
    //     Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new DateTypeAdapter()).create();

    
    //     public List<Watchlist> deserializeToObject() throws IOException{
    //     String jsonString = gson.toJson(createList);

    //     // try {
    //         List<Watchlist> existingListData = gson.fromJson(jsonString, new TypeToken<List<Watchlist>>() {}.getType());
    //         if(existingListData == null) {
    //             existingListData = new ArrayList<>();
    //         }
    //         existingListData.add(createList);
    //     return existingListData;
    //     // } catch (IOException e) {
    //         // log.error("Failed to create existing List data array when deserializng from gson in deserialize to object method.", e);
    //         // throw new FailureToIOJsonException("Failed to read json at deserialeToObject method.", e);
    //     // }
        
    // }
    
}
