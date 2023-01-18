package com.kurochkina.anna;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public abstract class Store<T> {

	protected InputReader input = new InputReader();

	private String fileName;
	private String resourceName;
	private Class<T> type;

	public Store(String fileName, String resourceName, Class<T> type) {
		super();
		this.fileName = fileName;
		this.resourceName = resourceName;
		this.type = type;
	}

	protected List<T> loadData() throws IOException, URISyntaxException {
		File file = new File(fileName);
		List<T> data;
		if (file.exists()) {
			data = Mapper.readJsonFile(file, type);
		}
		else {
			data = Mapper.readCsvResource(resourceName, type);
			Mapper.writeJsonFile(data, file);
		}		
		return data;
	}

	protected void saveData(List<T> data) throws IOException {
		File file = new File(fileName);
		Mapper.writeJsonFile(data, file);
	}
}
