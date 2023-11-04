// package com.cbfacademy.apiassessment;

// import java.util.Scanner;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// @SpringBootApplication
// @RestController
// public class App {
// 	public static void main(String[] args) {
// 		SpringApplication.run(App.class, args);
// 	}

// 	@GetMapping("/greeting")
// 	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
// 		// try (Scanner sc = new Scanner(System.in);) {
// 		// 	System.out.println("What is your name?");
// 		// String userName = sc.nextLine();
// 		// 	return userName.isBlank() ? String.format("Hello %s", name) : String.format("Hello %s", userName);
// 		// } catch (Exception e) {	
// 		// 	System.out.println("Error occurred while greeting client.");
// 		// }
// 		// return greeting(name);

// 			return String.format("Hello %s", name);
// 	}

// }