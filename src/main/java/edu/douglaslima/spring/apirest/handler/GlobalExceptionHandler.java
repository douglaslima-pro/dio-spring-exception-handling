package edu.douglaslima.spring.apirest.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	private HttpHeaders headers() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}
	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<Object> handleBusinessException(BusinessException exception, WebRequest request) {
		ResponseError response = new ResponseError(HttpStatus.CONFLICT.value(), exception.getMessage());
		return super.handleExceptionInternal(exception, response, headers(), HttpStatus.CONFLICT, request);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException exception, WebRequest request) {
		ResponseError response = new ResponseError(HttpStatus.NOT_FOUND.value(), exception.getMessage());
		return super.handleExceptionInternal(exception, response, this.headers(), HttpStatus.NOT_FOUND, request);
	}

}
