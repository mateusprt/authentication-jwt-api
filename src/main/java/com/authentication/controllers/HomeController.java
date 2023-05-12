package com.authentication.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authentication.dtos.ResponseRequestDto;

@RestController
@RequestMapping("/api/v1/home")
public class HomeController {
	
	@GetMapping("/index")
	public ResponseEntity<ResponseRequestDto> home() {
		return ResponseEntity.ok(new ResponseRequestDto("Hello from secured route"));
	}

}
