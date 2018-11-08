package com.danilovalerio.projmongo.services.exception;

public class ObjectNotFoundException extends RuntimeException { //RuntimeException não exige o tratamento

	private static final long serialVersionUID = 1L;
	
	//Sobrecarregar passando msg
	public ObjectNotFoundException(String msg) {
		super(msg);
	}

}
