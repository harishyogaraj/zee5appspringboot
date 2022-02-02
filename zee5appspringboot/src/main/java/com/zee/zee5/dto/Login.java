package com.zee.zee5.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
@Table(name="login")
public class Login {

	@Id
	@Column(name="username")
	@NotBlank
	private String username;
	@NotBlank
	private String password;
	@NotBlank
	private String regId;
	@NotBlank
	private ROLE role;
}
