package com.sihle.tangent.login;

public class Token {
	
	final String  token;
	final boolean valid;
	
	Token(String token){
		this.token = token;
		valid = !isEmpty(token);
	}
	
	public String token(){
		return this.token;
	}
	
	public boolean isValid() {
		return valid;
	}
	
	private boolean isEmpty(String tokenStr){
		return (tokenStr == null || tokenStr.isEmpty());
	}
	
	

}
