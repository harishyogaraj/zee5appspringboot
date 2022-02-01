package com.zee.zee5.exeption;

import lombok.ToString;

@ToString(callSuper = true)
public class IdNotFound extends Exception {

	public IdNotFound(String msg) {
		super(msg);
	}
}
