package com.omniwyse.library.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.omniwyse.library.bo.AddressBO;
import com.omniwyse.library.bo.BookBO;
import com.omniwyse.library.bo.BookInventoryBO;
import com.omniwyse.library.bo.BookOrderBO;
import com.omniwyse.library.bo.BookOrderLineItemBO;
import com.omniwyse.library.bo.BookStatusBO;
import com.omniwyse.library.bo.BookTransactionBO;
import com.omniwyse.library.bo.CategoryBO;
import com.omniwyse.library.bo.DeliveryTypeBO;
import com.omniwyse.library.bo.LibraryAgentBO;
import com.omniwyse.library.bo.LibraryBO;
import com.omniwyse.library.bo.LibraryLocationBO;
import com.omniwyse.library.bo.ProfileTypeBO;
import com.omniwyse.library.bo.UserBO;
import com.omniwyse.library.exception.LibraryServiceException;
import com.omniwyse.library.repository.AddressRepository;
import com.omniwyse.library.repository.BookFlagRepository;
import com.omniwyse.library.repository.BookInventoryRepository;
import com.omniwyse.library.repository.BookOrderLineItemRepository;
import com.omniwyse.library.repository.BookOrderRepository;
import com.omniwyse.library.repository.BookRepository;
import com.omniwyse.library.repository.BookStatusRepository;
import com.omniwyse.library.repository.BookTransactionRepository;
import com.omniwyse.library.repository.CategoryRepository;
import com.omniwyse.library.repository.DeliveryTypeRepository;
import com.omniwyse.library.repository.LibraryAgentRepository;
import com.omniwyse.library.repository.LibraryRepository;
import com.omniwyse.library.repository.LocationRepository;
import com.omniwyse.library.repository.ProfileTypeRepository;
import com.omniwyse.library.repository.UserRepository;

@Service
public class LibraryService {

	private static final Logger logger = Logger.getLogger(LibraryService.class);

	@Autowired
	LocationRepository locationRepository;

	@Autowired
	LibraryRepository libraryRepository;

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	BookRepository bookRepository;

	@Autowired
	BookInventoryRepository bookInventoryRepository;

	@Autowired
	BookStatusRepository bookStatusRepository;

	@Autowired
	BookOrderRepository bookorderRepository;

	@Autowired
	BookOrderLineItemRepository bookOrderLineItemRepository;

	@Autowired
	BookTransactionRepository bookTransactionRepository;

	@Autowired
	DeliveryTypeRepository deliveryTypeRepository;

	@Autowired
	BookFlagRepository bookFlagRepository;

	@Autowired
	LibraryAgentRepository libraryAgentRepository;
	
	@Autowired
	ProfileTypeRepository profileTypeRepository;

	@Autowired
	CategoryRepository categoryRepository;
	
	/*@Autowired
	RestTemplate restTemplate;*/

