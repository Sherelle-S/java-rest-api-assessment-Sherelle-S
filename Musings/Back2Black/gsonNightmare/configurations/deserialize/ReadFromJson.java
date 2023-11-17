package com.cbfacademy.apiassessment.deserialize;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cbfacademy.apiassessment.exceptions.FailureToIOJsonException;
import com.cbfacademy.apiassessment.exceptions.InabilityToMapToJson;
import com.cbfacademy.apiassessment.model.CreateWatchlist;
import com.cbfacademy.apiassessment.serialize.WriteToJson;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.Gson;

public class ReadFromJson {

    private static final Logger log = LoggerFactory.getLogger(WriteToJson.class);   
    private CreateWatchlist createWatchlist;
     
    public ReadFromJson(CreateWatchlist createWatchlist) {
            this.createWatchlist = createWatchlist;
            
        }

    // public void getAllWatchlist() throws FailureToIOJsonException{
        public CreateWatchlist getAllWatchlist() throws FailureToIOJsonException{
    //  path to be read from 
        String inputFile = "JsonWatchlist.json";
       try (FileReader reader = new FileReader(inputFile)){
        CreateWatchlist getAllItems = new Gson().fromJson(reader, CreateWatchlist.class);
        return getAllItems;
        
    //     // return jsonString;
    //    } catch (InabilityToMapToJson e) {
    //     log.error("Json mapper failed to execute object mapping at ReadFromJson class", e);
    //    } catch (FailureToIOJsonException e){
    //     log.error("Failed to deserialize json file at ReadFromJson class", e);
       } catch (IOException e){
        log.error("failed to IO at ReadFromJson", e);
        throw new FailureToIOJsonException();

       }

        // Object object = new ObjectMapper().readValue(inputFile, object.class);
    }

}
