package com.validation;

import java.io.*;
import java.util.regex.*; //regular expression

public class Validation {
	public static boolean isPhoneNo(String s) {

		// The given argument to compile() method
		// is regular expression. With the help of
		// regular expression we can validate mobile
		// number.
		// The number should be of 10 digits.

		// Creating a Pattern class object
		Pattern p = Pattern.compile("^\\d{10}$"); // regex

		// Pattern class contains matcher() method
		// to find matching between given number
		// and regular expression for which
		// object of Matcher class is created
		Matcher m = p.matcher(s);

		// Returning boolean value
		return (m.matches());
	}

	public static boolean isEmail(String s) {
		String regex = "^(.+)@(.+)$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);

		return (m.matches());
	}
}
