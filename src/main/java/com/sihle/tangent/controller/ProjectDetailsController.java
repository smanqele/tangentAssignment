package com.sihle.tangent.controller;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sihle.tangent.bean.Project;
import com.sihle.tangent.bean.Task;

@Controller
@RequestMapping("/projectdetails")
public class ProjectDetailsController {
	
    @Autowired
    @Qualifier("taskValidator")
    private Validator taskValidator;
   
    
	
    @RequestMapping(method = RequestMethod.GET) 
    public String init(@ModelAttribute("task")Task task,  HttpSession session, Model model){
    	Project project = (Project)session.getAttribute("project");
    	String status =  project.isIs_active() ? "Active": "Inactive";	
		String billable = project.isIs_billable() ? "Yes" : "No";
    	project.setStatus(status);
    	project.setBillable(billable);
    	model.addAttribute("projectdata" , project);	

    	Map<Integer, String> tasks = project.getTask_set().stream().collect(Collectors.toMap(Task::getId, Task::getTitle));	
    	model.addAttribute("taskmap", tasks);
    	
    	return "projectdetails";
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public String submit( @Validated Task task, HttpSession session, Model model,  BindingResult errors){
    	Project project = (Project)session.getAttribute("project");
    	taskValidator.validate(task, errors);
    	if(errors.hasErrors()) {
    		model.addAttribute("error", "Invalid task selectiond");
			return "projectdetails";
		}
    	Optional<Task> tmpTask = project.getTask_set().stream().filter(t -> t.getId() == task.getId()).findFirst();
    	if (tmpTask.isPresent()){
    		session.setAttribute("task", tmpTask.get());
    	}
    	
    	return "redirect:/taskdata";
    }
    
    

}
