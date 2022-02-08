package com.zee.zee5.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.zee.zee5.utils.CustomListSerializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@AllArgsConstructor
@ToString
@Table(name="login")
public class Login implements Comparable<Login>{
	
	public Login() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name="username")
	@NotBlank
	private String username;
	@NotBlank
	private String password;
//	@NotBlank
//	private String regId;
	
	@OneToOne(fetch = FetchType.LAZY)
//	@JsonSerialize(using = CustomListSerializer.class)
	@JoinColumn(name = "regid",nullable=false,foreignKey = @ForeignKey(name="fk_logregId"))
	@JsonProperty(access = Access.WRITE_ONLY)
	
	private Register register;
//	private ROLE role;

	@Override
	public int compareTo(Login o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
