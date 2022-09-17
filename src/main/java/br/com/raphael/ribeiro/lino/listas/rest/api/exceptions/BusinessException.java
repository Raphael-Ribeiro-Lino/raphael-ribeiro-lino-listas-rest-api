package br.com.raphael.ribeiro.lino.listas.rest.api.exceptions;

public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public BusinessException(String message) {
		super(message);
	}
}
