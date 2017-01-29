package com.sihle.tangent.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.sihle.tangent.bean.ProjectData;
import com.sihle.tangent.bean.Task;


@Controller
@RequestMapping("/taskdata")
public class TaskDetailsController {
	
    @RequestMapping(method = RequestMethod.GET) 
    public String init(HttpSession session, Model model){
    	Task task = (Task)session.getAttribute("task");
    	ProjectData project = task.getProject_data();
    	String status =  project.isIs_active() ? "Active": "Inactive";	
		String billable = project.isIs_billable() ? "Yes" : "No";
		project.setStatus(status);
    	project.setBillable(billable);
    	model.addAttribute("projectdata", project);
    	model.addAttribute("task", task);
    	return "taskdata";
    	
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public String finish(){
    	return "";
    }
 


}
