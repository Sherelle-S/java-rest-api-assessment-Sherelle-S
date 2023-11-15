package com.cbfacademy.apiassessment.appendingActions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cbfacademy.apiassessment.exceptions.FailedToIOWatchlistException;
import com.cbfacademy.apiassessment.exceptions.ItemNotFoundException;
import com.cbfacademy.apiassessment.model.Watchlist;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

//  reads jsonRepo and reads the the data into a watchlist
@Component
public class ReadExistingWatchlist {

    private static final Logger log = LoggerFactory.getLogger(ReadExistingWatchlist.class);

    public List<Watchlist> readExistingWatchlist(String jsonRepo, ObjectMapper mapper) throws IOException {

        try {
            mapper.registerModule(new JavaTimeModule());
            log.info("jsonRepo has been read");
            return mapper.readValue(new File(jsonRepo), new TypeReference<List<Watchlist>>() {});
        } catch (JsonProcessingException e) {
            log.error("Failed to read json file.", e.getMessage());
            throw new FailedToIOWatchlistException("Processing json request failed.", e.getMessage());
        } catch (FileNotFoundException e) {
            log.error("json File could not be found.", e.getMessage());
            throw new ItemNotFoundException("jsonRepo could not be located.", e.getMessage());
        }   catch (IOException e) {
            log.error("IOException ocurred while trying to read jsonRepo.", e.getMessage());
            throw new IOException("Json repo could not be.");
        }
    }
}


//  try {
//             mapper.registerModule(new JavaTimeModule());
//             log.info("jsonRepo has been read");
//             return mapper.readValue(new File(jsonRepo), new TypeReference<List<Watchlist>>() {});
//         } catch (JsonProcessingException e) {
//             log.error("Failed to read json file.", e.getMessage());
//             throw new FailedToIOWatchlistException("Processing json request failed.", e.getMessage());
//         } catch (FileNotFoundException e) {
//             log.error("json File could not be found.", e.getMessage());
//             throw new ItemNotFoundException("jsonRepo could not be located.", e.getMessage());
//         }   catch (IOException e) {
//             log.error("IOException ocurred while trying to read jsonRepo.", e.getMessage());
//         }
//         return null;