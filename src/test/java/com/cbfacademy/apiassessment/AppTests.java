package com.cbfacademy.apiassessment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.cbfacademy.apiassessment.Exceptions.InvalidInputException;
import com.cbfacademy.apiassessment.Exceptions.ItemNotFoundException;
import com.cbfacademy.apiassessment.model.Watchlist;

import java.net.URL;
import java.util.List;

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
	// @Description("/showList endpoint returns a list of the current items in the watchlist")
	// public void showList_ExpectedResponseWithCurrentDocumentAdded(){
	// 	ResponseEntity<String> response = restTemplate.getForEntity(base.toString() + "", String.class);

	// 	assertEquals(200, response.getStatusCode().value());
	// 	assertEquals("", response.getBody());
	// }


// 	@Test
// @Description("/show-list end point goes to localhost:8080/watchlist")
// public void showListEndpointIslocalhost8080showList() {
//     String url = "http://localhost:" + port + "/watchlist";
//     HttpStatusCode statusCode = restTemplate.ForEntity(url, List.class).getStatusCode();
//     assertEquals(HttpStatus.OK, statusCode);
// }

@Test
@Description("/show-list end point goes to localhost:8080/watchlist")
public void showListEndpointIslocalhost8080showList() {
    String url = "http://localhost:" + port + "/watchlist";

    // Send a GET request to the /watchlist endpoint using postForEntity
    ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, null, String.class);

    // Check the response status code
    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
}


	// @Test
	// @Description("/show-list end point goes to localhost:8080/watchlist")
	// public void showListEndpointIslocalhost8080showList(){
	// 	String url = "http://localhost:" + port + "/watchlist";
	// 	HttpStatusCode statusCode = restTemplate.getForEntity(url, String.class).getStatusCode();
	// 	assertEquals(HttpStatus.OK, statusCode);
	// }

	// @Test
	// @Description("/watchlist endpoint goes to localhost:8080/watchlist")
	// public void watchlistEndpointIslocalhost8080watchlist(){
	// 	String url = "http://localhost:" + port + "/watchlist";
	// 	// Watchlist watchlist = new Watchlist();
	// 	// HttpHeaders headers = new HttpHeaders();
	// 	// headers.setContentType(MediaType.APPLICATION_JSON);
	// 	ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
	// 	assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	// }

	@Test
    @Description("/watchlist endpoint goes to localhost:8080/watchlist")
    public void watchlistEndpointIslocalhost8080watchlist() {
        String url = "http://localhost:" + port + "/watchlist";

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);

        // Check the response status code
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        // You can also check the response content or any other expectations here
    }

	@Test
	@Description("/addEntry endpoint goes to localhost:8080/watchlist/addEntry")
	public void addEntryEndpointIslocalhost8080addEntry(){
		String url = "http://localhost:" + port + "/watchlist/addEntry";
		Watchlist watchlist = new Watchlist();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<Watchlist> responseEntity = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(watchlist, headers), Watchlist.class);
		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
	}

	@Test
	@Description("/deleteEntry/{id} endpoint goes to localhost:8080/watchlist/deleteEntry/{id}")
	public void deleteEntryEndpointIslocalhost8080deleteEntry(){
		String url = "http://localhost:" + port + "/watchlist//deleteEntry/{id}";
		Watchlist watchlist = new Watchlist();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<Watchlist> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, new HttpEntity<>(watchlist, headers), Watchlist.class);
		assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
	}


	@Test
	@Description("/unknown endpoint returns 404")
	public void unknownEndpointReturns404(){
		
		String url = "http://localhost:" +port +"/unknown-endpoint";
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
		HttpStatusCode statusCode = restTemplate.getForEntity(url, String.class).getStatusCode();
		assertEquals(HttpStatus.NOT_FOUND, statusCode);
	}

	//  @Test
    // @DisplayName("/unknown endpoint throws itemNotFoundException")
    // public void unknownEndpointThrowsException(){
	// 	String url = "http://localhost:" +port +"/unknown-endpoint";

    //     assertThrows(ItemNotFoundException.class, () -> {
	// 		restTemplate.getForEntity(url, String.class);
    //     });		
    // }

	
	// do a 404 NOT_FOUND
}
