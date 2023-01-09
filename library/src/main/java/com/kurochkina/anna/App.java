package com.kurochkina.anna;

import java.io.IOException;
import java.net.URISyntaxException;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, URISyntaxException
    {
        System.out.println( "Hello World!" );
		var books = CsvReader.LoadBooks("books_data.csv");
		// System.out.println(books.get(0).title);
		System.out.println(books.size());
		

    }
}
