package se.nordh.bookstore.utilities;

public enum BuyStatus {
	OK(0), NOT_IN_STOCK(1), DOES_NOT_EXIST(2);

	private final int value;

	private BuyStatus(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
