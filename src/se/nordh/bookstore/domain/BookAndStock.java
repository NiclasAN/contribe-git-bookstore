package se.nordh.bookstore.domain;

public class BookAndStock {
	private Book book;
	private int stock;
	
	public BookAndStock (Book book, int stock) {
		setBook(book);
		setStock(stock);
		
	}
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}


}
