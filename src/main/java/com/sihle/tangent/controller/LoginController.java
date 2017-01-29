package com.sihle.tangent.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sihle.tangent.bean.User;
import com.sihle.tangent.service.SecurityService;


@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private SecurityService securityService;

    @Autowired
    @Qualifier("userValidator")
    private Validator userValidator;
    

    
    @RequestMapping(method=RequestMethod.GET)
    public String displayLogin(@ModelAttribute("userForm") User userForm, Model model, String error){
        if (error != null) {
            model.addAttribute("error", error);
        }
        return "login";
    }



    @RequestMapping(method = RequestMethod.POST)
    public String submit(@ModelAttribute("userForm") User userForm, HttpSession session, BindingResult bindingResult, Model model, String error, String logout) {
    	
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
        	error = bindingResult.getAllErrors().get(0).getDefaultMessage();
        	model.addAttribute("error", "Invalid username or password");
            return "login";
        }
        
        securityService.login(userForm.getUsername(), userForm.getPassword());
        String token = securityService.findLoggedInToken();
        if (token == null){
        	model.addAttribute("error", "Invalid username or password");
        	return "login";
        }
        session.setAttribute("Token", token);

        return "redirect:/projectlist";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }

}
