package com.sihle.tangent.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sihle.tangent.bean.Project;

import com.sihle.tangent.cache.ProjectStore;
import com.sihle.tangent.service.ProjectService;

@Controller
@RequestMapping("/projectlist")
public class ProjectListController {
	
    @Autowired
    @Qualifier("projectValidator")
    private Validator validator;
    
    
    @RequestMapping(method=RequestMethod.GET)
    public String init(HttpSession session, Model model){
    	
    	String token = (String) session.getAttribute("Token");
    	if (token != null && !token.isEmpty()){
    		token = (String) session.getAttribute("Token");
    	} else {
    		return "login";
    	}
    	
    	updateProjectStore(token);
    	model.addAttribute("project", new Project());
    	updateProjectsMap(model);
 
        return "projectlist";
    }
    
    void updateProjectsMap(Model model){
    	List<Project> projectList = ProjectStore.projects();
    	Map<Integer, String> projects = projectList.stream().collect(Collectors.toMap(Project::getPk, Project::getTitle));  	
    	model.addAttribute("projectsmap", projects);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String submit(Project project, HttpSession session, Model model, BindingResult result){
    	validator.validate(project, result);
    	if(result.hasErrors()) {
    		model.addAttribute("project", project);
    		updateProjectsMap(model);
			return "projectlist";
		} 

    	String returnVal = "redirect:/projectdetails";
    	java.util.Optional<Project> selected = ProjectStore.findProjectFromPK(project.getPk());    	
    	if (!selected.isPresent()){
    		result.rejectValue("pk", "valid.project", "Project with PK number " + project.getPk() + " no longer exists");
    		updateProjectsMap(model);
    		model.addAttribute("project", project);
    		returnVal = "projectlist";
    	} else {
    		
    		session.setAttribute("project", selected.get());
    		//model.addAttribute("task", new Task());
    	}
			
    	return returnVal;
    }
    
    
    
    private void updateProjectStore(String userToken){
    	ProjectStore.storeProjectList(ProjectService.instance().retrieveProjects(userToken));
    }


}
