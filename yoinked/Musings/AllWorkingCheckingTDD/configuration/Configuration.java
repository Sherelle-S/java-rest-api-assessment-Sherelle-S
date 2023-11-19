package com.cbfacademy.apiassessment.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.cbfacademy.apiassessment.controller.WatchlistController;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class Configuration {

        private static final Logger log = LoggerFactory.getLogger(WatchlistController.class);

    
        
        /** 
         * @return Jackson2ObjectMapperBuilder
         */
        @Bean
        public Jackson2ObjectMapperBuilder objectMapperBuilder() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        builder.modulesToInstall(new JavaTimeModule());
        log.info("objectMapper builder has been triggered");
        return builder;
    }
}
