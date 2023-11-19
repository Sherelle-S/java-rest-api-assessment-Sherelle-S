package com.cbfacademy.apiassessment.configurations;

import java.time.LocalDate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import com.cbfacademy.apiassessment.serialize.DateTypeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Configuration
public class Configurations {

    
    /** 
     * @return GsonHttpMessageConverter
     */
    @Bean
    public GsonHttpMessageConverter gsonHttpMessageConverter() {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new DateTypeAdapter()).create();
        return new GsonHttpMessageConverter(gson);
    }    

    // @Bean
    // public ObjectMapper objectMapper() {
    //     return new ObjectMapper();
    // }

    // @Bean
    // public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
    //     return builder.build();
    // }

    // @Bean
    // public Jackson2ObjectMapperBuilder objectMapperBuilder() {
    //     Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
    //     builder.modulesToInstall(new JavaTimeModule());
    //     return builder;
    // }

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
