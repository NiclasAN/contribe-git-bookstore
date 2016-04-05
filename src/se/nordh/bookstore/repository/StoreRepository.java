package se.nordh.bookstore.repository;

import java.util.Set;

import se.nordh.bookstore.domain.BookAndStock;

public interface StoreRepository {
	
	long createBookAndStock(BookAndStock bookAndStock);
	
	void updateStock(long storageID, int amount);
	
	BookAndStock getBookAndStock(long storageID);
	
	Set<BookAndStock> getAllBooks();
	
	Set<BookAndStock> getBookAndStockByStorageID(long storageID);
	
	void deleteBookAndStock(long storageID);
	
	void clearStock();
	
	void getOnlineStock();
	
	void addToCart(long storageID, int amount);
	
	void RemoveFromCart(long storageID);
	
	int CashOut();
	
}
