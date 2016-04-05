package se.nordh.bookstore.repository.mock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import se.nordh.bookstore.domain.Book;
import se.nordh.bookstore.domain.BookAndStock;
import se.nordh.bookstore.repository.StoreRepository;
import se.nordh.bookstore.utilities.AbstractIdCounter;
import se.nordh.bookstore.utilities.MiscUtilities;

public class StoreMockRepoImpl extends AbstractIdCounter implements StoreRepository {
	public Map<Long, BookAndStock> inventoryList = new HashMap<Long, BookAndStock>();
	public Map<Long, BookAndStock> cartContent = new HashMap<Long, BookAndStock>();
	private MiscUtilities miscUtilities;

	@Override
	public long createBookAndStock(BookAndStock bookAndStock) {
		long storageID = getNewId();
		inventoryList.put(storageID, bookAndStock);
		return storageID;
	}

	@Override
	public void updateStock(long storageID, int amount) {
		BookAndStock bookAndStock = new BookAndStock(getBookAndStock(storageID).getBook(), amount);
		inventoryList.put(storageID, bookAndStock);

	}

	@Override
	public BookAndStock getBookAndStock(long storageID) {
		return inventoryList.get(storageID);
	}

	@Override
	public Set<BookAndStock> getAllBooks() {
		Set<BookAndStock> booksAndStock = new HashSet<BookAndStock>(inventoryList.values());
		return booksAndStock;
	}

	@Override
	public Set<BookAndStock> getBookAndStockByStorageID(long storageID) {
		Set<BookAndStock> bookAndStockByStorageID = new HashSet<>();
		for(BookAndStock b : inventoryList.values()) {
			if(b.getStorageID() == storageID) {
				bookAndStockByStorageID.add(b);
			}
		}
		return bookAndStockByStorageID;
	}

	@Override
	public void deleteBookAndStock(long storageID) {
		inventoryList.remove(storageID);

	}

	@Override
	public void clearStock() {
		inventoryList.clear();

	}

	@Override
	public void getOnlineStock() {
		URL url;
		try {
			url = new URL("http://www.contribe.se/bookstoredata/bookstoredata.txt");
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
				inventoryList.clear();
				while(true) {
					String onlineStock = reader.readLine();
					if(onlineStock == null) {
						break;
					}
					
					String[] bookData = onlineStock.split(";");
					Book book = new Book(bookData[0], bookData[1], miscUtilities.StringToBigDecimal(bookData[2]));
					BookAndStock bookAndStock = new BookAndStock(book, miscUtilities.StringToInteger(bookData[3]));
					inventoryList.put(getNewId(), bookAndStock);
					
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void addToCart(long storageID, int amount) {
		BookAndStock bookAndStock = new BookAndStock(getBookAndStock(storageID).getBook(), amount);
		cartContent.put(storageID, bookAndStock);
		updateStock(storageID, getBookAndStock(storageID).getStock() - amount);
		
	}

	@Override
	public void RemoveFromCart(long storageID) {
		int amount = cartContent.get(storageID).getStock();
		updateStock(storageID, getBookAndStock(storageID).getStock() + amount);
		cartContent.remove(storageID);
		
	}

	@Override
	public int CashOut() {
		// TODO Auto-generated method stub
		return 0;
	}

}
