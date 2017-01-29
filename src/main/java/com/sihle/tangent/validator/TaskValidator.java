package com.sihle.tangent.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sihle.tangent.bean.Task;

public class TaskValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Task.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (target instanceof Task){
			if (!isIDNumberSelected((Task)target)){
				errors.rejectValue("id", "valid.task");
			}
		}
		
	}
	
	private boolean isIDNumberSelected(Task task){
		return task.getId() != 0;
	}


}
