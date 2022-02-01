package com.zee.zee5.exeption;

import lombok.ToString;

@ToString(callSuper=true)
public class InvalidIdLengthException extends Exception {

	public InvalidIdLengthException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
