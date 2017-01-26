package com.sihle.tangent.bean;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sihle.tangent.login.Token;

public class ProjectUserDetails implements UserDetails {
	
	private final Token token;
	private final String userName;
	private final String password;
	
	public ProjectUserDetails(Token token, String userName, String password){
		this.token = token;
		this.userName = userName;
		this.password = password;
				
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6470258663708241142L;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		return token.isValid();
	}

}
