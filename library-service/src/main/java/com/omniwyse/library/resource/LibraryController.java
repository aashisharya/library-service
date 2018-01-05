package com.omniwyse.library.resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.HeaderParam;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.omniwyse.library.bo.AddressBO;
import com.omniwyse.library.bo.BookBO;
import com.omniwyse.library.bo.BookOrderBO;
import com.omniwyse.library.bo.LibraryBO;
import com.omniwyse.library.bo.LibraryLocationBO;
import com.omniwyse.library.exception.LibraryServiceException;
import com.omniwyse.library.service.LibraryService;

/**
 * @author aashish.kumar
 */
@RestController
public class LibraryController {

	private static final Logger logger = Logger.getLogger(LibraryService.class);

	@Autowired
	LibraryService libraryService;
	/**
	 * @param libraryDetails
	 * @param username
	 * @return
	 * after creating user (role as superadmin), can eligible for register for the library
	 */
	@RequestMapping(value = "/register-library", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> registerLibrary(@RequestBody String libraryDetails, @RequestHeader String username) {
		LibraryBO libraryBO = null;
		LibraryLocationBO locationBO = null;
		AddressBO addressBO = null;
		ObjectMapper mapper = null;
		JsonNode node = null;
		try {
			mapper = new ObjectMapper();
			node = mapper.readTree(libraryDetails);
		} catch (IOException e) {
			logger.info("Exception while parsing json object : " + e);
		}
		libraryBO = mapper.convertValue(node.get("libraryBO"), LibraryBO.class);
		locationBO = mapper.convertValue(node.get("locationBO"), LibraryLocationBO.class);
		addressBO = mapper.convertValue(node.get("addressBO"), AddressBO.class);
		try {
			libraryBO = libraryService.registerLibrary(libraryBO, locationBO, addressBO, username);
			
		} catch (LibraryServiceException lex) {
			logger.info(lex);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		libraryBO.setSuperAdmin(null);
		return new ResponseEntity<>(libraryBO, HttpStatus.OK);
	}

	/**
	 * @param username
	 * @param libraryName
	 * @return
	 * superadmin can add agent to their library
	 */
	@PutMapping(value = "/add-agent/{libraryName}", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addAgentToLibrary(@RequestHeader String username, @PathVariable String libraryName) {
		boolean result = false;
		try {
			result = libraryService.addAgentToLibrary(username, libraryName);
		} catch (LibraryServiceException lex) {
			logger.info(lex);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	/**
	 * @param username
	 * @param libraryName
	 * @return
	 * superadmin can add multiple owner for a particular library
	 */
	@PutMapping(value = "/add-admin/{libraryName}", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addAdminToLibrary(@RequestHeader String username, @PathVariable String libraryName) {
		boolean result = false;
		try {
			result = libraryService.addAdminToLibrary(username, libraryName);
		} catch (LibraryServiceException lex) {
			logger.info(lex);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	/**
	 * @param location
	 * @return
	 * update the location
	 */
	@PutMapping(value = "/update-location", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateLocation(@RequestBody LibraryLocationBO location) {
		LibraryLocationBO locationBO = null;
		try {
			locationBO = libraryService.updateLocation(location);
		} catch (LibraryServiceException ex) {
			logger.info("Exception while updating location", ex);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(locationBO, HttpStatus.OK);
	}
	/**
	 * @param address
	 * @return
	 * update the address
	 */
	@PutMapping(value = "/update-address", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateAddress(@RequestBody AddressBO address) {
		AddressBO addressBO = null;
		try {
			addressBO = libraryService.updateAddress(address);
		} catch (LibraryServiceException ex) {
			logger.info("Exception while updating Address", ex);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(addressBO, HttpStatus.OK);
	}
	/**
	 * @param bookDetails
	 * @param username
	 * @return
	 * owner can add the book in library
	 */
	@PostMapping(value = "/add-book", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addBook(@RequestBody String bookDetails, @RequestHeader("username") String username){
		boolean flag = false;
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = null;
		try {
			node = mapper.readTree(bookDetails);
			List<BookBO> books = mapper.convertValue(node.get("bookBOs"), new TypeReference<List<BookBO>>() {});
			List<Boolean> isBuyable = mapper.convertValue(node.get("isBuyable"), new TypeReference<List<Boolean>>() {});
			List<Boolean> isRentable = mapper.convertValue(node.get("isRentable"), new TypeReference<List<Boolean>>() {});
			List<Long> noOfBooks = mapper.convertValue(node.get("noOfBooks"), new TypeReference<List<Long>>() {});
			List<String> category = mapper.convertValue(node.get("categories"), new TypeReference<List<String>>() {});
			List<String> profileType = mapper.convertValue(node.get("profileTypes"), new TypeReference<List<String>>() {});
			flag = libraryService.addBook(books, isBuyable, isRentable, noOfBooks, username,category,profileType);
			
		} catch (LibraryServiceException ex) {
			logger.info("Exception while adding the books" + ex);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		catch (IOException e) {
			logger.info("Exception while parsing json object : " + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(flag, HttpStatus.OK);
	}
	/**
	 * @param orderDetails
	 * @param username
	 * @return
	 * user can create the order to buy or rent a book
	 */
	@PostMapping(value = "/create-order", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createOrder(@RequestBody String orderDetails, @RequestHeader("username") String username) {
		List<Long> bookIds = null;
		BookOrderBO order = null;
		boolean flag = false;
		Long destinationId = null;
		ObjectMapper mapper = null;
		JsonNode node = null;
		try {
			mapper = new ObjectMapper();
			node = mapper.readTree(orderDetails);
			bookIds = mapper.convertValue(node.get("bookIds"), new TypeReference<List<Long>>() {});
			order = mapper.convertValue(node.get("orderBO"), BookOrderBO.class);
			destinationId = mapper.convertValue(node.get("destinationId"), Long.class);
			flag = libraryService.createOrder(bookIds, order, destinationId, username);
		} catch (LibraryServiceException ex) {
			logger.info("Error while creating order for : " + ex);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		catch (IOException e) {
			logger.info("Exception while parsing json object : " + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(flag, HttpStatus.OK);
	}
	/**
	 * @param isbnCode
	 * @return
	 * prevent to duplicate entry for book details
	 */
	@GetMapping(value = "/check-duplicate/{isbnCode}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> checkDuplicateBook(@PathVariable String isbnCode) {
		Boolean result = null;
		try {
			result = libraryService.checkDuplicateBook(isbnCode);
		} catch (LibraryServiceException ex) {
			logger.info("Error while creating order for : " + ex);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	/**
	 * @return
	 * list of library
	 */
	@GetMapping(value="/library-list", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getListOfLibrary() {
		List<LibraryBO> libraryBOs = null;
		List<LibraryBO> libraryDtos =  new ArrayList<LibraryBO>();
		try {
			libraryBOs = libraryService.getListOfLibrary();
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			for(LibraryBO lib  : libraryBOs) {
				lib.getSuperAdmin().setRoles(null);
				libraryDtos.add(lib);
			}
			
		} catch (LibraryServiceException ex) {
			logger.info("Exception while creating order for : " + ex);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(libraryDtos, HttpStatus.OK);
	}
	/**
	 * @param criteria
	 * @return
	 * search book by author name or book name and return list of books
	 */
	@GetMapping(value = "/search/{criteria}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> searchByBookNameorAuthor(@RequestHeader("libraryId") Long libraryId,@PathVariable String criteria) {
		List<BookBO> books = null;
		try {
			books = libraryService.searchByBookNameorAuthor(criteria,libraryId);
		} catch (LibraryServiceException ex) {
			logger.info("Exception while searching books : " + ex);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(books, HttpStatus.OK);
	}
	
	

	@GetMapping("/admin/test-admin")
	public String testAdmin() {
		return "Admin tested successfully...";
	}
	
}
