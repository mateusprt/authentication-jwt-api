package com.authentication.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class RegistrationRequestDto {
	
	@Email
	@NotEmpty(message = "Email can't be blank")
	private String email;
	
	@NotEmpty(message = "Password can't be blank")
	private String password;
	
	@JsonProperty("password_confirmation")
	@NotEmpty(message = "Password confirmation can't be blank")
	private String passwordConfirmation;
	
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
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}
	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}
	
	

}
