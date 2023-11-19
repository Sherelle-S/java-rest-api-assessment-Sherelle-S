package com.cbfacademy.apiassessment;

import org.apache.logging.log4j.util.PropertySource.Comparator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
// import org.springframework.asm.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cbfacademy.apiassessment.crudActions.appendingActions.createEntry.AddWatchlistItem;
import com.cbfacademy.apiassessment.crudActions.appendingActions.createEntry.CreateFirstItem;
import com.cbfacademy.apiassessment.crudActions.appendingActions.createEntry.RunCreatingActions;
import com.cbfacademy.apiassessment.crudActions.appendingActions.createEntry.WriteToJsonFile;
import com.cbfacademy.apiassessment.crudActions.appendingActions.deleteEntries.DeleteEntry;
import com.cbfacademy.apiassessment.crudActions.appendingActions.deleteEntries.RunDeleteEntry;
import com.cbfacademy.apiassessment.crudActions.appendingActions.read.ReadExistingWatchlist;
import com.cbfacademy.apiassessment.crudActions.appendingActions.read.RunGetWatchlist;
import com.cbfacademy.apiassessment.crudActions.appendingActions.read.searchAndSort.BinarySearch;
import com.cbfacademy.apiassessment.crudActions.appendingActions.read.searchAndSort.QuicksortWatchlist;
import com.cbfacademy.apiassessment.crudActions.appendingActions.read.searchAndSort.SortWatchlistByName;
import com.cbfacademy.apiassessment.crudActions.appendingActions.updateOneEntry.RunUpdatingMethods;
import com.cbfacademy.apiassessment.exceptions.InvalidInputException;
import com.cbfacademy.apiassessment.exceptions.ItemNotFoundException;
import com.cbfacademy.apiassessment.exceptions.WatchlistProcessingException;
import com.cbfacademy.apiassessment.model.Watchlist;
import com.cbfacademy.apiassessment.service.WatchlistServiceImpl;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AppTests {

	@LocalServerPort
	private int port;

	private URL base;

	private String mockJsonFile = "mockJsonFile.json";

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	@Mock
	private WriteToJsonFile writeToJson;
	@Autowired
	@Mock
	private ObjectMapper mapper;
	private BufferedWriter writer;
	private FileWriter fileWriter;

	@Mock 
	private BinarySearch binarySearch;
	@Mock
	private ReadExistingWatchlist readList;
	@Mock
	private RunGetWatchlist runGetWatchlist;
	@Mock
	private SortWatchlistByName sortWatchlistByName;
	@Mock
	private RunDeleteEntry runDeleteItem;
	@Mock
	private BinarySearch binarySearch;
	@Mock 
	private CreateFirstItem createFirstItem;
	@Mock
	private RunUpdatingMethods runUpdatingMethods;
	@Mock
	private RunCreatingActions runCreatingActions;
	@Mock
	private WatchlistServiceImpl watchlistServiceImpl;
	@Mock
	private AddWatchlistItem addWatchlistItem;
	@InjectMocks
	private WatchlistServiceImpl service;

	@TempDir
	Path tempDir;

	@BeforeEach
	public void setUp() throws Exception {
		try {
			this.base = new URL("http://localhost:" + port + "/greeting");
			MockitoAnnotations.openMocks(this);
			File jsonFile = new File(mockJsonFile);
			if (jsonFile.exists()) {
            jsonFile.delete();
			}
		} catch (Exception e) {
			throw new Exception();
		}
	}

	 @AfterEach
    public void tearDown() {
        File file = new File(mockJsonFile);
        if (file.exists()) {
            file.delete();
        }
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
	@Description("/Create first entry writes to json")
	public void CreateFirstEntryWritesToJson(){
		List<Watchlist> emptyMockWatchlist = new ArrayList<>();
		try{
			Files.createFile(Paths.get(mockJsonFile));
			createFirstItem.CreateFirstEntry(emptyMockWatchlist, mockJsonFile);
			assertTrue(Files.exists(Paths.get(mockJsonFile)), "File should have been created");
		} catch (IOException e) {
			e.getMessage();
		}
	}


// 	@Test
// 	@Description("/incoming api data is parsed into watchlist objects.")
// 	public void externalInputToWatchlistIsWrittenToJsonObject() throws JsonMappingException, JsonProcessingException{
// 		@JsonFormat(pattern = "M/d/yyyy")
// private LocalDate datePurchased;
		
// 		String jsonInputSample = "[{\"stockName\":\"Microsoft\",\"symbol\":\"MSFT\",\"currency\":\"USD\",\"datePurchased\":\"11/15/2023\",\"wants\":235,\"has\":225,\"profit\":30.0,\"open\":200.0,\"close\":205.0,\"intradayHigh\":210.0}]";

// 		ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
//         List<Watchlist> sampleList = mapper.readValue(jsonInputSample, new TypeReference<>() {});
// 		String sampleJsonString = "{\"stockName\": \"Microsoft\",\"symbol\": \"MSFT\",\"currency\": \"USD\",\"datePurchased\": \"11/15/2023\",\"wants\": 235,\"has\": 225, \"profit\": 30.0,\"open\": 200.0,\"close\": 205.0,\"intradayHigh\": 210.0}";
// 		assertEquals(sampleJsonString, sampleList);

// 	}


	// @Test
	// @Description("/if no json file exists in specified location, one is created")
	// public void createsJsonFileInTestJsonFileLocationIfNotPresent() throws IOException{
	// 	String testFile = tempDir.resolve(mockJsonFile).toString();
		
	// 		WatchlistServiceImpl watchlistServiceImpl = new WatchlistServiceImpl(binarySearch, createFirstItem, runDeleteItem, mapper, runCreatingActions, runUpdatingMethods, sortWatchlistByName, readExistingWatchlist);
	// 		watchlistServiceImpl.create(new ArrayList<>());
	// 		assertTrue(Files.exists(Path.of(testFile)), "File should have been created");
	// 		// if(!testFile.exists()){
	// 		// 	Assertions.Fail();
	// 		// }
	// }

	// @Test
	// @Description("/if file exists but data is empty data is written to file")
	// public void newWatchlistDataIsWrittenToJsonFileIfOneExistsAndItIsEmpty(){
	// 	List<Watchlist> watchlist = new ArrayList<>();

	// 	when(null)
	// }

	@Test
	@Description("new watchlist entries are converted to a json object in addWatchlistItem")
	public void newWatchlistEntriesAreConvertedToAJsonWatchlistObject(){
		List<Watchlist> emptyMockWatchlist = new ArrayList<>();
		List<Watchlist> sampleMockWatchlist = new ArrayList<>();

		Watchlist sampleEntry = new Watchlist();
		sampleEntry.setUuid(null);
		sampleEntry.setStockName("Apple");
		sampleEntry.setSymbol("AAPL");
		sampleEntry.setCurrency("USD");
		sampleEntry.setDatePurchased(LocalDate.now());
		sampleEntry.setWantsVolStock(2340);
		sampleEntry.setOwnsVolStock(2110);
		sampleEntry.setPurchasePrice(76.7);
		sampleEntry.setCurrentPrice(69.8);
		sampleEntry.setProfit(0);
		sampleEntry.setPointsChange(0);
		sampleEntry.setOpen(354.2);
		sampleEntry.setClose(234.0);
		sampleEntry.setIntradayHigh(356.2);

		sampleMockWatchlist.add(sampleEntry);

	addWatchlistItem.appendToWatchlist(emptyMockWatchlist, sampleMockWatchlist);

	verify(addWatchlistItem).appendToWatchlist(emptyMockWatchlist, sampleMockWatchlist);
	}

	@Test
	@Description("/multiple watchlist entries are converted to json obtect")
	public void multipleWatchlistEntiresAreSerializedToJsonObject(){
		List<Watchlist> sampleMockWatchlist1 = new ArrayList<>();
		List<Watchlist> sampleMockWatchlist2 = new ArrayList<>();
		AddWatchlistItem addWatchlistItem = mock(AddWatchlistItem.class);

		addWatchlistItem.appendToWatchlist(sampleMockWatchlist1, sampleMockWatchlist2);
		verify(addWatchlistItem).appendToWatchlist(sampleMockWatchlist1, sampleMockWatchlist2);
	
	}

	// @Test 
	// @Description("/Verify that data is serialized to JSON")
	// public void testDataIsSerializedToJson(){
	// 	List<Watchlist> testList = new ArrayList<>();
	// 	try {
	// 		Watchlist sampleEntry = new Watchlist();
	// 		sampleEntry.setUuid(null);
	// 		sampleEntry.setStockName("Apple");
	// 		sampleEntry.setSymbol("AAPL");
	// 		sampleEntry.setCurrency("USD");
	// 		sampleEntry.setDatePurchased(LocalDate.now());
	// 		sampleEntry.setWantsVolStock(2340);
	// 		sampleEntry.setOwnsVolStock(2110);
	// 		sampleEntry.setPurchasePrice(76.7);
	// 		sampleEntry.setCurrentPrice(69.8);
	// 		sampleEntry.setProfit(0);
	// 		sampleEntry.setPointsChange(0);
	// 		sampleEntry.setOpen(354.2);
	// 		sampleEntry.setClose(234.0);
	// 		sampleEntry.setIntradayHigh(356.2);

	// 		testList.add(sampleEntry);
	// 		String jsonString = mapper.writeValueAsString(testList);
	// 		try {
	// 			JsonNode jsonNode = mapper.readTree(jsonString);
	// 			assertTrue(jsonNode.isObject() || jsonNode.isArray(), "Generated content should be valid JSON");
	// 		} catch (JsonProcessingException e) {
	// 			fail(null);
	// // 		}
	
	// 		// Simulate writing the JSON content to a file
	// 		File jsonFile = new File(mockJsonFile);
	// 		Files.writeString(jsonFile.toPath(), jsonString);
	
	// 		// Verify the file content
	// 		String fileContent = Files.readString(jsonFile.toPath());
	// 		try {
	// 			JsonNode fileJsonNode = mapper.readTree(fileContent);
	// 			assertTrue(fileJsonNode.isObject() || fileJsonNode.isArray(), "File content should be valid JSON");
	// 		} catch (JsonProcessingException e) {
	// 			fail(null);
	// 		}
	// 	} catch (IOException e) {
	// 		fail(null);
	// 	}
	// }

	@Test
	@Description("/new watchlist object writes to json")
	public void writeNewWatchlistObjectToJsonFile() throws IOException{
		String testJsonFile = "testMock.json";
		List<Watchlist> sampleList = new ArrayList<>();
		try {
			Watchlist sampleEntry = new Watchlist();
			sampleEntry.setUuid(null);
			sampleEntry.setStockName("Apple");
			sampleEntry.setSymbol("AAPL");
			sampleEntry.setCurrency("USD");
			sampleEntry.setDatePurchased(LocalDate.now());
			sampleEntry.setWantsVolStock(2340);
			sampleEntry.setOwnsVolStock(2110);
			sampleEntry.setPurchasePrice(76.7);
			sampleEntry.setCurrentPrice(69.8);
			sampleEntry.setProfit(0);
			sampleEntry.setPointsChange(0);
			sampleEntry.setOpen(354.2);
			sampleEntry.setClose(234.0);
			sampleEntry.setIntradayHigh(356.2);

		doReturn(new ResponseEntity<>(HttpStatus.OK)).when(writeToJson).writeToJson(anyString(), any(ObjectMapper.class), anyList());

		ResponseEntity<?> data = writeToJson.writeToJson(testJsonFile, new ObjectMapper(), sampleList);
		verify(writeToJson).writeToJson(eq(testJsonFile), any(ObjectMapper.class), eq(sampleList));
	
		assertEquals(HttpStatus.OK, data.getStatusCode());
		} catch (IOException e){
			e.getMessage();
		}
	}

	@Test
	@Description("/itemSelectedByUuidIsDeleted")
	public void itemSelectedByUuidIsDeleted(){
		UUID testUuid = UUID.randomUUID();
		ReadExistingWatchlist readList = mock(ReadExistingWatchlist.class);
		WriteToJsonFile writeToJsonFile = mock(WriteToJsonFile.class);
		DeleteEntry deleteEntry = new DeleteEntry(readList, writeToJsonFile);

		try {
		List<Watchlist> existingWatchlist = new ArrayList<>();
		Watchlist watchlistItem = new Watchlist();
		watchlistItem.setUuid(testUuid);
		existingWatchlist.add(watchlistItem);
		deleteEntry.deleteEntry(existingWatchlist, mockJsonFile, mapper, testUuid);
		assertEquals(0, existingWatchlist.size(), "Item should now be deleted");
		verify(writeToJsonFile, times(1)).writeToJson(eq("mockJsonFile.json"), any(ObjectMapper.class), eq(existingWatchlist));
		} catch (StreamWriteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	@Description("/exceptions class invalidInputException returns HttpStatus.INTERNAL_SERVER_ERROR")
	public void invalidInputExceptionReturnsBadRequest(){
		ResponseStatus annotation = InvalidInputException.class.getAnnotation(ResponseStatus.class);
        HttpStatus expectedStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        assertEquals(expectedStatus, annotation.value(), "InvalidInputException should have @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)");
	}
	

	@Test
	@Description("exceptions class ItemNotFoundException returns HttpStatus.INTERNAL_SERVER_ERROR")
	public void itemNotFoundExceptionReturns(){
		ResponseStatus annotation = ItemNotFoundException.class.getAnnotation(ResponseStatus.class);
		HttpStatus expectedStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    assertEquals(expectedStatus, annotation.value(), "ItemNotFoundException should have @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)");
	}

	@Test
	@Description("exceptions class WatchlistProcessingException returns HttpStatus.INTERNAL_SERVER_ERROR")
	public void WatchlistProcessingExceptionReturns(){
	ResponseStatus annotation = WatchlistProcessingException.class.getAnnotation(ResponseStatus.class);
    HttpStatus expectedStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    assertEquals(expectedStatus, annotation.value(), "WatchlistProcessingException should have @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)");
	}

	@Test
	@Description("exceptions class WatchlistProcessingException returns HttpStatus.INTERNAL_SERVER_ERROR")
	public void WatchlistProcessingException(){
	ResponseStatus annotation = WatchlistProcessingException.class.getAnnotation(ResponseStatus.class);
       HttpStatus expectedStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    assertEquals(expectedStatus, annotation.value(), "WatchlistProcessingException should have @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)");
	}

	@Test
	@Description("/quicksort class correctly sorts watchlist objects by name")
	public void quicksortSortsWatchlistObjectsByName(){
		QuicksortWatchlist quicksortWatchlist = new QuicksortWatchlist();
		
        List<Watchlist> unsortedWatchlist = new ArrayList<>();
        unsortedWatchlist.add(new Watchlist(UUID.randomUUID(), "TestStock C", "VOD.L", "USD", LocalDate.now(), 100, 200, 75.0, 80.0, 5.0, 0.5, 70.0, 85.0, 90.0));
        unsortedWatchlist.add(new Watchlist(UUID.randomUUID(), "TestStock A", "XAG", "USD", LocalDate.now(), 150, 250, 80.0, 85.0, 5.0, 0.5, 75.0, 90.0, 95.0));
        unsortedWatchlist.add(new Watchlist(UUID.randomUUID(), "TestStock B", "CBF", "USD", LocalDate.now(), 120, 220, 85.0, 90.0, 5.0, 0.5, 80.0, 95.0, 100.0));


        List<Watchlist> sortedWatchlist = quicksortWatchlist.sortAlgo(unsortedWatchlist);

        assertEquals("TestStock A", sortedWatchlist.get(0).getStockName());
        assertEquals("TestStock B", sortedWatchlist.get(1).getStockName());
        assertEquals("TestStock C", sortedWatchlist.get(2).getStockName());
	}

	@Test
	@Description("/String name is returned from @PathVariable")
	public void stringNameIsRecevedFromPathVariable(){
		Watchlist watchlist = binarySearch.binarySearchWatchlist(new ArrayList<>(), "TestName");
		assertNotNull(watchlist);
	}

	@Test
	@Description("/sorted array is received from quicksort")
	public void itemReceivedFromQuicksortIsSorted(){
		List<Watchlist> existingWatchlist = new ArrayList<>();
		existingWatchlist.add(new Watchlist(UUID.randomUUID(), "TestStock A", "XAG", "USD", LocalDate.now(), 150, 250, 80.0, 85.0, 5.0, 0.5, 75.0, 90.0, 95.0));
		existingWatchlist.add(new Watchlist(UUID.randomUUID(), "TestStock B", "CBF", "USD", LocalDate.now(), 120, 220, 85.0, 90.0, 5.0, 0.5, 80.0, 95.0, 100.0))
		existingWatchlist.add(new Watchlist(UUID.randomUUID(), "TestStock B", "CBF", "USD", LocalDate.now(), 120, 220, 85.0, 90.0, 5.0, 0.5, 80.0, 95.0, 100.0))
		binarySearch.binarySearch(new QuicksortWatchlist());
		Watchlist watchlist = binarySearch.binarySearchWatchlist(existingWatchlist, "TestName");
	}	

}

// 	@Test
// 	@Description("/showList endpoint returns a list of the current items in the watchlist")
// 	public void showList_ExpectedResponseWithCurrentDocumentAdded(){
// 		ResponseEntity<String> response = restTemplate.getForEntity(base.toString() + "", String.class);

// 		assertEquals(200, response.getStatusCode().value());
// 		assertEquals("", response.getBody());
// 	}


// 	@Test
// 	@Description("/route end point goes to localhost:8080/watchlist")
// 	public void showListEndpointIslocalhost8080watchlist() {
// 		String url = "http://localhost:" + port + "/watchlist/";
// 		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
// 		// HttpStatusCode statusCode = restTemplate.ForEntity(url, List.class).getStatusCode();
// 		assertEquals(HttpStatus.OK, response.getStatusCode());
// 	}

// @Test
// @Description("/{id} end point goes to localhost:8080/{id}")
// public void showListEndpointIslocalhost8080id() {
// 	CreateWatchlist sampleWatchlist5 = new CreateWatchlist(null, "Silver", "XAG", false, "TestStatus", "EUR", LocalDate.now(), 50, 20.0, 1.0, 370.0, 34.0, 20.0);
//    UUID Id5 = sampleWatchlist5.getUuid();
// 	// String SampleId = sampleWatchlist5;
// 	String url = "http://localhost:" + port + "/{id}";

//     assertEquals(Id5, Id5 );
// }

// // @Test
// // @Description("returns boolean true when file is converted to json")
// // public void returnsBooleanTrueWhenFileConvertsToJson(){
// // 	assertTrue(true, true);
// // }

// // @Test
// // @Description("returns boolean false when json conversion fails")
// // public void returnsBooleanFalseWhenFileConversionFails(){
// // 	assertFalse(false, false);
// // }

// 	@Test
// 	@Description("/addEntry endpoint goes to localhost:8080/watchlist/addEntry")
// 	public void addEntryEndpointIslocalhost8080addEntry(){
// 		String url = "http://localhost:" + port + "/watchlist/addEntry";
// 		CreateWatchlist addListItems = new CreateWatchlist(null, "Silver", "XAG", false, "TestStatus", "EUR", LocalDate.now(), 50, 20.0, 1.0, 370.0, 34.0, 20.0);
// 		HttpHeaders headers = new HttpHeaders();
// 		headers.setContentType(MediaType.APPLICATION_JSON);
// 		ResponseEntity<addListItems> responseEntity = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(addListItems, headers), addListItems.class);
// 		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
// 	}

// 	// @Test
// 	// @Description("/show-list end point goes to localhost:8080/addListItems")
// 	// public void showListEndpointIslocalhost8080showList(){
// 	// 	String url = "http://localhost:" + port + "/watchlist";
// 	// 	HttpStatusCode statusCode = restTemplate.getForEntity(url, String.class).getStatusCode();
// 	// 	assertEquals(HttpStatus.OK, statusCode);
// 	// }

// 	// @Test
// 	// @Description("/watchlist endpoint goes to localhost:8080/watchlist")
// 	// public void watchlistEndpointIslocalhost8080watchlist(){
// 	// 	String url = "http://localhost:" + port + "/watchlist";
// 	// 	// Watchlist watchlist = new Watchlist();
// 	// 	// HttpHeaders headers = new HttpHeaders();
// 	// 	// headers.setContentType(MediaType.APPLICATION_JSON);
// 	// 	ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
// 	// 	assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
// 	// }

// 	// @Test
//     // @Description("/watchlist endpoint goes to localhost:8080/watchlist")
//     // public void watchlistEndpointIslocalhost8080watchlist() {
//     //     String url = "http://localhost:" + port + "/watchlist";

//     //     ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);

//     //     // Check the response status code
//     //     assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//     //     // You can also check the response content or any other expectations here
//     // }



// 	// @Test
// 	// @Description("/deleteEntry/{id} endpoint goes to localhost:8080/watchlist/deleteEntry/{id}")
// 	// public void deleteEntryEndpointIslocalhost8080deleteEntry(){
// 	// 	String url = "http://localhost:" + port + "/watchlist//deleteEntry/{id}";
// 	// 	Watchlist watchlist = new Watchlist();
// 	// 	HttpHeaders headers = new HttpHeaders();
// 	// 	headers.setContentType(MediaType.APPLICATION_JSON);
// 	// 	ResponseEntity<Watchlist> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, new HttpEntity<>(watchlist, headers), Watchlist.class);
// 	// 	assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
// 	// }


// 	// @Test
// 	// @Description("/unknown endpoint returns 404")
// 	// public void unknownEndpointReturns404(){
		
// 	// 	String url = "http://localhost:" +port +"/unknown-endpoint";
// 	// 	ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
// 	// 	HttpStatusCode statusCode = restTemplate.getForEntity(url, String.class).getStatusCode();
// 	// 	assertEquals(HttpStatus.NOT_FOUND, statusCode);
// 	// }

// 	//  @Test
//     // @DisplayName("/unknown endpoint throws itemNotFoundException")
//     // public void unknownEndpointThrowsException(){
// 	// 	String url = "http://localhost:" +port +"/unknown-endpoint";

//     //     assertThrows(ItemNotFoundException.class, () -> {
// 	// 		restTemplate.getForEntity(url, String.class);
//     //     });
//     // }

// 	// @Test
// 	// @Description("/UserDetails returns user input from user input")
// }
