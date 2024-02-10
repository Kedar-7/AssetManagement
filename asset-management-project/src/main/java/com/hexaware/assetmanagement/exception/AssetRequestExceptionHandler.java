package com.hexaware.assetmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AssetRequestExceptionHandler {

	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason ="The request which you are searching is not available in the Database")
	@ExceptionHandler({AssetRequestNotFoundException.class})
	public void handler() {
		
	}
}
