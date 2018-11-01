package com.addressformatter.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateAddress {

	public static final String STRING_STARTING_WITH_NON_NUMERICS = "^[^0-9]+";
	public static final String ALPHANUMERIC_SUBSTRING_STARTING_WITH_NUMBERS = "\\s(\\d{1}|\\d{2}|\\d{3})\\s?\\D?$";
	public static final String STRING_START_WITH_NUMBERS = "^[0-9]+\\s";
	public static final String SUBSTRING_START_WITH_ALPHABETS_END_WITH_NUMBERS = "\\s\\D+\\s[0-9]+"; //\\s?\\w+\\s?[0-9]+
	public static final String SUBSTRING_WITH_ALPHABETS = "\\s?[^0-9]+";
	public static final String ALPHANUMERICS_FIRST_STRING = "^(\\w+\\s\\d+)";
	
	private static Pattern pattern;
	private static Matcher match;
	
	public static Matcher getMatcher(String regexp, String address) {
		pattern = Pattern.compile(regexp);
		match = pattern.matcher(address);
		
		return match;
	}
	
	public static String cleanAddress(String address) {
		if(address.contains(",")) {
			address = address.replace(",", "");
			return address;
		}
		
		return address;
	}
	
	
}
