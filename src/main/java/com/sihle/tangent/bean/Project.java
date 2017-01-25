package com.sihle.tangent.bean;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Project extends BaseProject {
	
	private Set<Task> task_set = null;

	public Set<Task> getTask_set() {
		return task_set;
	}

	public void setTask_set(Set<Task> task_set) {
		this.task_set = task_set;
	}
	

	
	
	

}
