package com.cbfacademy.apiassessment.deserialize;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.json.simple.JSONArray;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.cbfacademy.apiassessment.exceptions.ItemNotFoundException;
import com.cbfacademy.apiassessment.exceptions.JsonWatchlistParsingException;
import com.cbfacademy.apiassessment.model.CreateWatchlist;
import com.cbfacademy.apiassessment.serialize.WriteToJson;

public class ReadFromJson {

    private static final Logger log = LoggerFactory.getLogger(WriteToJson.class);


    public String readJsonWatchlist() throws FileNotFoundException{
        String jsonRepo = "JsonWatchlist.json";
        try (FileReader reader = new FileReader("JsonWatchlist.json")) {
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(reader);
            
            JSONArray deserializedList = (JSONArray) obj;
            return deserializedList.toJSONString();
            // if (obj instanceof JSONAware) {
            //     return ((JSONAware) obj).toJSONString();
            // } else {
            //     // Handle the case when obj is not an instance of JSONAware
            //     return obj.toString();
            // }
            // return deserializedList;
        } catch (ParseException e) {
            log.error("Exception ocurred during json parse to write file.", e);
            // throw new JsonWatchlistParsingException("Exception ocurred at readJsonWatchlist when trying to parse file.", e);
        } catch (FileNotFoundException e ){
            log.error("File that we a re reading cannot be found", e);
            throw new ItemNotFoundException(jsonRepo);
        } catch (IOException e) {
            log.error("Reader closed before resources had finished", e);
        }
        // return readJsonWatchlist();
        return jsonRepo;
    }

    // private static final Logger log = LoggerFactory.getLogger(WriteToJson.class);   
    // private CreateWatchlist createWatchlist;
     
    // public ReadFromJson(CreateWatchlist createWatchlist) {
    //         this.createWatchlist = createWatchlist;
            
    //     }

    // // public void getAllWatchlist() throws FailureToIOJsonException{
    //     public void getAllWatchlist() throws FailureToIOJsonException{
    // //  path to be read from 
    //     String inputFile = "JsonWatchlist.json";
    //    try {
    //     CreateWatchlist getAllItems = new Gson().fromJson(inputFile, CreateWatchlist.class);
    //     getAllItems.toString();
        
    // //     // return jsonString;
    // //    } catch (InabilityToMapToJson e) {
    // //     log.error("Json mapper failed to execute object mapping at ReadFromJson class", e);
    //    } catch (FailureToIOJsonException e){
    //     log.error("Failed to deserialize json file at ReadFromJson class", e);
    //    } catch (IOException e){
    //     log.error("failed to IO at ReadFromJson", e);

    //    }

        // Object object = new ObjectMapper().readValue(inputFile, object.class);
    // }

}
