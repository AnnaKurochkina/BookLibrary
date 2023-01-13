package com.kurochkina.anna;

import java.io.File;
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

	@SuppressWarnings("unchecked")
	public static <T> List<T> LoadItems(String fileName, Class<T> type) throws IOException, URISyntaxException {
		var stream = FileUtility.class.getClassLoader().getResourceAsStream(fileName);
		var bootstrapSchema = CsvSchema.emptySchema().withHeader();
		var mapper = CsvMapper
				.builder()
				.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
				// .configure(MapperFeature.ALLOW_EXPLICIT_PROPERTY_RENAMING, true)
				// .configure(SerializationFeature., false)
				.build();
		MappingIterator<Book> iterator = mapper.readerFor(type).with(bootstrapSchema).readValues(stream);
		return (List<T>) iterator.readAll();
	}

	public static <T> void WriteJson(List<T> T, String fileName) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
		writer.writeValue(new File(fileName), T);
	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> ReadJson(File file, Class<T> type) throws StreamReadException, DatabindException, IOException {
		var mapper = JsonMapper
			.builder()
			.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
			.build();
		MappingIterator<Book> iterator = mapper.readerFor(type).readValues(file);
		return (List<T>) iterator.readAll();
	}



	// public static List<Book> LoadBooks(String fileName) throws IOException, URISyntaxException {
	// 	var stream = FileUtility.class.getClassLoader().getResourceAsStream(fileName);
	// 	var bootstrapSchema = CsvSchema.emptySchema().withHeader();
	// 	var mapper = CsvMapper
	// 			.builder()
	// 			.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
	// 			.build();
	// 	MappingIterator<Book> iterator = mapper.readerFor(Book.class).with(bootstrapSchema).readValues(stream);
	// 	return iterator.readAll();
	// }

	// public static void WriteJson(List<Book> books, String fileName) throws IOException {
	// 	ObjectMapper mapper = new ObjectMapper();
	// 	ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
	// 	writer.writeValue(new File(fileName), books);
	// }

	// public static List<Book> ReadJson(File books) throws StreamReadException, DatabindException, IOException {
	// 	var mapper = JsonMapper
	// 		.builder()
	// 		.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
	// 		.build();
	// 	MappingIterator<Book> iterator = mapper.readerFor(Book.class).readValues(books);
	// 	return iterator.readAll();
	// }

}
