package com.sihle.tangent.login;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class ProjectsAuthentication {
	
	public static final String REST_SERVICE_URI = "http://userservice.staging.tangentmicroservices.com/api-token-auth/";

	public static Token authenticate(String username, String password) {
		System.out.println("\nAuthenticating the user----------");
		// Create the request body as a MultiValueMap
		
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
        MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();     

        body.add("username", username);
        body.add("password", password);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, requestHeaders);
        ResponseEntity<String> response = restTemplate.exchange(REST_SERVICE_URI, HttpMethod.POST, request, String.class);
        
        return new Token(extractTokenID(response.getBody()));
     
	}
	
	private static String extractTokenID(String token){
		String tmpToken = token.substring(11, token.length() -2);
		return tmpToken;
	}

}
