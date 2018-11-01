Feature: A rest service that accepts a local address as a String. 
	and the response should be in JSON format


Scenario Outline: Convert the local address from String to Json
	When the client posts an address string "<address>" to the "/address" resource 
	Then the response code should be "<response_code>" 
	And the resonse body should contain the address in JSON format 
	
	Examples: 
		| address          | response_code |
		| Winterallee 3    | 200           |
		| Musterstrasse 45 | 200           |
		| Blaufeldweg 123B | 200           |
		
	
Scenario Outline: Convert a complex address from String to Json 
	When the client posts an address string "<address>" to the "/address" resource 
	Then the response code should be "<response_code>" 
	And the resonse body should contain the address in JSON format 
	
	Examples: 
		| address                 | response_code |
		| Am Bächle 23            | 200           |
		| Auf der Vogelwiese 23 b | 200           |
		| Blaufeldweg 123B        | 200           |
		
Scenario Outline: Convert an international address from String to Json 
	When the client posts an address string "<address>" to the "/address" resource 
	Then the response code should be "<response_code>" 
	And the resonse body should contain the address in JSON format 
	
	Examples: 
		| address                 | response_code |
		| 4, rue de la revolution | 200           |
		| 200 Broadway Av         | 200           |
		| Calle Aduana, 29        | 200           |		
		| Calle 39 No 1540        | 200           |