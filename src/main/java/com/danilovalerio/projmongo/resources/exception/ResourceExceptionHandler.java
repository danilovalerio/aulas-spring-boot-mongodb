package com.danilovalerio.projmongo.resources.exception;
/*
 * Classe que manipula as exceptions de resources
 */

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.danilovalerio.projmongo.services.exception.ObjectNotFoundException;

@ControllerAdvice //trata possíveis erros nas requisições
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class) //Quando ocorrer essa exception o tratamento é o abaixo
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, 
						HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(
				System.currentTimeMillis(), 
				status.value(), 
				"Não encontrado", 
				e.getMessage(), 
				request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
		
	}
	

}
