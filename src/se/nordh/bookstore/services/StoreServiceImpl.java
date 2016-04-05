package se.nordh.bookstore.services;

import java.util.Map;
import java.util.Set;

import se.nordh.bookstore.domain.BookAndStock;
import se.nordh.bookstore.repository.StoreRepository;

public class StoreServiceImpl implements StoreService {
	private StoreRepository storeRepo;

	@Override
	public BookAndStock getBookAndStock(long storageID) {
		return getStoreRepo().getBookAndStock(storageID);
	}

	@Override
	public Set<BookAndStock> getAllBooks() {
		return getStoreRepo().getAllBooks();
	}

	@Override
	public Set<BookAndStock> getBookAndStockByStorageID(long storageID) {
		return getStoreRepo().getBookAndStockByStorageID(storageID);
	}

	@Override
	public long createNewBook(BookAndStock bookAndStock) {
		return getStoreRepo().createBookAndStock(bookAndStock);
	}

	@Override
	public void updateStock(long storageID, int amount) {
		getStoreRepo().updateStock(storageID, amount);
		
	}

	@Override
	public void deleteBookFromStock(long storageID) {
		getStoreRepo().deleteBookAndStock(storageID);
		
	}

	@Override
	public void clearInventory() {
		getStoreRepo().clearInventory();
		
	}

	@Override
	public void clearCart() {
		getStoreRepo().clearCart();
		
	}

	@Override
	public void addToCart(long storageID, int amount) {
		getStoreRepo().addToCart(storageID, amount);
		
	}

	@Override
	public void removeFromCart(long storageID) {
		getStoreRepo().RemoveFromCart(storageID);
		
	}

	@Override
	public int CashOut() {
		return getStoreRepo().CashOut();
	}

	public StoreRepository getStoreRepo() {
		return storeRepo;
	}

	public void setStoreRepo(StoreRepository storeRepo) {
		this.storeRepo = storeRepo;
	}

	@Override
	public Map<Long, BookAndStock> findTitleOrAuthor(String searchString) {
		return getStoreRepo().findTitleOrAuthor(searchString);
	}

}
