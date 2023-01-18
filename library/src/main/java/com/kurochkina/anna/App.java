package com.kurochkina.anna;

import java.util.Scanner;

public class App {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

		BookStore books = new BookStore();
		UserStore users = new UserStore();
		// books.printAllBooks();
		while (true) {
			User user = users.loginRegister();
			mainMenu(books, user, users);
		}
	}

	public static void mainMenu(BookStore books, User user, UserStore users) throws Exception {
		// TO DO print out the user's books that he has loaned out

		// System.out.println("\nBooks you are reading now: ");
		// books.booksLoanedToUser(user);

		System.out.println("\nPlease Select an Option...");
		String menuItems = "(0) Exit\n" +
				"(1) See All Books\n" +
				"(2) Loan a book\n" +
				"(3) Return a book\n" +
				"(4) Log out\n";

		if (user.getIsAdmin()) {
			menuItems += "(5) Promote a user\n" +
					"(6) Demote a user\n" +
					"(7) Report books on loan\n" +
					"(8) Report book loan counts\n";
		}

		System.out.println(menuItems);

		int selected = scanner.nextInt();

		if (selected == 0) {
			System.exit(0);
		} else if (selected == 1) {
			books.printAllBooks();
			mainMenu(books, user, users);
		} else if (selected == 2) {
			books.loanBook(user);
			mainMenu(books, user, users);
		} else if (selected == 3) {
			books.returnBook(user);
			mainMenu(books, user, users);
		} else if (selected == 4) {
			return;
		} else if (user.getIsAdmin()) {
			if (selected == 5) {
				users.promoteUser();
				mainMenu(books, user, users);
			} else if (selected == 6) {
				users.demoteUser();
				mainMenu(books, user, users);
			} else if (selected == 7) {
				books.booksOnLoan();
				mainMenu(books, user, users);
			} else if (selected == 8) {
				books.bookLoanCounts();
				mainMenu(books, user, users);
			} else {
				invalidInput(books, user, users);
			}
		} else {
			invalidInput(books, user, users);
		}
	}

	private static void invalidInput(BookStore books, User user, UserStore users) throws Exception {
		System.out.println("Didn't understand input, try again");
		mainMenu(books, user, users);
	}
}
