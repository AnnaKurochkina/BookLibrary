package com.kurochkina.anna;

// import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.MappingIterator;
// import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
// import java.util.Map;

public class CsvReader {
	public static List<Book> LoadBooks(String fileName) throws IOException, URISyntaxException {
		var uri = CsvReader.class.getClassLoader().getResource(fileName);
		var file = new File(uri.toURI());
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
	
	// public static void CsvToJson(List<Book> LoadBooks) throws JsonProcessingException {
	// 	ObjectMapper mapper = new ObjectMapper();
    //     String jsonResult = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(LoadBooks);
	// 	System.out.println(jsonResult);
	// }
	

}
