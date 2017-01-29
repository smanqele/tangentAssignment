package com.sihle.tangent.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sihle.tangent.bean.Project;

public class ProjectValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Project.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (target instanceof Project){
			if (!isPKNumberSelected((Project)target)){
				errors.rejectValue("pk", "valid.project");
			}
		}
		
	}
	
	private boolean isPKNumberSelected(Project project){
		return project.getPk() != 0;
	}

}
