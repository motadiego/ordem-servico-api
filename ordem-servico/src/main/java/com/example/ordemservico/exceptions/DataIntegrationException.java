package com.example.ordemservico.exceptions;

public class DataIntegrationException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DataIntegrationException(String msg) {
		super(msg);
	}
}
