package se.nordh.bookstore.services;

import java.util.Map;
import java.util.Set;

import se.nordh.bookstore.domain.BookAndStock;
import se.nordh.bookstore.domain.Receipt;

public interface StoreService {
	
	BookAndStock getBookAndStock(long storageID);
	
	Set<BookAndStock> getAllBooks();
	
	Set<BookAndStock> getBookAndStockByStorageID(long storageID);
	
	Map<Long, BookAndStock> findTitleOrAuthor(String searchString);
	
	long createNewBook(BookAndStock bookAndStock);
	
	void updateStock(long storageID, int amount);
	
	void deleteBookFromStock(long storageID);
	
	void clearInventory();
	
	void clearCart();
	
	void addToCart(long storageID, int amount);
	
	void removeFromCart(long storageID);
	
	Receipt Buy();
	
	
	
}
