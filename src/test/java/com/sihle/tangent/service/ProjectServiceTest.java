package com.sihle.tangent.service;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.sihle.tangent.login.ProjectsAuthentication;

public class ProjectServiceTest {
	
	@Rule public ExpectedException thrown= ExpectedException.none();
	
	@Test
	public void givenProjectServiceMustUseSingleInstance(){
		ServiceInstance t1 = new ServiceInstance();
		ServiceInstance t2 = new ServiceInstance();
		ServiceInstance t3 = new ServiceInstance();		
	
		assertTrue("Objects should point to same instance" , t1.service() == t2.service());
		assertTrue("Objects should point to same instance" , t2.service() == t3.service());
	}
	
/*	@Test
	public void givenUnAuthenticatedUserShouldThrowExceptionl(){
		ProjectService service = ProjectService.instance();
		thrown.expect( Exception.class );
	    thrown.expectMessage("403 FORBIDDEN");
		service.retrieveProjects("");
	}*/
	
	@Test
	public void givenAuthenticatedUserShouldPassProjectRetrieval(){
		String token = new ProjectsAuthentication().authenticate("admin1", "admin1").token();	
		ProjectService service = ProjectService.instance();
		assertFalse("List of ProjectData must be created",service.retrieveProjects(token)==null);
		
	}
	
	static class ServiceInstance {
		
		private final ProjectService service;
	
		public ServiceInstance() {
			service = ProjectService.instance();	
		}
		
		ProjectService service(){
			return this.service;
		}
		
	}
	

}
