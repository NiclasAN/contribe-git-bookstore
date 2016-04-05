package se.nordh.bookstore.domain;

import java.util.Set;

public class Receipt {
	private int totalPrice;
	private Set<ReceiptEntry> receiptEntrySet;
	
	public Receipt(int totalPrice, Set<ReceiptEntry> receiptEntrySet) {
		setTotalPrice(totalPrice);
		setReceiptEntrySet(receiptEntrySet);
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Set<ReceiptEntry> getReceiptEntrySet() {
		return receiptEntrySet;
	}

	public void setReceiptEntrySet(Set<ReceiptEntry> receiptEntrySet) {
		this.receiptEntrySet = receiptEntrySet;
	}

}