	//private static final String UPDATE_PAYMENT_URI = "http://localhost:8761/api/user-service/update-payment/";

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
	public LibraryBO registerLibrary(LibraryBO libraryBO, LibraryLocationBO locationBO, AddressBO addressBO, String username)
			throws LibraryServiceException {
		UserBO userBO = null;
		try {
			userBO = userRepository.findByEmail(username);
			locationBO = locationRepository.save(locationBO);
			addressBO = addressRepository.save(addressBO);
			libraryBO.setSuperAdmin(userBO);
			libraryBO.setAddress(addressBO);

			libraryBO.setLocation(locationBO);
			libraryBO = libraryRepository.save(libraryBO);
		} catch (Exception ex) {
			logger.info("Invalid input details : " + ex);
			throw new LibraryServiceException("Invalid input details ", ex);
		}
		return libraryBO;
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
	public Boolean addAgentToLibrary(String username,String libraryName) throws LibraryServiceException{
		try {
			UserBO agent =  userRepository.findByEmail(username);
			LibraryBO library = libraryRepository.findByName(libraryName);
			libraryAgentRepository.save(new LibraryAgentBO(library, agent));
		}catch(Exception ex){
			logger.info("Exception while adding agent: " + ex);
			throw new LibraryServiceException("Exception while adding agent: ", ex);
		}
		return true;
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
	public Boolean addAdminToLibrary(String username,String libraryName) throws LibraryServiceException{
		try {
			UserBO admin =  userRepository.findByEmail(username);
			LibraryBO library = libraryRepository.findByName(libraryName);
			libraryAgentRepository.save(new LibraryAgentBO(admin,library));
		}catch(Exception ex){
			logger.info("Exception while adding agent: " + ex);
			throw new LibraryServiceException("Exception while adding agent: ", ex);
		}
		return true;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
	public LibraryLocationBO updateLocation(LibraryLocationBO locationBO) throws LibraryServiceException {
		LibraryLocationBO location = null;
		try {
			location = locationRepository.save(locationBO);
		} catch (Exception ex) {
			throw new LibraryServiceException("Exception while updating location", ex);
		}
		return location;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
	public AddressBO updateAddress(AddressBO addressBO) throws LibraryServiceException {
		AddressBO address = null;
		try {
			address = addressRepository.save(addressBO);
		} catch (Exception ex) {
			logger.info("Exception while updating address : " + ex);
			throw new LibraryServiceException("Exception while updating address", ex);
		}
		return address;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
	public boolean addBook(List<BookBO> books, List<Boolean> isBuyable, List<Boolean> isRentable, List<Long> noOfBooks,
			String username,List<String> categories,List<String> profileTypes) throws LibraryServiceException{
		boolean flag = false;
		BookInventoryBO inventoryBO = null;
		CategoryBO category = null;
		ProfileTypeBO profileType =  null;
		UserBO admin = userRepository.findByEmail(username);
		LibraryBO library = getlibraryByAdmin(admin);
		int count = 0;
		for (BookBO book : books) {
			flag = false;
			try {
				if(!checkDuplicateBook(book.getIsbnCode())) {
					book = bookRepository.save(book);
				}else {
					book = bookRepository.findByIsbnCode(book.getIsbnCode());
				}
				inventoryBO = new BookInventoryBO();
				inventoryBO.setAvailable(true);
				inventoryBO.setAvailableDate(new Date());
				inventoryBO.setBookRentalPrice(book.getBookRentalValue());
				inventoryBO.setBook(book);
				inventoryBO.setBookSalePrice(book.getBookPrice());
				inventoryBO.setBuyable(isBuyable.get(count));
				inventoryBO.setOwner(admin);
				inventoryBO.setLibrary(library);
				inventoryBO.setRental(isRentable.get(count));
				inventoryBO.setTotalNoOfBooks(noOfBooks.get(count));
				inventoryBO.setNoOfBooksAvailable(noOfBooks.get(count));
				bookInventoryRepository.save(inventoryBO);
				
				category= new CategoryBO();
				category.setCategory(categories.get(count));
				category.setBook(book);
				categoryRepository.save(category);
				
				profileType = new ProfileTypeBO();
				profileType.setBook(book);
				profileType.setProfileType(profileTypes.get(count));
				profileTypeRepository.save(profileType);
				
				count++;
			} catch (Exception ex) {
				logger.info("Exception while adding books : " + ex);
				throw new LibraryServiceException("Exception while adding books", ex);
			}
			flag = true;
		}
		return flag;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
	public boolean createOrder(List<Long> bookIds, BookOrderBO order, Long destinationId, String username) throws LibraryServiceException {
		UserBO user = null;
		BookStatusBO status = null;
		BookOrderLineItemBO lineItem = null;
		BookTransactionBO bookTransaction = null;
		BookBO book = null;
		user = userRepository.findByEmail(username);
		status = bookStatusRepository.findOne(5l);

		order.setOrderDate(new Date());
		order.setUser(user);
		order.setStatus(status);
		order = bookorderRepository.save(order);
		DeliveryTypeBO deliveryTypeBO = deliveryTypeRepository.findByType(order.getDeliveryType());
		try {
			for (Long bookId : bookIds) {
				book = bookRepository.findOne(bookId);
				if(book != null) {
					lineItem = new BookOrderLineItemBO();
					bookTransaction = new BookTransactionBO();
					BookInventoryBO inventory = bookInventoryRepository.findBybook(book).get(0);
					if (inventory == null)
						continue;
					LibraryBO library = inventory.getLibrary();
					UserBO owner = inventory.getOwner();
					AddressBO source = library.getAddress();
					lineItem.setOrder(order);
					lineItem.setBook(book);
					lineItem.setOrderDate(new Date());
					lineItem.setReleaseDate(getReleaseDate());
					lineItem.setDesireDate(getReleaseDate());
					lineItem.setBookPrice(book.getBookPrice());
					lineItem.setBookStatus(status);
					lineItem.setCustomer(user);
					lineItem.setSource(source);
					lineItem.setDestination(addressRepository.findOne(destinationId));
					lineItem.setOwner(owner);
					lineItem.setLibrary(library);
					lineItem = bookOrderLineItemRepository.save(lineItem);
		
					bookTransaction.setTransactionDate(new Date());
					bookTransaction.setOrederLineItem(lineItem);
					bookTransaction.setAgent(getAgentforOrder(library));
					bookTransaction.setOwner(owner);
					bookTransaction.setLocation(library.getLocation());
					bookTransaction.setDeliveryType(deliveryTypeBO);
					bookTransaction.setBookFlag(bookFlagRepository.findOne(3l));
					bookTransaction.setBookStatus(status);
					bookTransaction.setLibrary(library);
					bookTransactionRepository.save(bookTransaction);
				}
			}
		}catch(Exception ex) {
			return false;
		}
		return true;
	}

	public Boolean checkDuplicateBook(String isbnCode) throws LibraryServiceException {
		boolean flag = true;
		try {
			BookBO book = bookRepository.findByIsbnCode(isbnCode);
			if(book ==  null) {
				flag = false;
			}
		}catch(Exception ex) {
			logger.info("Excception while checking duplicate for books isbnCode "+isbnCode);
			throw new LibraryServiceException();
		}
		return flag;
	}
	
	public List<LibraryBO> getListOfLibrary() throws LibraryServiceException{
		List<LibraryBO> libraryBOs = null;
		try{
			libraryBOs = libraryRepository.findAll();
		}catch(Exception ex) {
			logger.info("exception while getting list of library..." + ex);
			throw new LibraryServiceException(ex);
		}
		return libraryBOs;
	}
	
	public List<BookBO> searchByBookNameorAuthor(String criteria,Long libraryId)throws LibraryServiceException{
		List<BookBO> books = null;
		try {
			books = bookRepository.findBookByAuthorOrBookName(criteria,libraryId);
		}catch(Exception ex) {
			logger.info("");
			throw new LibraryServiceException();
		}
		return books;
	}
	private Date getReleaseDate() {
		Date dt = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.add(Calendar.DATE, 5);
		dt = c.getTime();
		return dt;
	}
	private UserBO getAgentforOrder(LibraryBO library) {
		List<LibraryAgentBO> libraryAgent = libraryAgentRepository.findByLibrary(library);
		return libraryAgent.get(0).getAgent();
	}
	private LibraryBO getlibraryByAdmin(UserBO admin) {
		List<LibraryAgentBO> agentBOs = libraryAgentRepository.findByAdmin(admin);
		return agentBOs.get(0).getLibrary();
	}
}
