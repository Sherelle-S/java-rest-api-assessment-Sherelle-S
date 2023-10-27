package com.cbfacademy.apiassessment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import com.cbfacademy.apiassessment.Exceptions.ItemNotFoundException;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
	@Description("/addEntry endpoint goes to localhost:8080/addEntry")
	public void addEntryEndpointIslocalhost8080addEntry(){
		String url = "http://localhost:" + port + "/addEntry";
		HttpStatusCode statusCode = restTemplate.getForEntity(url, String.class).getStatusCode();
		assertEquals(HttpStatus.OK, statusCode);
	}

	@Test
	@Description("/unknown endpoint returns 404")
	public void unknownEndpointReturns404(){
		String url = "http://localhost:" +port +"/unknown-endpoint";
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
		HttpStatusCode statusCode = restTemplate.getForEntity(url, String.class).getStatusCode();
		assertEquals(HttpStatus.NOT_FOUND, statusCode);
	}

	 @Test
    @DisplayName("/unknown endpoint throws itemNotFoundException")
    public void unknownEndpointThrowsException (){
		String url = "http://localhost:" +port +"/unknown-endpoint";

        assertThrows(ItemNotFoundException.class, () -> {
			restTemplate.getForEntity(url, String.class);
        });
    }
	// do a 404 NOT_FOUND
}
