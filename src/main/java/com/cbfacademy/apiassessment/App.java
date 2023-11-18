package com.cbfacademy.apiassessment;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// import com.cbfacademy.apiassessment.WatchlistRepository;
// annotations tell spring this is the class where everything will run from, its also a controller with the ability to map requests, componentScan let spring know this is a base class, everything show be variable from here.
@SpringBootApplication
@RestController
@ComponentScan(basePackages = "com.cbfacademy.apiassessment")
public class App implements CommandLineRunner{

	public static void main(String[] args) {
		
		SpringApplication.run(App.class, args);
	}

	@GetMapping("/greeting")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
			return String.format("Hello %s", name);
			
	}

	@Override
    public void run(String... args) throws Exception {
		}
	}
