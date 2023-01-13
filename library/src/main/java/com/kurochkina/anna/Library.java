package com.kurochkina.anna;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Scanner;

public class Library {
	
	public void OpenLibrary() throws IOException, URISyntaxException {
		var booksFileName = "books_data.json";
		File books = new File(booksFileName);
		if (!books.exists()) {
			var booksToJson = FileUtility.LoadItems("books_data.csv", Book.class);
			// var booksToJson = FileUtility.LoadBooks("books_data.csv", Book.class);
			FileUtility.WriteJson(booksToJson, booksFileName);
		}
	
		var usersFileName = "users_data.json";
		File users = new File(usersFileName);
		if (!users.exists()) {
			var usersToJson = FileUtility.LoadItems("users_data.csv", User.class);
			FileUtility.WriteJson(usersToJson, usersFileName);
		}

		// System.out.println(FileUtility.ReadJson(books, Book.class));
		// System.out.println(FileUtility.ReadJson(users, User.class));
	}
	

	Scanner scanner = new Scanner(System.in);
	
	private String id;


	

	public void LoginRegister() throws IOException, URISyntaxException {

		List<User> allUsers = FileUtility.ReadJson(new File("users_data.json"), User.class);
		System.out.println(allUsers);

		System.out.println("Would you like to login or register? \n(1) Login\n(2) Register");
		int option = scanner.nextInt();
		if (option == 1) {
			System.out.println("Enter login: ");
			String userLogin = scanner.next();

			System.out.println("Enter password: ");
			String userPassword = scanner.next();

			System.out.println("login: " + userLogin + "password: " + userPassword);
			
			if ((allUsers.get().contains(userLogin) && allUsers.contains(userPassword))) {
				MainMenu();
			} else {
				System.out.println("Invalid input. Please try again or register");
				LoginRegister();
			}
		} else if (option == 2) {
			addUser();
			MainMenu();
		} else {
			System.out.println("Invalid input, try again.");
		}
	}

	public void addUser() throws IOException {
		System.out.println("Enter first name: ");
		String firstName = scanner.next();

		System.out.println("Enter last name: ");
		String lastName = scanner.next();

		System.out.println("Enter date of birth: ");
		String dateOfBirth = scanner.next();

		System.out.println("Enter phone number: ");
		String phone = scanner.next();

		System.out.println("Enter address: ");
		String address = scanner.next();

		System.out.println("Enter login: ");
		String login = scanner.next();

		System.out.println("Enter password: ");
		String password = scanner.next();


		// System.out.println("Are you a librarian?");
		// String isAdmin = scanner.nextLine();

		User newUser = new User(id, firstName, lastName, login, dateOfBirth, phone, address, password, false);

		List<User> allUsers = FileUtility.ReadJson(new File("users_data.json"), User.class);
		allUsers.add(newUser);
		System.out.println(allUsers.size());
		FileUtility.WriteJson(allUsers, "users_data.json");

		// try {
		// 	File file = new File("users_data.json");
		// 	FileWriter fileWriter = new FileWriter(file, true);
	
		// 	ObjectMapper mapper = new ObjectMapper();
	
		// 	SequenceWriter seqWriter = mapper.writer().writeValuesAsArray(fileWriter);
		// 	seqWriter.write(newUser);
		// 	seqWriter.close();
		// } catch (IOException e) {
		// 	e.printStackTrace();
		// }

		// ObjectMapper objectMapper = new ObjectMapper();
		// ObjectReader objectReader = objectMapper
		// 		.readerForUpdating(FileUtility.ReadJson(new File("users_data.json"), User.class));
		// List<String> updatedUsers = objectReader.readValue("users_data.json");
		// System.out.println("updated list: " + updatedUsers);

	}

	public void MainMenu() {
		System.out.println("Please Select an Option...");
		System.out.println("(0) Exit\n(1) See All Books\n(2) Loan a book\n(3) Return a book");

		int selected = scanner.nextInt();

		switch (selected) {
			case 0:
				System.exit(0);
				// break;
			case 1:
				// AllBooks method
				System.out.println("books list");
				MainMenu();
				// break;
			case 2:
				// LoanBoook method
				System.out.println("loan");
				MainMenu();
				// break;
			case 3:
				// ReturnBoook method
				System.out.println("return");
				MainMenu();
				break;
			default:
				System.out.println("Didn't understand input, try again");
				MainMenu();
				// break;

		}
	}

}