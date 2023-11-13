package com.cbfacademy.apiassessment.exceptions;

import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonProcessingException;

public class JsonWatchlistParsingException extends JsonProcessingException{

    public JsonWatchlistParsingException(String msg, JsonLocation loc) {
        super(msg, loc);
    }

    public JsonWatchlistParsingException(String msg, ParseException cause) {
        super(msg);
    }

    public JsonWatchlistParsingException(String msg, Throwable rootCause) {
        super(msg, rootCause);
    }

    public JsonWatchlistParsingException(String msg) {
        super(msg);
    }

}
