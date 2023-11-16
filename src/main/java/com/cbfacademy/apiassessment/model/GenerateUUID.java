package com.cbfacademy.apiassessment.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class GenerateUUID {
     private static final Map<String, Integer> stockNameIncrement = new HashMap<>();

    public Map<String, Integer> getStockNameIncrement() {
        return stockNameIncrement;
    }
}
