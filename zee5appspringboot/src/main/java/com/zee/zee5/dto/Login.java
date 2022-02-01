package com.zee.zee5.dto;

import lombok.Data;

@Data
public class Login {

	private String username;
	private String password;
	private String regId;
	private ROLE role;
}
