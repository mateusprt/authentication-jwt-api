package com.authentication.exceptions;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ExceptionResponse implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	private Date timestamp;
	private List<String> message;
	private String details;
	
	public ExceptionResponse(Date timestamp, List<String> message, String details) {
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public List<String> getMessage() {
		return message;
	}

	public void setMessage(List<String> message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
