package com.primesource.restapi.randomuser;

import com.primesource.restapi.model.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParseJsonRandomUser {
	public static User getRandomUser(String inline) throws ParseException, java.text.ParseException {
		User user = new User();
		// Parse the JSON data present in the string format
		JSONParser parse = new JSONParser();
		// Type caste the parsed json data in json object
		JSONObject jobj = (JSONObject) parse.parse(inline);
		// Store the JSON object in JSON array as objects (For level 1 array element i.e
		// Results)
		JSONArray jsonarr_1 = (JSONArray) jobj.get("results");
		for (int i = 0; i < jsonarr_1.size(); i++) {
			// Store the JSON objects in an array
			// Get the index of the JSON object and print the values as per the index
			JSONObject jsonobj_1 = (JSONObject) jsonarr_1.get(i);

			user.setGender((String) jsonobj_1.get("gender"));
			;
			user.setEmail((String) jsonobj_1.get("email"));
			user.setPhone((String) jsonobj_1.get("phone"));

			JSONObject location = (JSONObject) jsonobj_1.get("location");
			user.setStreet((String) location.get("street"));
			user.setCity((String) location.get("city"));
			user.setState((String) location.get("state"));
			user.setPostcode(location.get("postcode").toString());

			JSONObject login = (JSONObject) jsonobj_1.get("login");
			user.setUsername((String) login.get("username"));
			user.setPassword((String) login.get("password"));

			JSONObject registered = (JSONObject) jsonobj_1.get("registered");
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
			java.util.Date date =  dateFormat.parse(registered.get("date").toString());
			java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
			user.setRegistered(sqlDate);
		}
		return user;
	}
}
