package com.kurochkina.anna;
import org.apache.commons.codec.digest.DigestUtils;

public class StringUtilities {
	
	public static String padRight(Object s, int n) {
		return String.format("%-" + n + "s", s);
	}

	public static String padLeft(Object s, int n) {
		return String.format("%" + n + "s", s);
	}

	public static String hashString(String input) {
		return DigestUtils.sha1Hex(input);
	}
}
