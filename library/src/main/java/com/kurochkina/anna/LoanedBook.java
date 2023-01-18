package com.kurochkina.anna;

public class LoanedBook {
	private int number;
	private String title;
	private int loanedToUserId;

	public LoanedBook(int number, String title, int loanedToUserId) {
		this.number = number;
		this.title = title;
		this.loanedToUserId = loanedToUserId;
	}

	public int getNumber() {
		return this.number;
	}

	public String getTitle() {
		return this.title;
	}

	public int getLoanedToUserId() {
		return this.loanedToUserId;
	}

	@Override
	public String toString() {
		return
			" ID: " + StringUtilities.padRight(number, 4) + "Title: " + StringUtilities.padRight(title, 60) + "Loaned to user: " + StringUtilities.padRight(loanedToUserId, 30);
	}
}
