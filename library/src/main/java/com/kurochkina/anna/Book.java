package com.kurochkina.anna;

public class Book {
	int number;
	String title;
	String author;
	String genre;
	String subGenre;
	String publisher;
	boolean isBorrowed;
	int userId;
	int timesLoaned;
	// String returnDate;

	public Book(int number, String title, String author, String genre, String subGenre, String publisher) {
		this.number = number;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.subGenre = subGenre;
		this.publisher = publisher;
		this.isBorrowed = false;
	}

	public void setIsBorrowed(boolean isBorrowed) {
		this.isBorrowed = true;
	}

	// book returned
	public void setToReturned() {
		this.isBorrowed = false;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTimesLoaned() {
		return this.timesLoaned;
	}

	public void setTimesLoaned(int timesLoaned) {
		this.timesLoaned = timesLoaned;
	}

	public Book() {
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getSubGenre() {
		return this.subGenre;
	}

	public void setSubGenre(String subGenre) {
		this.subGenre = subGenre;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "ID: " + number + " Title: "+ title+ " \n";
	}


}
