package org.openmrs.module.labtest.util;

import org.apache.commons.codec.binary.Base64;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {
	
	public String encryptBASE64(String username, String password) {
		byte[] key = (username + ":" + password).getBytes();
		return new String(Base64.encodeBase64(key));
	}
	
	public String getJson(String url) throws IOException {
		URL url2 = new URL(url);
		String username = "admin";
		String password = "Jyl13621972129";
		String authorization = "Basic " + (encryptBASE64(username, password));
		HttpURLConnection httpConnection = (HttpURLConnection) url2.openConnection();
		httpConnection.setConnectTimeout(5000);
		httpConnection.setRequestMethod("GET");
		httpConnection.setRequestProperty("Accept", "application/json");
		httpConnection.setRequestProperty("authorization", authorization);
		httpConnection.connect();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
		String line = null;
		StringBuffer stringBuffer = new StringBuffer();
		while ((line = bufferedReader.readLine()) != null) {
			line = new String(line.getBytes("UTF-8"));
			stringBuffer.append(line);
		}
		bufferedReader.close();
		httpConnection.disconnect();
		
		return stringBuffer.toString();
	}
}
