package com.cbfacademy.apiassessment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AppTests {

	@LocalServerPort
	private int port;

	private URL base;

	@Autowired
	private TestRestTemplate restTemplate;

	@BeforeEach
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/greeting");
	}

	@Test
	@Description("/greeting endpoint returns expected response for default name")
	public void greeting_ExpectedResponseWithDefaultName() {
		ResponseEntity<String> response = restTemplate.getForEntity(base.toString(), String.class);

		assertEquals(200, response.getStatusCode().value());
		assertEquals("Hello World", response.getBody());
	}

	@Test
	@Description("/greeting endpoint returns expected response for specified name parameter")
	public void greeting_ExpectedResponseWithNameParam() {
		ResponseEntity<String> response = restTemplate.getForEntity(base.toString() + "?name=John", String.class);

		assertEquals(200, response.getStatusCode().value());
		assertEquals("Hello John", response.getBody());
	}

	// @Test
	// @Description("/ShowWatchlists endpoint returns a list of the current items in the watchlist")
	// public void ShowWatchlists_ExpectedResponseWithCurrentDocumentAdded(){
	// 	ResponseEntity<String> response = restTemplate.getForEntity(base.toString() + "", String.class);

	// 	assertEquals(200, response.getStatusCode().value());
	// 	assertEquals("", response.getBody());
	// }

	@Test
	@Description("/ShowWatchlist end point goes to localhost:8080/showwatchlist")
	public void showwatchlistsEndpointIslocalhost8080showwatchlists(){
		String url = "http://localhost:" + port + "/ShowWatchlists";
		HttpStatusCode statusCode = restTemplate.getForEntity(url, String.class).getStatusCode();
		assertEquals(HttpStatus.OK, statusCode);
	}

	@Test
	@Description("/AddStock endpoint goes to localhost:8080/addStock")
	public void addStockEndpointIslocalhost8080addstock(){
		String url = "http://localhost:" + port + "/addstock";
		HttpStatusCode statusCode = restTemplate.getForEntity(url, String.class).getStatusCode();
		assertEquals(HttpStatus.OK, statusCode);
	}
	// do a 404 NOT_FOUND
}
