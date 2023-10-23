package com.cbfacademy.apiassessment;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class WatchlistController {

    // business logic layer that controls the aoi data 

    private final WatchlistRepository repository;

    WatchlistController(WatchlistRepository repository){
        this.repository = repository;
    }
    
}
