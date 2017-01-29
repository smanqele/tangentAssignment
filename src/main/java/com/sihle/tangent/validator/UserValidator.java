package com.sihle.tangent.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sihle.tangent.bean.User;

@Component
public class UserValidator implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {	
    	
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");  
        
        if (errors.hasErrors()){return ;}

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        
    }
}
