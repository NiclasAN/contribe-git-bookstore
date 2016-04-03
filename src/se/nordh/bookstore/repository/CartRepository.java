package se.nordh.bookstore.repository;

import se.nordh.bookstore.domain.Book;

public interface CartRepository {
	long addBook(Book book);
	void removeBook(long id);
	void clearCart();
}
