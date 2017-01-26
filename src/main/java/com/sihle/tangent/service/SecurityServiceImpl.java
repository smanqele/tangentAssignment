package com.sihle.tangent.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.sihle.tangent.bean.ProjectUserDetails;
import com.sihle.tangent.login.ProjectsAuthentication;
import com.sihle.tangent.login.Token;

@Service
public class SecurityServiceImpl implements SecurityService {

    
    private static final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);

	@Override
	public String findLoggedInToken() {
		Object token = SecurityContextHolder.getContext().getAuthentication().getDetails();
		if (token != null && token instanceof Token){
			return ((Token) token).token();
		}
		return null;
	}

	@Override
	public void login(String username, String password) {
		Token token = ProjectsAuthentication.authenticate(username, password);
        UserDetails userDetails = new ProjectUserDetails(token, username, password);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

        usernamePasswordAuthenticationToken.setDetails(token);

        if (token.isValid()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            logger.debug(String.format("Auto login %s successfully!", username));
        }
    }

	

}
