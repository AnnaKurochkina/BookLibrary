package com.kurochkina.anna;

public class TimesLoanedBook {
	private int number;
	private String title;
	private int timesLoaned;

	public TimesLoanedBook(int number, String title, int timesLoaned) {
		this.number = number;
		this.title = title;
		this.timesLoaned = timesLoaned;
	}

	public int getNumber() {
		return this.number;
	}

	public String getTitle() {
		return this.title;
	}

	public int getTimesLoaned() {
		return this.timesLoaned;
	}

	@Override
	public String toString() {
		return
			" ID: " + StringUtilities.padRight(number, 4) + "Title: " + StringUtilities.padRight(title, 60) + "Times loaned: " + StringUtilities.padRight(timesLoaned, 4);
	}
}
