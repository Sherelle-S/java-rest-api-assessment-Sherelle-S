// CURRENTLY TURNED OFF AS DESERIALIZE WATCHLIST HANDLES THIS FOR US

// package com.cbfacademy.apiassessment.deserialize;

// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.File;
// import java.io.FileNotFoundException;
// import java.io.FileReader;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.stereotype.Service;
// import org.json.simple.JSONArray;
// import org.json.simple.JSONAware;
// import org.json.simple.JSONObject;
// import org.json.simple.parser.JSONParser;
// import org.json.simple.parser.ParseException;

// import com.cbfacademy.apiassessment.exceptions.ItemNotFoundException;
// import com.cbfacademy.apiassessment.exceptions.JsonWatchlistParsingException;
// import com.cbfacademy.apiassessment.model.CreateWatchlist;
// import com.cbfacademy.apiassessment.model.Watchlist;
// import com.cbfacademy.apiassessment.serialize.WriteToJson;
// import com.fasterxml.jackson.core.JsonParseException;

// @Service
// public class ReadJsonObject {

//     private static final Logger log = LoggerFactory.getLogger(ReadJsonObject.class);

//      public List<Watchlist> readJsonWatchlist() throws JsonWatchlistParsingException, ParseException {
//         String jsonRepo = "JsonWatchlist.json";
//         List<Watchlist> currentList = new ArrayList<>();

//         try (FileReader reader = new FileReader(jsonRepo); BufferedReader bufferedReader = new BufferedReader(reader)){
//             StringBuilder stringBuilder = new StringBuilder();
//             String line = bufferedReader.readLine();
//                 while (line != null){
//                     stringBuilder.append(line);
//                     line = bufferedReader.readLine();
//                 }

//                 JSONArray watchlistArray = (JSONArray) new JSONParser().parse(stringBuilder.toString());

//                 for(Object listAsObject : watchlistArray){
//                     Watchlist completeList = new Watchlist((JSONObject) listAsObject);
//                     currentList.add(completeList);
//                 }
//             return currentList;
//         } catch (ItemNotFoundException e) {
//             log.error("File that we are reading cannot be found", e);
//             throw new ItemNotFoundException("Failed to find " + jsonRepo + "when executing ReadJsonObject.");
//         } catch (ParseException e) {
//             log.error("Failed to Parse data in ReadJsonObject", e);
//             throw new JsonWatchlistParsingException("Failed to parse JSON in ReadJsonObject class.", e);
//         } catch (IOException e) {
//             log.error("IOException occurred at readJsonWatchlist.", e);
//         }
//         return currentList;
//     }
// }
// //     public String readJsonWatchlist() throws FileNotFoundException, JsonWatchlistParsingException {
// //         String jsonRepo = "JsonWatchlist.json";

// //         JSONParser jsonParser = new JSONParser();
// //         try ( FileReader reader = new FileReader(jsonRepo)) {
// //             Object obj = jsonParser.parse(reader);
// //             JSONArray deserializedList = (JSONArray) obj;
// //             System.out.println(deserializedList);

// //             deserializedList.forEach( item -> parseWatchlistObject((JSONObject) item));
// //         } catch (Exception e) {
// //             // TODO: handle exception
// //         }
// //         try (FileReader reader = new FileReader(jsonRepo)) {
// //             JSONParser jsonParser = new JSONParser();
// //             Object obj = jsonParser.parse(reader);

// //             if (obj instanceof JSONArray) {
// //                 // Process JSONArray and format it as a string if needed
// //                 JSONArray deserializedList = (JSONArray) obj;
// //                 StringBuilder formattedData = new StringBuilder();

// //                 for (Object item : deserializedList) {
// //                     formattedData.append(item.toString()).append("\n");
// //                     // You can customize the formatting as needed
// //                 }

// //                 return formattedData.toString();
// //             } else {
// //                 // Handle the case when obj is not an instance of JSONArray
// //                 throw new JsonWatchlistParsingException("The content of JsonWatchlist.json is not a valid JSON array.");
// //             }
// //         } catch (ParseException e) {
// //             log.error("Exception occurred during JSON parse to read file.", e);
// //             throw new JsonWatchlistParsingException("Exception occurred at readJsonWatchlist when trying to parse file.", e);
// //         } catch (FileNotFoundException e) {
// //             log.error("File that we are reading cannot be found", e);
// //             throw new ItemNotFoundException(jsonRepo);
// //         } catch (IOException e) {
// //             log.error("Reader closed before resources had finished", e);
// //             // Handle the IOException appropriately, or consider logging it.
// //             throw new JsonWatchlistParsingException("IOException occurred at readJsonWatchlist.", e);
// //         }
// //     }
// // }
// // // public class ReadFromJson {

