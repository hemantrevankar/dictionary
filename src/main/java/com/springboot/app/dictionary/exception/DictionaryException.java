package com.springboot.app.dictionary.exception;

public class DictionaryException extends Exception {

	private static final long serialVersionUID = 4703050869557136965L;

	public DictionaryException() {
		super();
	}

	public DictionaryException(String message, Throwable cause) {
		super(message, cause);
	}

	public DictionaryException(String message) {
		super(message);
	}

	public DictionaryException(Throwable cause) {
		super(cause);
	}

}
