package com.cbfacademy.apiassessment;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RunUserInteractions {
    //initialiszing the user interactions object  passing in the neccessary scanner class.
    @Bean
    public UserInteractions userInteractions(){

        return new UserInteractions(new Scanner(System.in));
    }

}