// // //     private static final Logger log = LoggerFactory.getLogger(WriteToJson.class);


// // //     public String readJsonWatchlist() throws FileNotFoundException{
// // //         String jsonRepo = "JsonWatchlist.json";
// // //         try (FileReader reader = new FileReader(jsonRepo)) {
// // //             JSONParser jsonParser = new JSONParser();
// // //             Object obj = jsonParser.parse(reader);

// // //             if(obj instanceof JSONArray){
// // //                 JSONArray deserializedList = (JSONArray) obj;
// // //                 StringBuilder formatReturnedList = new StringBuilder();
// // //                 for(Object list : deserializedList){
// // //                     formatReturnedList.append(list.toString()).append("\n");
// // //                 }
// // //                 return formatReturnedList.toString();
// // //                 }else{
// // //                     throw new JsonParseException("Invalid content returned from JsonWatchlist.");
// // //                 }
            
            
// // //             // JSONArray deserializedList = (JSONArray) obj;
// // //             // return deserializedList.toJSONString();
 
// // //         } catch (ParseException e) {
// // //             log.error("Exception ocurred during json parse to write file.", e);
// // //             // throw new JsonWatchlistParsingException("Exception ocurred at readJsonWatchlist when trying to parse file.", e);
// // //         } catch (FileNotFoundException e ){
// // //             log.error("File that we a re reading cannot be found", e);
// // //             throw new ItemNotFoundException(jsonRepo);
// // //         } catch (IOException e) {
// // //             log.error("Reader closed before resources had finished", e);
// // //         }
// // //         // return readJsonWatchlist();
// // //         // return jsonRepo;
// // //     }

// // //     // private static final Logger log = LoggerFactory.getLogger(WriteToJson.class);   
// // //     // private Watchlist createWatchlist;
     
// // //     // public ReadFromJson(CreateWatchlist createWatchlist) {
// // //     //         this.createWatchlist = createWatchlist;
            
// // //     //     }

// // //     // // public void getAllWatchlist() throws FailureToIOJsonException{
// // //     //     public void getAllWatchlist() throws FailureToIOJsonException{
// // //     // //  path to be read from 
// // //     //     String inputFile = "JsonWatchlist.json";
// // //     //    try {
// // //     //     CreateWatchlist getAllItems = new Gson().fromJson(inputFile, CreateWatchlist.class);
// // //     //     getAllItems.toString();
        
// // //     // //     // return jsonString;
// // //     // //    } catch (InabilityToMapToJson e) {
// // //     // //     log.error("Json mapper failed to execute object mapping at ReadFromJson class", e);
// // //     //    } catch (FailureToIOJsonException e){
// // //     //     log.error("Failed to deserialize json file at ReadFromJson class", e);
// // //     //    } catch (IOException e){
// // //     //     log.error("failed to IO at ReadFromJson", e);

// // //     //    }

// // //         // Object object = new ObjectMapper().readValue(inputFile, object.class);
// // //     // }

// // // }




// // // public class ReadFromJson {

// // //     private static final Logger log = LoggerFactory.getLogger(ReadFromJson.class);

// // //     public String readJsonWatchlist() throws FileNotFoundException {
// // //         String jsonRepo = "JsonWatchlist.json";
// // //         try (FileReader reader = new FileReader(jsonRepo)) {
// // //             JSONParser jsonParser = new JSONParser();
// // //             Object obj = jsonParser.parse(reader);

// // //             if (obj instanceof JSONArray) {
// // //                 // Process JSONArray and format it as a string if needed
// // //                 JSONArray deserializedList = (JSONArray) obj;
// // //                 StringBuilder formattedData = new StringBuilder();

// // //                 for (Object item : deserializedList) {
// // //                     formattedData.append(item.toString()).append("\n");
// // //                     // You can customize the formatting as needed
// // //                 }

// // //                 return formattedData.toString();
// // //             } else {
// // //                 // Handle the case when obj is not an instance of JSONArray
// // //                 throw new JsonWatchlistParsingException("The content of JsonWatchlist.json is not a valid JSON array.");
// // //             }
// // //         } catch (ParseException e) {
// // //             log.error("Exception occurred during JSON parse to read file.", e);
// // //             throw new JsonWatchlistParsingException("Exception occurred at readJsonWatchlist when trying to parse file.", e);
// // //         } catch (FileNotFoundException e) {
// // //             log.error("File that we are reading cannot be found", e);
// // //             throw new ItemNotFoundException(jsonRepo);
// // //         } catch (IOException e) {
// // //             log.error("Reader closed before resources had finished", e);
// // //             // Handle the IOException appropriately, or consider logging it.
// // //         }
// // //     }
// // // }