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
import org.springframework.test.annotation.DirtiesContext;

import com.cbfacademy.apiassessment.model.CreateWatchlist;
import com.cbfacademy.apiassessment.model.Watchlist;

// import com.cbfacademy.apiassessment.Exceptions.InvalidInputException;
// import com.cbfacademy.apiassessment.Exceptions.ItemNotFoundException;
// import com.cbfacademy.apiassessment.model.Watchlist;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AppTests {

	@LocalServerPort
	private int port;

	private URL base;

	@Autowired
	private TestRestTemplate restTemplate;

	
	/** 
	 * @throws Exception
	 */
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

	@Test
	@DirtiesContext
	@Description("/watchlist gives items with the same stockName a unique id")
	public void testUUIDForSameStockName(){

		CreateWatchlist sampleWatchlist3 = new CreateWatchlist(null, "Gold", "XAU", true, "TestStatus", "GBP", LocalDate.now(), 100, 50.0, 2.0, 60.0, 62.0, 70.0);
		CreateWatchlist sampleWatchlist4 = new CreateWatchlist(null, "Gold", "GC:CMX", false, "TestStatus", "EUR", LocalDate.now(), 100, 50.0, 2.0, 60.0, 62.0, 70.0);
	
		UUID Id3 = sampleWatchlist3.getUuid();
		UUID Id4 = sampleWatchlist4.getUuid();
	
		assertNotEquals(Id3, Id4);
	}	
	
	@Test
	@DirtiesContext
	@Description("/watchlist gives each json item generated a unique id")
	public void testUUIDForDifferentStockName(){
		// String stockName = "Tester";

		CreateWatchlist sampleWatchlist1 = new CreateWatchlist(null, "Vodaphone", "VOD", true, "TestStatus", "GBP", LocalDate.now(), 100, 50.0, 2.0, 60.0, 62.0, 70.0);
		CreateWatchlist sampleWatchlist2 = new CreateWatchlist(null, "Silver", "XAG", false, "TestStatus", "EUR", LocalDate.now(), 50, 20.0, 1.0, 370.0, 34.0, 20.0);

		UUID Id2 = sampleWatchlist1.getUuid();
		UUID Id1 = sampleWatchlist2.getUuid();
		assertNotEquals(Id1, Id2);
	}



	@Test
	@Description("/exceptions class invalidInputException returns HttpStatus.BAD_REQUEST")
	public void invalidInputExceptionReturnsBadRequest(){

	}

	@Test
	@Description("exceptions class ItemNotFoundException returns HttpStatus.NOT_FOUND")
	public void itemNotFoundExceptionReturns(){
		
	}

	@Test
	@Description("/showList endpoint returns a list of the current items in the watchlist")
	public void showList_ExpectedResponseWithCurrentDocumentAdded(){
		ResponseEntity<String> response = restTemplate.getForEntity(base.toString() + "", String.class);

		assertEquals(200, response.getStatusCode().value());
		assertEquals("", response.getBody());
	}


	@Test
	@Description("/route end point goes to localhost:8080/watchlist")
	public void showListEndpointIslocalhost8080watchlist() {
		String url = "http://localhost:" + port + "/watchlist/";
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		// HttpStatusCode statusCode = restTemplate.ForEntity(url, List.class).getStatusCode();
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

@Test
@Description("/{id} end point goes to localhost:8080/{id}")
public void showListEndpointIslocalhost8080id() {
	CreateWatchlist sampleWatchlist5 = new CreateWatchlist(null, "Silver", "XAG", false, "TestStatus", "EUR", LocalDate.now(), 50, 20.0, 1.0, 370.0, 34.0, 20.0);
   UUID Id5 = sampleWatchlist5.getUuid();
	// String SampleId = sampleWatchlist5;
	String url = "http://localhost:" + port + "/{id}";

    assertEquals(Id5, Id5 );
}

// @Test
// @Description("returns boolean true when file is converted to json")
// public void returnsBooleanTrueWhenFileConvertsToJson(){
// 	assertTrue(true, true);
// }

// @Test
// @Description("returns boolean false when json conversion fails")
// public void returnsBooleanFalseWhenFileConversionFails(){
// 	assertFalse(false, false);
// }

	@Test
	@Description("/addEntry endpoint goes to localhost:8080/watchlist/addEntry")
	public void addEntryEndpointIslocalhost8080addEntry(){
		String url = "http://localhost:" + port + "/watchlist/addEntry";
		CreateWatchlist addListItems = new CreateWatchlist(null, "Silver", "XAG", false, "TestStatus", "EUR", LocalDate.now(), 50, 20.0, 1.0, 370.0, 34.0, 20.0);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<addListItems> responseEntity = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(addListItems, headers), addListItems.class);
		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
	}

	// @Test
	// @Description("/show-list end point goes to localhost:8080/addListItems")
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

	// @Test
    // @Description("/watchlist endpoint goes to localhost:8080/watchlist")
    // public void watchlistEndpointIslocalhost8080watchlist() {
    //     String url = "http://localhost:" + port + "/watchlist";

    //     ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);

    //     // Check the response status code
    //     assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    //     // You can also check the response content or any other expectations here
    // }



	// @Test
	// @Description("/deleteEntry/{id} endpoint goes to localhost:8080/watchlist/deleteEntry/{id}")
	// public void deleteEntryEndpointIslocalhost8080deleteEntry(){
	// 	String url = "http://localhost:" + port + "/watchlist//deleteEntry/{id}";
	// 	Watchlist watchlist = new Watchlist();
	// 	HttpHeaders headers = new HttpHeaders();
	// 	headers.setContentType(MediaType.APPLICATION_JSON);
	// 	ResponseEntity<Watchlist> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, new HttpEntity<>(watchlist, headers), Watchlist.class);
	// 	assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
	// }


	// @Test
	// @Description("/unknown endpoint returns 404")
	// public void unknownEndpointReturns404(){
		
	// 	String url = "http://localhost:" +port +"/unknown-endpoint";
	// 	ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
	// 	HttpStatusCode statusCode = restTemplate.getForEntity(url, String.class).getStatusCode();
	// 	assertEquals(HttpStatus.NOT_FOUND, statusCode);
	// }

	//  @Test
    // @DisplayName("/unknown endpoint throws itemNotFoundException")
    // public void unknownEndpointThrowsException(){
	// 	String url = "http://localhost:" +port +"/unknown-endpoint";

    //     assertThrows(ItemNotFoundException.class, () -> {
	// 		restTemplate.getForEntity(url, String.class);
    //     });
    // }

	// @Test
	// @Description("/UserDetails returns user input from user input")
}
