package com.hepsiburada.mars.rover.exception;

/**
 * Created by Ilay.Ilter on 19/02/2022
 */
public class InputException extends RuntimeException {

	public InputException(String message) {
		super(message);
	}

	public InputException(String message, Throwable cause) {
		super(message, cause);
	}
}
