package se.nordh.bookstore.services;

import se.nordh.bookstore.domain.Book;

public interface StoreService {
	void addToCart(Book book);
	void removeFromCart(long id);
	void addBook(Book book, int amount);
	void buySelection(Book... books);
}
