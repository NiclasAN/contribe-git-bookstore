package se.nordh.bookstore.repository;

import se.nordh.bookstore.domain.Book;

/**
 * Currently Unused cause I couldn't wrap my head around this interface
 * @author Niclas
 *
 */


public interface BookList {
	public Book[] list(String searchString);
	public boolean add(Book book, int amount);
	public int[] buy(Book... books);
	   
}
