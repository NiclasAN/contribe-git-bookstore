package se.nordh.bookstore.repository.mock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import se.nordh.bookstore.domain.Book;
import se.nordh.bookstore.domain.BookAndStock;
import se.nordh.bookstore.repository.BookList;

/**
 * Currently Unused cause I couldn't wrap my head around the interface
 * @author Niclas
 *
 */

public class BooklistMockImpl implements BookList {
	public List<BookAndStock> stockList = new ArrayList<>();
	private boolean syncCheck = true;
	
	@Override
	public Book[] list(String searchString) {	
		
		//If first call of session, Downloads and adds online data into list of books
		if(syncCheck == true) {
			URL url;
			try {
				url = new URL("http://www.contribe.se/bookstoredata/bookstoredata.txt");
				try {
					BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
					stockList.clear();
					syncCheck = false;
					
					while(true) {
						String onlineStock = reader.readLine();
						if(onlineStock == null) {
							break;
						}
						
						String[] bookData = onlineStock.split(";");
						Book book = new Book(bookData[0], bookData[1], StringToBigDecimal(bookData[2]));
						
						BookAndStock bookAndStock = new BookAndStock(book, StringToInteger(bookData[3]));
						stockList.add(bookAndStock);
						
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			
		}
		
		//Search Function
		Book [] books = new Book[10];
 		int stockListLength = stockList.size();
		for (int i = 0; i < stockListLength; i++) {
			if(stockList.get(i).getBook().getTitle().contains(searchString) || 
					stockList.get(i).getBook().getAuthor().contains(searchString)) {
				
				books[i] = new Book(stockList.get(i).getBook().getTitle(), stockList.get(i).getBook().getAuthor(), stockList.get(i).getBook().getPrice());
				
			}
		}
		
		return books;
	}

	@Override
	public boolean add(Book book, int amount) {
		BookAndStock bookAndStock = new BookAndStock(book, amount);
		stockList.add(bookAndStock);
		return false;
	}

	@Override
	public int[] buy(Book... books) {
		return null;
	}
	
	private BigDecimal StringToBigDecimal (String price) {
		BigDecimal bigDecimal = null;
		
		// Creates a DecimalFormat that fits the requirements
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setGroupingSeparator(',');
		symbols.setDecimalSeparator('.');
		String pattern = "#,##0.0#";
		DecimalFormat dF = new DecimalFormat(pattern, symbols);
		dF.setParseBigDecimal(true);
		
		// parse the string
		try {
			bigDecimal = (BigDecimal) dF.parse(price);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return bigDecimal;
		
	}
	
	private Integer StringToInteger (String stock) {
		int result = Integer.parseInt(stock);
		return result;
		
	}

}
