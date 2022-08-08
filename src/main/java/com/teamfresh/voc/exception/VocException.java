package com.teamfresh.voc.exception;

public class VocException extends RuntimeException{
	public VocException(String message) {
		super(message);
	}

	public VocException(String message, Throwable cause) {
		super(message, cause);
	}

	public VocException() {

	}
}
