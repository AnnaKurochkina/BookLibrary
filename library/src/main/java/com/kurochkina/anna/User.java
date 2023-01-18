package com.kurochkina.anna;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	private int id;
	private String firstName;
	private String lastName;
	private String login;
	private String dateOfBirth;
	private String phone;
	private String address;
	private String passwordHash;
	private boolean isAdmin;

	public User(int id,	String firstName, 	String lastName, String login, String dateOfBirth, String phone, String address, String password) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.login = login;
		this.dateOfBirth = dateOfBirth;
		this.phone = phone;
		this.address = address;
		this.passwordHash = StringUtilities.hashString(password);
		this.isAdmin = false;
	}

	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public User(@JsonProperty("id") int id, 
	@JsonProperty("firstName") String firstName, 
	@JsonProperty("lastName") String lastName, 
	@JsonProperty("login") String login, 
	@JsonProperty("dateOfBirth") String dateOfBirth, 
	@JsonProperty("phone") String phone,
	@JsonProperty("address") String address, 
	@JsonProperty("passwordHash") String passwordHash, 
	@JsonProperty("isAdmin") boolean isAdmin) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.login = login;
		this.dateOfBirth = dateOfBirth;
		this.phone = phone;
		this.address = address;
		this.passwordHash = passwordHash;
		this.isAdmin = isAdmin;
	}

	public int getId() {
		return this.id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getLogin() {
		return this.login;
	}

	public String getDateOfBirth() {
		return this.dateOfBirth;
	}

	public String getPhone() {
		return this.phone;
	}

	public String getAddress() {
		return this.address;
	}

	public String getPasswordHash() {
		return this.passwordHash;
	}

	public void setPassword(String password) {
		this.passwordHash = StringUtilities.hashString(password);
	}

	public boolean getIsAdmin() {
		return this.isAdmin;
	}

	public boolean isMatch(String login, String password) {
		var passwordHash = StringUtilities.hashString(password);
		return login.equals(this.login) && passwordHash.endsWith(this.passwordHash);
	}

	@Override
	public String toString() {
		return "ID: " + id + " Name: " + firstName + " " + lastName + " librerian " + isAdmin + " \n";
	}

	public void promoteUser() {
		this.isAdmin = true;
	}

	public void demoteUser() {
		this.isAdmin = false;
	}
}
