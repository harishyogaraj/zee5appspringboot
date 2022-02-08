package com.zee.zee5.exeption;

import lombok.ToString;

@ToString(callSuper = true)
public class AlreadyExistsException extends Exception {
	public AlreadyExistsException(String message) {
		super(message);
	}
}

