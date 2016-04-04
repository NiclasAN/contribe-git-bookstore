package se.nordh.bookstore.services;

import se.nordh.bookstore.domain.Book;
import se.nordh.bookstore.repository.BookList;
import se.nordh.bookstore.repository.CartRepository;

public class StoreServiceImpl implements StoreService {
	private BookList bookList;
	private CartRepository cartRepo;

	@Override
	public void addToCart(Book book) {
		cartRepo.addBook(book);
		// TODO Remove 1x from stock amount

	}

	@Override
	public void removeFromCart(long id) {
		cartRepo.removeBook(id);
		// TODO add 1x back to stock amount

	}

	@Override
	public void addBook(Book book, int amount) {
		bookList.add(book, amount);

	}

	@Override
	public void buySelection(Book... books) {
		bookList.buy(books);
		cartRepo.clearCart();

	}

}
