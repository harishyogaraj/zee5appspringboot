package com.zee.zee5.dto;


import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zee.zee5.exeption.InvalidAmountException;
import com.zee.zee5.exeption.InvalidIdLengthException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@EqualsAndHashCode
@ToString
@Entity
@AllArgsConstructor
@Table(name="subscription")
public class Subscription {

	public Subscription() {
		// TODO Auto-generated constructor stub
	}
	
	@NotBlank
	private String regid;
	

	@NotNull
	private int amount;
	
	@NotBlank
	private String type;
	
	@NotNull
	private Date dateofPurchase;
	
	@NotBlank
	private String status;
	
	@NotBlank
	private String paymentMode;
	
	@NotBlank
	private String autoRenewal;
	
	@NotNull
	private Date expiryDate;
	
	@Id
	@Column(name="subscriptionid")
	private String subscriptionid;
	
	
	public void setregId(String regid) throws InvalidIdLengthException {
		if(regid.length()<6)
		{
			throw new InvalidIdLengthException("id length is lesser or eqaul to 6");
		}
			
		this.regid = regid;
	}
	
	public void setAmount(int amount) throws InvalidAmountException {
		if(amount<1000)
		{
			throw new InvalidAmountException("Amount is not less than 1000");
		}
		this.amount=amount;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subscription other = (Subscription) obj;
		return amount == other.amount && autoRenewal == other.autoRenewal
				&& Objects.equals(dateofPurchase, other.dateofPurchase) && Objects.equals(expiryDate, other.expiryDate)
				&& Objects.equals(regid, other.regid) && Objects.equals(paymentMode, other.paymentMode)
				&& Objects.equals(status, other.status) && Objects.equals(type, other.type);
	}
	@Override
	public int hashCode() {
		return Objects.hash(amount, autoRenewal, dateofPurchase, expiryDate, regid, paymentMode, status, type);
	}

//	public Subscription(String id, int amount, String type, Date dateofPurchase, String status, String paymentMode,
//			String autoRenewal, Date expiryDate,String regid) throws InvalidIdLengthException,InvalidAmountException {
//		super();
//		this.setregId(id);
//		this.setAmount(amount);
//		this.type = type;
//		this.dateofPurchase = dateofPurchase;
//		this.status = status;
//		this.paymentMode = paymentMode;
//		this.autoRenewal = autoRenewal;
//		this.expiryDate = expiryDate;
//		this.regid=regid;
//	}
	
	
	
}
