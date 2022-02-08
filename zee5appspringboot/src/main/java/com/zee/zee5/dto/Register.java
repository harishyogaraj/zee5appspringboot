package com.zee.zee5.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.zee.zee5.exeption.InvalidIdLengthException;
import com.zee.zee5.exeption.InvalidNameException;
import com.zee.zee5.utils.CustomListSerializer;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@Entity  //entity class is used for ORM
@Table(name="register") // optimizing table name
//@NoArgsConstructor
@AllArgsConstructor

public class Register  implements Comparable<Register>
{

	
	
//	public Register(String id, String firstName, String lastName, String email, String password)
//	throws InvalidNameException,InvalidIdLengthException{
//		super();
//		this.setId(id);
//		this.setFirstName(firstName);
//		this.setLastName(lastName);
//		this.setemail(email);
//		this.setpassword(password);
//	}



	public Register() {
		// TODO Auto-generated constructor stub
	}



	@Id   // it will consider this as PK
	@Column(name="regid")
	//@OneToOne(mappedBy="subscription",cascade = CascadeType.ALL)
	private String id;
	
	@Size(max=50)
	@NotBlank
	private String firstName;
	
	@Size(max=50)
	@NotBlank
	private String lastName;
	
	@Email
	@NotBlank
	private String email;
	
	@NotBlank
	@Size(max=100)
	private String password;
	
	//@NotNull
	private BigInteger contactNumber;
	
	@OneToOne(mappedBy = "register",cascade = CascadeType.ALL)
//	@JsonIgnore
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler","login"})  //alternate form of @jsonIgnore

//	@JsonSerialize(using = CustomListSerializer.class)
//	@JoinColumn(name = "regid",nullable=false,foreignKey = @ForeignKey(name="fk_logregId"))
	private Login login;
	
	
	@OneToOne(mappedBy = "register",cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler","subscription"})  //alternate form of @jsonIgnore
	private Subscription subscription;
	
//	public void setemail(String email) throws InvalidNameException {
//		if(email==null || email=="")
//		{
//			throw new InvalidNameException("email Exception");
//		}
//		this.email=email;
//	}
//	
//	public void setpassword(String password) throws InvalidNameException {
//		if(password==null || password=="")
//		{
//			throw new InvalidNameException("password Exception");
//		}
//		this.password=password;
//	}
//	
//	public void setLastName(String lastName) throws InvalidNameException {
//		if(lastName==null || lastName=="")
//		{
//			throw new InvalidNameException("lastName Exception");
//		}
//		this.lastName=lastName;
//	}
//	
//	public void setFirstName(String firstName) throws InvalidNameException {
//		if(firstName==null || firstName=="" ||firstName.length()<2)
//		{
//			throw new InvalidNameException("Name Exception");
//		}
//			
//		this.firstName = firstName;
//	}
//	
//	
//	
//	public void setId(String id) throws InvalidIdLengthException {
//		if(id.length()<6)
//		{
//			throw new InvalidIdLengthException("id length is lesser or eqaul to 6");
//		}
//			
//		this.id = id;
//	}
//
//
//
	

	@Override
	public int compareTo(Register o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}
	
	@ManyToMany
	@JoinTable(name="user_roles",joinColumns = @JoinColumn(name="regId")
	, inverseJoinColumns = @JoinColumn(name="roleId"))
	private Set<Role> roles=new HashSet<Role>();
	
	
	
}
