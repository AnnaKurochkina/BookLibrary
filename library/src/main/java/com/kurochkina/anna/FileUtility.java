package com.kurochkina.anna;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class FileUtility {

	public static List<Book> LoadBooks(String fileName) throws IOException, URISyntaxException {
		var url = FileUtility.class.getClassLoader().getResource(fileName);
		var path = url.getPath();

		System.out.println(path);
		var file = new File(path);

		// File output = new File("books_data.json");

		// Read schema from the first line; start with bootstrap instance
		// to enable reading of schema from the first line
		// NOTE: reads schema and uses it for binding
		var bootstrapSchema = CsvSchema.emptySchema().withHeader();
		var mapper = CsvMapper
				.builder()
				.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
				.build();

		MappingIterator<Book> iterator = mapper.readerFor(Book.class).with(bootstrapSchema).readValues(file);

		return iterator.readAll();
	}

	public static void WriteJson(List<Book> books, String fileName) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
		writer.writeValue(new File(fileName), books);
	}

	public static List<Book> ReadJson(File books) throws StreamReadException, DatabindException, IOException {
		var mapper = JsonMapper
			.builder()
			.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
			.build();
		MappingIterator<Book> iterator = mapper.readerFor(Book.class).readValues(books);
		return iterator.readAll();
	}

}
