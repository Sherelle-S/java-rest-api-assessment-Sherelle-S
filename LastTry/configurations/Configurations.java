package com.cbfacademy.apiassessment.configurations;

import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.cbfacademy.apiassessment.model.Watchlist;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

// spring beans that needed to be manually configured
@Configuration
public class Configurations {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    // @Bean
    // public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
    //     return builder.build();
    // }

    @Bean
    public Jackson2ObjectMapperBuilder objectMapperBuilder() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        builder.modulesToInstall(new JavaTimeModule());
        return builder;
    }

    // @Bean
    // public UUID uuid(){
    //     return watchlist().generateUUID("default");
    // }

    // @Bean
    // public Watchlist watchlist(){
    //     return new Watchlist();
    // }

    // @Bean
    // public String defaultStockName() {
    //     return "default";
    // }
    
}
