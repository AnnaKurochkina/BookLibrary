package com.kurochkina.anna;

import java.util.Scanner;

public class InputReader {
	private Scanner scanner = new Scanner(System.in);

	public int getInteger() {
		while(true) {
			String input = scanner.nextLine();
			try {
				int selected = Integer.parseInt(input);
				return selected;
			} catch (Exception e) {
				System.out.println("That was not an integer, please try again.");
			}
		}
	}

	public String getString() {
		return scanner.nextLine();
	}
}
