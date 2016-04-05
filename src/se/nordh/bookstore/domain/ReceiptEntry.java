package se.nordh.bookstore.domain;

import se.nordh.bookstore.utilities.BuyStatus;

public class ReceiptEntry {
	private int price;
	private Enum<BuyStatus> status;
	private Book book;
	
	public ReceiptEntry(int price, Enum<BuyStatus> status, Book book) {
		setPrice(price);
		setStatus(status);
		setBook(book);
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Enum<BuyStatus> getStatus() {
		return status;
	}

	public void setStatus(Enum<BuyStatus> status) {
		this.status = status;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
}
