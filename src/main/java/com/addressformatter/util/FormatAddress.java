package com.addressformatter.util;

import java.util.regex.Matcher;

import com.addressformatter.address.Address;

public class FormatAddress extends ValidateAddress {
	private static Matcher matchOne;
	private static Matcher matchTwo;

	public static Address matchExpression(String address) {
		
		address = cleanAddress(address);

		matchOne = getMatcher(STRING_STARTING_WITH_NON_NUMERICS, address);
		matchTwo = getMatcher(ALPHANUMERIC_SUBSTRING_STARTING_WITH_NUMBERS, address);
		
		if(matchOne.find() && matchTwo.find()) {
//			System.out.println("Simple matching taking place");
			return new Address(matchOne.group(0).trim(), matchTwo.group(0).trim());
		}
		
		matchOne = getMatcher(ALPHANUMERICS_FIRST_STRING, address);
		matchTwo = getMatcher(SUBSTRING_START_WITH_ALPHABETS_END_WITH_NUMBERS, address);
		if(matchOne.find()&&matchTwo.find()) {
//			System.out.println("Complex matching taking place");
			return new Address(matchOne.group(0).trim(), matchTwo.group(0).trim());
		}
		
		matchOne = getMatcher(STRING_START_WITH_NUMBERS, address);
		matchTwo = getMatcher(SUBSTRING_WITH_ALPHABETS, address);
		if(matchOne.find()&&matchTwo.find()) {
//			System.out.println("International matching taking place");
			return new Address(matchTwo.group(0).trim(), matchOne.group(0).trim());
		}		
		
		
		throw new RuntimeException();	
	}
	
	

}
