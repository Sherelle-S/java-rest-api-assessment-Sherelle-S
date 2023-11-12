package com.cbfacademy.apiassessment.serialize;

import java.io.IOException;
import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cbfacademy.apiassessment.exceptions.FailedToIOWatchlistException;
import com.cbfacademy.apiassessment.model.CreateWatchlist;
import com.cbfacademy.apiassessment.model.Watchlist;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class SerializeWatchlist {
    
    private static final Logger log = LoggerFactory.getLogger(WriteToJson.class);
    protected Watchlist watchlist;

    public SerializeWatchlist() {
    }
    public SerializeWatchlist(Watchlist watchlist) {
        this.watchlist = watchlist;
    }

    public String formatWatchlist(CreateWatchlist createWatchlist) throws FailedToIOWatchlistException {

        ObjectMapper mapper = new ObjectMapper();

        CreateWatchlist newList = new CreateWatchlist(null, "Vodaphone", "VOD", true, "TestStatus", "GBP", LocalDate.now(), 100, 50.0, 2.0, 60.0, 62.0, 70.0);

        try {
            String jsonResult = mapper.writeValueAsString(watchlist);
            return jsonResult;
        } catch (IOException e) {
            log.error("watchlist failed to write to json in formatList method.", e);
            throw new FailedToIOWatchlistException("Failed to serialize watchlist to json format", e);
        }
        

//         List<CreateWatchlist> 
    }
}
