package com.sihle.tangent.cache;

import java.util.List;
import java.util.Optional;


import com.sihle.tangent.bean.Project;
import com.sihle.tangent.bean.Task;

/**
 * Used as a temporary in-memory storage for projects
 * Shared among sessions but has the benefit of being up-to-date
 * @author sihle
 *
 */
public class ProjectStore {
	
	static List<Project> STORE = null;

	public static void storeProjectList(List<Project> projects){
		STORE = projects;
	}
	
	public static List<Project> projects(){
		return STORE;
	}
	
	public static Optional<Project> findProjectFromPK(int pk){
		return STORE.stream().filter(p -> p.getPk() == pk).findFirst();
	}
	
	public static Optional<Task> findTaskFromID(Project project, int id){
		Optional<Project> proj = findProjectFromPK(project.getPk());
		
		if (proj.isPresent())
		    return project.getTask_set().stream().filter(t -> t.getId() == id).findFirst();
		
		return Optional.empty();
	}
	

}
