package se.nordh.bookstore.repository;

public class AbstractIdCounter {
	private static long id = 1;

	public static long getNewId() {
		return id++;
		
	}
	
}
