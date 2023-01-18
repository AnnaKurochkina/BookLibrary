package com.kurochkina.anna;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class UserStore extends Store<User> {

	List<User> users;

	public UserStore() throws IOException, URISyntaxException {
		super("users_data.json", "users_data.csv", User.class);
		this.users = loadData();
	}

	public User loginRegister2() throws IOException {
		return users.get(0);
	}

	public User loginRegister() throws IOException {

		System.out.println("Would you like to login or register? \n(1) Login\n(2) Register");
		int option = input.getInteger();
		if (option == 1) {
			System.out.println("Enter login: ");
			String userLogin = input.getString();

			System.out.println("Enter password: ");
			String userPassword = input.getString();
			Optional<User> searchResult = this.users
					.stream()
					.filter(item -> item.isMatch(userLogin, userPassword))
					.findFirst();
			if (searchResult.isPresent()) {
				return searchResult.get();

			} else {
				System.out.println("Invalid input. Please try again or register");
				return loginRegister();
			}
		} else if (option == 2) {
			return addUser();
		} else {
			System.out.println("Invalid input, try again.");
			return loginRegister();
		}
	}

	public User addUser() throws IOException {
		System.out.println("Enter first name: ");
		String firstName = input.getString();

		System.out.println("Enter last name: ");
		String lastName = input.getString();

		System.out.println("Enter date of birth: ");
		String dateOfBirth = input.getString();

		System.out.println("Enter phone number: ");
		String phone = input.getString();

		System.out.println("Enter address: ");
		String address = input.getString();

		System.out.println("Enter login: ");
		String login = input.getString();

		System.out.println("Enter password: ");
		String password = input.getString();

		int nextId = users.stream().map(User::getId).max(Comparator.naturalOrder()).get() + 1;

		User newUser = new User(nextId, firstName, lastName, login, dateOfBirth, phone, address, password);
		users.add(newUser);
		saveData(users);
		return newUser;
	}

	public void promoteUser() throws Exception {
		System.out.println("List all users: ");
		System.out.println(users);
		System.out.println("type id of a new librarian or enter 0 to cancel.");
		int selected = input.getInteger();
		if (selected == 0) {
			return;
		}
		findUserAnd(selected, user -> {
			if (!user.getIsAdmin()) {
				user.promoteUser();
				saveData(users);
				System.out.println(
						user.getId() + user.getFirstName() + user.getLastName() + " is now a new librarian.");
			} else {
				System.out.println("That user is already a librarian.");
				promoteUser();
			}
		}, () -> promoteUser());
	}

	public void demoteUser() throws Exception {
		System.out.println("List all users: ");
		System.out.println(users);
		System.out.println("type id of demoted librerian or enter 0 to cancel.");
		int selected = input.getInteger();
		if (selected == 0) {
			return;
		}
		findUserAnd(selected, user -> {
			if (user.getIsAdmin()) {
				user.demoteUser();
				saveData(users);
				System.out.println(
						user.getId() + user.getFirstName() + user.getLastName() + " is not a librerian anymore.");
			} else {
				System.out.println("That user is not a librarian, but you always can promote him/her!");
				demoteUser();
			}
		}, () -> demoteUser());
	}

	private void findUserAnd(int id, Consumer<User, Exception> found, Runnable<Exception> notFound) throws Exception {
		Optional<User> searchResult = this.users
				.stream()
				.filter(item -> item.getId() == id)
				.findFirst();
		if (searchResult.isPresent()) {
			found.accept(searchResult.get());
		} else {
			System.out.println("Invalid input. Please try again.");
			notFound.run();
		}
	}
}
