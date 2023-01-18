package com.kurochkina.anna;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

public class BookStore extends Store<Book> {

	List<Book> books;

	public BookStore() throws IOException, URISyntaxException {
		super("books_data.json", "books_data.csv", Book.class);
		this.books = loadData();
	}

	public void printAllBooks() {
		for (Book book : books) {
			System.out.println(book.toString());
		}
	}

	public void booksOnLoan() throws IOException {
		List<LoanedBook> reportRows = books
			.stream()
			.filter(book -> book.isLoaned())
			.map(book -> new LoanedBook(book.getNumber(), book.getTitle(), book.getLoanedToUserId()))
			.toList();

		for (LoanedBook book : reportRows) {
			System.out.println(book.toString());
		}

		System.out.println(
				"\n(1) Save this report as a CSV file named report_booksOnLoan.csv\n(0) Go back");
		int selected = input.getInteger();
		if (selected == 0) {
			return;
		}
		if (selected == 1) {
			Mapper.writeCsvFile(reportRows, new File("report_booksOnLoan.csv"), LoanedBook.class);
		}
	}

	public void bookLoanCounts() throws IOException {
		List<TimesLoanedBook> reportRows = books
			.stream()
			.filter(book -> book.getTimesLoaned() > 0)
			.map(book -> new TimesLoanedBook(book.getNumber(), book.getTitle(), book.getLoanedToUserId()))
			.toList();

		for (TimesLoanedBook book : reportRows) {
			System.out.println(book.toString());
		}

		System.out.println(
				"\n(1) Save this report as a CSV file named report_bookLoanCounts.csv\n(0) Go back");
		int selected = input.getInteger();
		if (selected == 0) {
			return;
		}
		if (selected == 1) {
			Mapper.writeCsvFile(reportRows, new File("report_bookLoanCounts.csv"), TimesLoanedBook.class);
		}
	}

	public void loanBook(User user) throws Exception {
		System.out.println("Enter the id of the book that you would like to borrow (enter 0 to cancel): ");
		int selected = input.getInteger();
		if (selected == 0) {
			return;
		}

		findBookAnd(selected, book -> {
			if (!book.isLoaned()) {
				book.loanToUserId(user.getId());
				saveData(books);
				System.out.println("You have loaned out book " + book.getNumber() + ".");
			} else {
				System.out.println("That book is already loaned out. Choose another.");
				loanBook(user);
			}
		}, () -> loanBook(user));
	}

	public void returnBook(User user) throws Exception {
		System.out.println("Enter the id of the book that you would like to return (enter 0 to cancel): ");
		int selected = input.getInteger();
		if (selected == 0) {
			return;
		}

		findBookAnd(selected, book -> {
			if (book.isLoanedToUser(user)) {
				book.returnBook();
				saveData(books);
				System.out.println("You have returned book " + book.getNumber() + ".");
			} else {
				System.out.println("That book is not loaned out to you. Choose another.");
				returnBook(user);
			}
		}, () -> returnBook(user));
	}

	private void findBookAnd(int number, Consumer<Book, Exception> found, Runnable<Exception> notFound)
			throws Exception {
		Optional<Book> searchResult = this.books
				.stream()
				.filter(item -> item.getNumber() == number)
				.findFirst();
		if (searchResult.isPresent()) {
			found.accept(searchResult.get());
		} else {
			System.out.println("Invalid input. Please try again.");
			notFound.run();
		}
	}

	public void booksLoanedToUser(User user) {
		// books
		// 		.stream()
		// 		.filter(book -> book.isLoanedToUser(user))
		// 		.map(book -> new Book())
		// 		.toList();

		// for (Book book : books) {
		// 	System.out.println(book.toString());
		// }
	}
}
