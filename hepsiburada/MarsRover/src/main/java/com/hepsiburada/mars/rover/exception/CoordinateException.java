package com.hepsiburada.mars.rover.exception;

/**
 * Created by Ilay.Ilter on 19/02/2022
 */
public class CoordinateException extends RuntimeException {

	public CoordinateException(String message) {
		super(message);
	}

	public CoordinateException(String message, Throwable cause) {
		super(message, cause);
	}
}
