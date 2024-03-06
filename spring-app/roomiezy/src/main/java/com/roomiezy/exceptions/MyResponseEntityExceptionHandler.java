package com.roomiezy.exceptions;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class MyResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest req){
		ExceptionResponse expResp = new ExceptionResponse(
				ex.getMessage(), "Detailed Description of message", new Date());
		return new ResponseEntity<Object>(expResp, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex,WebRequest req) {
		ExceptionResponse expResp = new ExceptionResponse(
				ex.getMessage(), "Requested User is Not found", new Date());
		return new ResponseEntity<Object>(expResp, HttpStatus.NOT_FOUND);
	}
	
}