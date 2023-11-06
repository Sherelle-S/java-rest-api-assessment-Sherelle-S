package com.cbfacademy.apiassessment;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cbfacademy.apiassessment.model.Watchlist;

// created repository for data access object that will carry out database accesss, storage and retrieval to the json formats.

@Repository
public interface WatchlistRepository extends CrudRepository<Watchlist, UUID>{
    
}