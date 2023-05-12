package com.authentication.dtos;

import jakarta.validation.constraints.NotBlank;

public class RoleDto {
	
	@NotBlank(message = "Name can't be blank")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
