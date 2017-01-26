package com.sihle.tangent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sihle.tangent.bean.User;
import com.sihle.tangent.service.SecurityService;
import com.sihle.tangent.validator.UserValidator;

@Controller
public class ApplicationController {

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    
    @RequestMapping(value="/login",method=RequestMethod.GET)
    public String displayLogin(@ModelAttribute("userForm") User userForm){
        return "login";
    }



    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model, String error, String logout) {
    	
        if (error != null) {
            model.addAttribute("error", "Your username and password is invalid.");
            return "login";
        }

        if (logout != null) {
            model.addAttribute("message", "You have been logged out successfully.");
            return "login";
        }
        
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "login";
        }
        
        securityService.login(userForm.getUsername(), userForm.getPassword());
        
        if (securityService.findLoggedInToken() == null){
        	return "login";
        }

        return "redirect:/welcome";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }

}
