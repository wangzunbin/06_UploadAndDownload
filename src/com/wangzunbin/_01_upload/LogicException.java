package com.wangzunbin._01_upload;

public class LogicException extends Exception {

	private static final long serialVersionUID = -5336891331464554049L;

	public LogicException() {
		super();
		
	}

	public LogicException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public LogicException(String message, Throwable cause) {
		super(message, cause);
	}

	public LogicException(String message) {
		super(message);
	}

	public LogicException(Throwable cause) {
		super(cause);
	}

}
