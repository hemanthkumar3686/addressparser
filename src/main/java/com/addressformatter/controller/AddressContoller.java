package com.addressformatter.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.addressformatter.address.Address;
import com.addressformatter.service.ParseAddress;

@RestController
public class AddressContoller {
	
	@Autowired
	private ParseAddress parseAddress = new ParseAddress();

	@PostMapping(value = "/address",
		    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Address getAddressObj(@RequestBody String address) {
		Address formattedAddress = parseAddress.formatAddress(address);
		return formattedAddress;
	}
}
