package com.cbfacademy.apiassessment.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.cbfacademy.apiassessment.model.Watchlist;
import com.fasterxml.jackson.databind.ObjectMapper;

import aj.org.objectweb.asm.TypeReference;

public class ReadFromJson {
// do you retrieve all items from json deserialize them all and then search id
// do you search id then deserialize from json update and return file
// creates a map of key value pairs to deserialize to and update 
    public ReadFromJson(){
        ObjectMapper mapper = new ObjectMapper();
        String jsonInput = null; //the json lest goes here find a variable to store it in.
        TypeReference<HashMap<Watchlist, Watchlist>> typeRef = new TypeReference<HashMap<Watchlist, Watchlist>>(){};
        Map<Watchlist, Watchlist> map = mapper.readValue(jsonInput, typeRef);
        return map.toString();
        // Map<String, String> listToUpdate = new HashMap<>();
        // listToUpdate.put("key", "value");

        // ObjectMapper mapper = new ObjectMapper();
        // String returnedItem = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(listToUpdate);
        // System.out.println(returnedItem);
        // Watchlist tempList = mapper.readValue(returnedItem, Watchlist.class);
        // System.out.println(tempList.getUuid() + " " +tempList.getStockName() + " " + tempList.getSymbol() + " " +tempList.isOwned() + " " + tempList.getStatus() + " " + tempList.getCurrency() + " " + tempList.getDatePurchased() + " " + tempList.getUnitsOwned() + " " + tempList.getProfit() + " " + tempList.getOpen() + " " + tempList.getClose() + " " + tempList.getIntradayHigh());
    }
    
    
}
