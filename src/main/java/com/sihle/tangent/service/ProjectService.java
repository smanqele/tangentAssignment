package com.sihle.tangent.service;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.sihle.tangent.bean.ProjectData;

public class ProjectService {
	
	final static ProjectService INSTANCE = Instance.INSTANCE.SERV;
	final static String URI = "http://projectservice.staging.tangentmicroservices.com/api/v1/projects/";
	
	public static ProjectService instance(){
		return INSTANCE;
	}
	
	
	public static enum Instance{
		INSTANCE;
		
		final ProjectService SERV;
		Instance(){
			System.out.println("Creating new  ProjectService instance");
			SERV = new ProjectService();
		}
	}
	
	private HttpHeaders headers(String token){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Authorization", token);
        //headers.setAccept(java.util.Arrays.asList(MediaType.APPLICATION_JSON));
		//headers.setContentType(MediaType.APPLICATION_JSON);
		//headers.set("Authorization", token);
		headers.set("User-Agent", "Mozilla/5.0");
		headers.add("Authorization",  token);
		headers.add("Content-Type","application/json");
    	
        return headers;
	}


/*	public List<ProjectData> retrieveProjects(String token) {
		System.out.println("\nIn ProjectService.retrieveProjects()----------");
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> request = new HttpEntity<String>(headers(token));
        ResponseEntity<String> response = restTemplate.exchange(URI, HttpMethod.GET, request, String.class);
        //String resp = restTemplate.postForObject(URI, request, String.class);
        System.out.println(response.getBody());
        //System.out.println(resp);
		return new java.util.ArrayList<>();
	}*/
	
	public List<ProjectData> retrieveProjects(String token) {
		System.out.println("\nIn ProjectService.retrieveProjects()----------");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String[]> response = restTemplate.exchange(URI, HttpMethod.GET, httpEntity(token), String[].class);
        //String resp = restTemplate.postForObject(URI, request, String.class);
        System.out.println(response.getBody());
        //System.out.println(resp);
		return new java.util.ArrayList<>();
	}
	
	private HttpEntity<MultiValueMap<String, String>>  httpEntity(String token){
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
        MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();     
        body.add("User-Agent", "Mozilla/5.0");
        body.add("Authorization",  token);;
        body.add("Content-Type","application/json");

        return new HttpEntity<>(body, requestHeaders);
	}

}
