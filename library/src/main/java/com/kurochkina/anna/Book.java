package com.kurochkina.anna;

public class Book {
	String number;
	String title;
	String author;
	String genre;
	String subGenre;
	String publisher;
	boolean isBorrowed;
	String userId;
	int timesLoaned;

	public Book(String number, String title, String author, String genre, String subGenre, String publisher, boolean isBorrowed, int timesLoaned) {
		this.number = number;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.subGenre = subGenre;
		this.publisher = publisher;
		this.isBorrowed = false;
		this.timesLoaned = 0;
	}

	public void setIsBorrowed(boolean isBorrowed) {
		this.isBorrowed = true;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
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

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
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
