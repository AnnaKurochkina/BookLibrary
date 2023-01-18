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

public class Mapper {

	public static <T> List<T> readCsvResource(String resourceName, Class<T> type)
			throws IOException, URISyntaxException {
		var stream = Mapper.class.getClassLoader().getResourceAsStream(resourceName);
		var bootstrapSchema = CsvSchema.emptySchema().withHeader();
		var mapper = CsvMapper
			.builder()
			.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
			.build();
		MappingIterator<T> iterator = mapper.readerFor(type).with(bootstrapSchema).readValues(stream);
		return iterator.readAll();
	}

	public static <T> void writeJsonFile(List<T> items, File file) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
		writer.writeValue(file, items);
	}

	public static <T> List<T> readJsonFile(File file, Class<T> type)
			throws StreamReadException, DatabindException, IOException {
		var mapper = JsonMapper
			.builder()
			.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
			.build();
		MappingIterator<T> iterator = mapper.readerFor(type).readValues(file);
		return iterator.readAll();
	}

	public static <T> void writeCsvFile(List<T> items, File file, Class<T> type) throws IOException {
		var mapper = CsvMapper
			.builder()
			.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
			.build();
		var schema = mapper.schemaFor(type).withHeader();
		mapper.writerFor(items.getClass()).with(schema).writeValue(file, items);
	}
}
