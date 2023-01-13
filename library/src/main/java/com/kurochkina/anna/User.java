package com.kurochkina.anna;

import java.util.List;

public class User {
	String id;
	String firstName;
	String lastName;
	String login;
	String dateOfBirth;
	String phone;
	String address;
	String password;
	boolean isAdmin;
	List<String> booksLoaned;

	public User() {
	}


	public User(String id, String firstName, String lastName, String login, String dateOfBirth, String phone, String address, String password, boolean isAdmin) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.login = login;
		this.dateOfBirth = dateOfBirth;
		this.phone = phone;
		this.address = address;
		this.password = password;
		this.isAdmin = isAdmin;
	}
	

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isIsAdmin() {
		return this.isAdmin;
	}

	public boolean getIsAdmin() {
		return this.isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	public List<String> getBooksLoaned() {
		return this.booksLoaned;
	}

	public void setBooksLoaned(List<String> booksLoaned) {
		this.booksLoaned = booksLoaned;
	}

	public void addLoanedBook(String number){
        this.booksLoaned.add(number);
    }

    public void returnBook(String number){
        this.booksLoaned.remove(number);
    }

	@Override
	public String toString() {
		return "ID: " + id + " Name: "+ firstName + " " + lastName + " \n";
	}


	public String setId() {
		return null;
	}

	// @Override
	// public String toString() {
	// 	return "{" +
	// 		" id='" + getId() + "'" +
	// 		", firstName='" + getFirstName() + "'" +
	// 		", lastName='" + getLastName() + "'" +
	// 		", login='" + getLogin() + "'" +
	// 		", dateOfBirth='" + getDateOfBirth() + "'" +
	// 		", phone='" + getPhone() + "'" +
	// 		", address='" + getAddress() + "'" +
	// 		", password='" + getPassword() + "'" +
	// 		", isAdmin='" + isIsAdmin() + "'" +
	// 		", booksLoaned='" + getBooksLoaned() + "'" +
	// 		"}";
	// }
}
