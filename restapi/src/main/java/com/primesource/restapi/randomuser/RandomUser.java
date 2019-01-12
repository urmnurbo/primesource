package com.primesource.restapi.randomuser;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

import com.primesource.restapi.model.User;

public class RandomUser {

	public User getUser() throws IOException, ParseException, java.text.ParseException{
		URL url = new URL("https://randomuser.me/api/");
		url = ConnectRandomUserAPI.Connect(url);

		Scanner sc = new Scanner(url.openStream());
		String inline = "";
		while (sc.hasNext()) {
			inline += sc.nextLine();
		}
		sc.close();
		
		return ParseJsonRandomUser.getRandomUser(inline);
	}
}
