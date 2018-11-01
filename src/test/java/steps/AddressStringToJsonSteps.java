package steps;

import static org.testng.Assert.assertEquals;


import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.http.ResponseEntity;
import com.addressformatter.util.FormatAddress;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lib.PostAddressStringToJson;

public class AddressStringToJsonSteps {
	
	private PostAddressStringToJson postAddress = new PostAddressStringToJson();
	private ResponseEntity<String> responseEntity;
	private String address;
	private JSONObject expectedJson;

	@When("^the client posts an address string \"([^\"]*)\" to the \"([^\"]*)\" resource$")
	public void the_client_posts_an_address_string_to_the_resource(String address, String endPoint) throws Throwable {
		this.address = address;
		responseEntity = postAddress.postString(this.address, endPoint);
	 
	}

	@Then("^the response code should be \"([^\"]*)\"$")
	public void the_response_code_should_be(String responseCode) throws Throwable {
		assertEquals(responseCode, responseEntity.getStatusCode().toString());
	 
	}

	@Then("^the resonse body should contain the address in JSON format$")
	public void the_resonse_body_should_contain_the_address_in_JSON_format() throws Throwable {
		 
		expectedJson = FormatAddress.matchExpression(address).toJson();
		JSONObject actualJson = new JSONObject(responseEntity.getBody());
		JSONAssert.assertEquals(expectedJson, actualJson, JSONCompareMode.LENIENT);
	 
	}	
	
	
}
