package se.nordh.bookstore.utilities;

public class AbstractIdCounter {
	private static long id = 1;

	public static long getNewId() {
		return id++;
		
	}
	
}
