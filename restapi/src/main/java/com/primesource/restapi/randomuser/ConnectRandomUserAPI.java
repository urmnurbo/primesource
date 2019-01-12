package com.primesource.restapi.randomuser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectRandomUserAPI {
	public static URL Connect(URL url) throws IOException {

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		int responsecode = conn.getResponseCode();
		if(responsecode != 200) {
			Connect(url);
		}
		return url;
	}

}
