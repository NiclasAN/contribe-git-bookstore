package se.nordh.bookstore.repository;

import java.util.Map;
import java.util.Set;

import se.nordh.bookstore.domain.BookAndStock;
import se.nordh.bookstore.domain.Receipt;

public interface StoreRepository {
	
	long createBookAndStock(BookAndStock bookAndStock);
	
	void updateStock(long storageID, int amount);
	
	BookAndStock getBookAndStock(long storageID);
	
	Map<Long, BookAndStock> findTitleOrAuthor(String searchString);
	
	Set<BookAndStock> getAllBooks();
	
	Set<BookAndStock> getBookAndStockByStorageID(long storageID);
	
	void deleteBookAndStock(long storageID);
	
	void clearInventory();
	
	void clearCart();
	
	void getOnlineStock();
	
	void addToCart(long storageID, int amount);
	
	void removeFromCart(long storageID);
	
	Receipt Buy();
	
	
	
}
