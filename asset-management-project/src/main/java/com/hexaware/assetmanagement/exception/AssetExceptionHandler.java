package com.hexaware.assetmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AssetExceptionHandler {
	

	@ExceptionHandler({AssetNotFoundException.class})
	public ResponseEntity<String> handleExp1(AssetNotFoundException e) {
		
		return new ResponseEntity<String>(e.toString(),HttpStatus.NOT_ACCEPTABLE);
	}
	
	
	
	
}