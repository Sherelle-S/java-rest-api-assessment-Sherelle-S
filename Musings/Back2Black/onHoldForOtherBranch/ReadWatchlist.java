package com.cbfacademy.apiassessment.deserialize;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.cbfacademy.apiassessment.exceptions.ItemNotFoundException;
import com.cbfacademy.apiassessment.exceptions.JsonWatchlistParsingException;

public class ReadWatchlist {

    public String readJsonWatchlist() throws ItemNotFoundException, JsonWatchlistParsingException { 
    try (FileReader reader = new FileReader(jsonRepo); BufferedReader bufferedReader = new BufferedReader(reader)){
            StringBuilder stringBuilder = new StringBuilder();
            String line = bufferedReader.readLine();
                while (line != null){
                    stringBuilder.append(line);
                }
            return stringBuilder.toString();
        } catch (ItemNotFoundException e) {
            log.error("File that we are reading cannot be found", e);
            throw new ItemNotFoundException(jsonRepo);
        } catch (JsonWatchlistParsingException e) {
            log.error("Reader closed before resources had finished", e);
            throw new JsonWatchlistParsingException("IOException occurred at readJsonWatchlist.", e);
        } catch (IOException e) {
            throw new IOException("Unexpected ");
        }
    }
}

