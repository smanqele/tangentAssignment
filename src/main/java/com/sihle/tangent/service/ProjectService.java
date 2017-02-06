package com.sihle.tangent.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.sihle.tangent.bean.Project;

public class ProjectService {
	
	final static ProjectService INSTANCE = Instance.INSTANCE.SERV;
	final static String URI = "URI for a resource";
	
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
		headers.add("Authorization",  token);
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(java.util.Collections.singletonList(new MediaType("application","json")));
        return headers;
	}


	public List<Project> retrieveProjects(String token) {
		System.out.println("\nIn ProjectService.retrieveProjects()----------");
		System.out.println("Token used is - " + token);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> request = new HttpEntity<String>(headers(token));
        java.util.List<HttpMessageConverter<?>> messageConverters = new java.util.ArrayList<>();
        MappingJackson2HttpMessageConverter map = new MappingJackson2HttpMessageConverter();
        messageConverters.add(map);
        restTemplate.setMessageConverters(messageConverters);

        ResponseEntity<List<Project>> response = restTemplate.exchange(URI, HttpMethod.GET, request, new ParameterizedTypeReference<List<Project>>() { });
        System.out.println(response.getBody());
		return response.getBody();
	}
	
	


}
