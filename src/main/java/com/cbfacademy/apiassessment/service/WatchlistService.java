package com.cbfacademy.apiassessment.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cbfacademy.apiassessment.model.Watchlist;

public interface WatchlistService {

    public ResponseEntity<List<Watchlist>> getAllWatchlist();
}
