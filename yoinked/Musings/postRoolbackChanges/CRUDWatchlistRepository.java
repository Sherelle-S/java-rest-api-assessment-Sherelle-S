package com.cbfacademy.apiassessment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cbfacademy.apiassessment.model.Watchlist;

@Repository
public interface CRUDWatchlistRepository extends CrudRepository<Watchlist, Long>{
    
}
