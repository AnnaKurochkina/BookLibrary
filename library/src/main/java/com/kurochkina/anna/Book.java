package com.kurochkina.anna;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {
	private int number;
	private String title;
	private String author;
	private String genre;
	private String subGenre;
	private String publisher;
	private int loanedToUserId;
	private int timesLoaned;

	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public Book(@JsonProperty("number") int number,
		@JsonProperty("title") String title,
		@JsonProperty("author") String author,
		@JsonProperty("genre") String genre, 
		@JsonProperty("subGenre") String subGenre, 
		@JsonProperty("publisher") String publisher,
		@JsonProperty("loanedToUserId") int loanedToUserId, 
		@JsonProperty("timesLoaned") int timesLoaned) {
		this.number = number;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.subGenre = subGenre;
		this.publisher = publisher;
		this.loanedToUserId = loanedToUserId;
		this.timesLoaned = timesLoaned;
	}

	public int getNumber() {
		return this.number;
	}

	public String getTitle() {
		return this.title;
	}

	public String getAuthor() {
		return this.author;
	}

	public String getGenre() {
		return this.genre;
	}

	public String getSubGenre() {
		return this.subGenre;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public int getLoanedToUserId() {
		return this.loanedToUserId;
	}

	public int getTimesLoaned() {
		return this.timesLoaned;
	}

	public void loanToUserId(int userId) throws Exception {
		if (this.loanedToUserId != 0) {
			throw new Exception("This book is already loaned out.");
		}
		this.loanedToUserId = userId;
		this.timesLoaned++;
	}

	@Override
	public String toString() {
	return "ID: " + StringUtilities.padRight(number, 5) + 
	"Title: " + StringUtilities.padRight(title, 60) + 
	"Author: " + StringUtilities.padRight(author, 25) + 
	"Loaned: " +  StringUtilities.padRight(isLoanedString(), 5);
	}

	private String isLoanedString() {
		return this.loanedToUserId != 0
			? "Yes"
			: "No";
	}

	@JsonIgnore
	public boolean isLoaned() {
		return this.loanedToUserId != 0;
	}

	public boolean isLoanedToUser(User user) {
		return this.loanedToUserId == user.getId();
	}

	public void returnBook() throws Exception {
		if (!isLoaned()) {
			throw new Exception("This book is not loaned out.");
		}
		this.loanedToUserId = 0;
	}
}
