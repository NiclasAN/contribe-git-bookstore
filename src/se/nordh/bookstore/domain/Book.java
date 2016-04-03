package se.nordh.bookstore.domain;

import java.math.BigDecimal;

public class Book {
	private String title;
	private String author;
	private BigDecimal price;
	
	public Book(String title, String author, BigDecimal price) {
		setTitle(title);
		setAuthor(author);
		setPrice(price);
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", price=" + price + "]";
	}
	
	

}
