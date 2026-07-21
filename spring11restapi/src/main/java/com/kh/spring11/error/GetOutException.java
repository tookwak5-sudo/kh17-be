package com.kh.spring11.error;

public class GetOutException extends RuntimeException{

	public GetOutException() {
		super();
	}

	public GetOutException(String message) {
		super(message);
	}

}
