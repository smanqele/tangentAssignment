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
	

	public boolean equals(Object proj){
		if (proj != null && proj instanceof Project){
			return (this.getPk() == ((Project)proj).getPk() &&
					this.getTitle().equals(((Project)proj).getTitle() ));		
		}
		return false;
	}



}
