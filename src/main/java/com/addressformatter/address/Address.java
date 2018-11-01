package com.addressformatter.address;

import org.json.JSONException;
import org.json.JSONObject;

public class Address {

	
		private String street;
		private String housenumber;

		public Address(String street, String housenumber) {
			this.street = street;
			this.housenumber = housenumber;
		}

		public Address() {
			// default constructor
		}

		public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}

		public String getHousenumber() {
			return housenumber;
		}

		public void setHousenumber(String housenumber) {
			this.housenumber = housenumber;
		}
		
		public JSONObject toJson() throws JSONException {

	        JSONObject jo = new JSONObject();
	        jo.put("street", street);
	        jo.put("housenumber", housenumber);

	        return jo;
	    }

		@Override
		public String toString() {
			return "Address [street=" + street + ", housenumber=" + housenumber + "]";
		}
		
		
}
