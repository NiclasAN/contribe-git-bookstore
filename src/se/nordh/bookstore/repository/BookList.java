package se.nordh.bookstore.repository;

import se.nordh.bookstore.domain.Book;

public interface BookList {
	public Book[] list(String searchString);
	public boolean add(Book book, int amount);
	public int[] buy(Book... books);
	   
}
