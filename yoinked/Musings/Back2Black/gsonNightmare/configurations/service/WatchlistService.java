package com.cbfacademy.apiassessment.service;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cbfacademy.apiassessment.deserialize.ReadFromJson;
import com.cbfacademy.apiassessment.exceptions.FailureToIOJsonException;
import com.cbfacademy.apiassessment.model.CreateWatchlist;
import com.cbfacademy.apiassessment.model.Watchlist;
import com.cbfacademy.apiassessment.serialize.WriteToJson;

public interface WatchlistService {


    public ResponseEntity<WriteToJson> create() throws FailureToIOJsonException;
}
