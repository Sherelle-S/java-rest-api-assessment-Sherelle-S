package com.cbfacademy.apiassessment;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@GetMapping("/greeting")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
			return String.format("Hello %s", name);
			
	}

	@GetMapping("/hi")
	private List<WatchlistConstructor> hello() {
		return List.of(
			new WatchlistConstructor(
				1,
				"Gold",
				"GLD",
				true,
				"Hold",
				"GBP",
				LocalDate.of(2020, Month.APRIL, 21),
				1200,
				1.25,
				1.298,
				6.267,
				6.287,
				6.316
			)
		);
	}

	// @PostMapping("/create")
	// public 


	// @PutMapping("/update")
	// public

	// @DeleteMapping("/delete")
	// // public

}
