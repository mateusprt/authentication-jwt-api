package com.authentication.exceptions.handlers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.authentication.exceptions.ExceptionResponse;
import com.authentication.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> handleAllExecptions(Exception e, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), List.of("INTERNAL SERVER ERROR"), request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<ExceptionResponse> handlePasswordDoesntMatchExecptions(BadCredentialsException e, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), List.of(e.getMessage()), request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleResourceNotFoundExecptions(ResourceNotFoundException e, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), List.of(e.getMessage()), request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionResponse> handleMethodArgumentNotValid (MethodArgumentNotValidException e, WebRequest request) {
		List<String> listOfErrorsMessages = new ArrayList<>();
		e.getBindingResult().getAllErrors().forEach((error) -> {
	        String errorMessage = error.getDefaultMessage();
	        listOfErrorsMessages.add(errorMessage);
		});
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), listOfErrorsMessages, request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<ExceptionResponse> handleResourceNotFoundExecptions(AccessDeniedException e, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), List.of(e.getMessage()), request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.UNAUTHORIZED);
	}

}
