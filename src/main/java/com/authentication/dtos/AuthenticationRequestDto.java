package com.authentication.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class AuthenticationRequestDto {
	
	@Email
	@NotEmpty(message = "Email can't be blank")
	private String email;
	
	@NotEmpty(message = "Password can't be blank")
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
