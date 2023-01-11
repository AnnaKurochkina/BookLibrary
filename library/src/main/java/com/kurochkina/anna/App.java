package com.kurochkina.anna;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

// import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) throws IOException, URISyntaxException {
		System.out.println("Hello World!");
		var booksFileName = "books_data.json";
		File books = new File(booksFileName);
		if (!books.exists()) {
			var booksToJson = FileUtility.LoadBooks("books_data.csv");
			FileUtility.WriteJson(booksToJson, booksFileName);
			// System.out.println(books.getName());
			// } else {
			// System.out.println(books.getName());
		}
		// Book Book = new Book();
		// Book.toString();
		// books.toString();

		// ObjectMapper mapper = new ObjectMapper();
		// // File file = new File("books_data.json");
		// // Book book = ObjectMapper.readValue(file, Book.class);
		// ObjectReader book = mapper.reader();
		// System.out.println(book.toString());

		// ObjectMapper objectMapper = new ObjectMapper();
		// Book book = objectMapper.readValue(new
		// File("library/src/main/resources/books_data.json"), Book.class);
		// System.out.println(book);

		// ObjectMapper mapper = new ObjectMapper();
		// // List<Book> allBooks = (List<Book>) mapper.readValue(books, Book.class);
		// Book[] allBooks = mapper.readValue(books, Book[].class);
		// System.out.println(allBooks[3].author);

		// public static String displayAll() {
		// for (Book book : allBooks) {
		// return "ID: " + book.number + " Title: "+ book.title + " \n";
		// }
		// }
		// FileUtility.ReadJson(books);
		// ObjectMapper mapper = new ObjectMapper();
		// mapper.enable(SerializationFeature.INDENT_OUTPUT);
		// String indented = mapper.writeValueAsString(books);
		// System.out.println(indented);

		// FileUtility.ReadJson("books_data.json");
		// var books = CsvReader.LoadBooks("books_data.csv");
		// // System.out.println(books.get(0).title);
		// // System.out.println(books.size());
		// // System.out.println(books.get(0).toString());
		// // System.out.println(CsvReader.CsvToJson(books));
		// // var json = CsvReader.CsvToJson(books);

		// ObjectMapper mapper = new ObjectMapper();
		// String jsonResult =
		// mapper.writerWithDefaultPrettyPrinter().writeValueAsString(books);
		// ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
		// writer.writeValue(new File("library/src/main/resources/books_data.json"),
		// books);
		// // System.out.println(jsonResult);

	}
}
