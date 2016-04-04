package se.nordh.bookstore.repository.mock;

import java.util.HashMap;
import java.util.Map;

import se.nordh.bookstore.domain.Book;
import se.nordh.bookstore.repository.AbstractIdCounter;
import se.nordh.bookstore.repository.CartRepository;

public class CartMockRepoImpl extends AbstractIdCounter implements CartRepository{
	public Map<Long, Book> cartMockList = new HashMap<Long, Book>();

	@Override
	public long addBook(Book book) {
		Long id = getNewId();
		cartMockList.put(id, book);
		return id;
	}

	@Override
	public void removeBook(long id) {
		cartMockList.remove(id);
		
	}

	@Override
	public void clearCart() {
		cartMockList.clear();
		
	}

}
