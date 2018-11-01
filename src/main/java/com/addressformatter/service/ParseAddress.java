package com.addressformatter.service;
import org.springframework.stereotype.Component;
import com.addressformatter.address.Address;
import com.addressformatter.util.FormatAddress;

@Component
public class ParseAddress {
	
	static Address addressObject = new Address();

	public Address formatAddress(String addressString) {
		
		addressObject = FormatAddress.matchExpression(addressString);
		
		return addressObject;
		
		
	}
}
