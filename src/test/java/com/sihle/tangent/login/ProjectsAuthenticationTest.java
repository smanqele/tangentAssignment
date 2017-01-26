package com.sihle.tangent.login;

import static org.junit.Assert.*;
import org.junit.Test;

public class ProjectsAuthenticationTest {
		
	@Test
	public void whenAccessingTokenURIGetToken(){
		String token = ProjectsAuthentication.authenticate("admin1", "admin1").token();
		Log(token);
		assertFalse("Token must not be empty", token==null || token.isEmpty());
	}
	
	static void Log(Object object){
		System.out.println(object==null ? "Empty object" : object);
	}
	

}
