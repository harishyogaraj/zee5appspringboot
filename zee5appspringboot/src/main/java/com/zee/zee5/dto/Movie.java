package com.zee.zee5.dto;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zee.zee5.exeption.InvalidIdLengthException;
import com.zee.zee5.exeption.InvalidNameException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
//import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
//@EqualsAndHashCode
@ToString
@AllArgsConstructor
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "movieName")},name="movies")

public class Movie implements Comparable<Movie>{
	
	
	
	
//	public Movie(String id, String movieName,String agelimit,
//			String cast,String genere,String length,String trailer,
//			String releasedate,String language) throws InvalidIdLengthException, InvalidNameException {
//		super();
//		this.setId(id);
//		this.setMovieName(movieName);
//		this.language=language;
//		this.agelimit=agelimit;
//		this.cast=cast;
//		this.trailer=trailer;
//		this.genere=genere;
//		this.length=length;
//		this.releasedate=releasedate;
//		
//	}

public Movie() {
	// TODO Auto-generated constructor stub
}




	@Id
	@Column(name="movieid")
	private String id;
	
	@NotBlank
	private String movieName;
	
	@NotBlank
	private String language;
	
	@NotBlank
	@Max(value=70)
	private int agelimit;
	@NotBlank
	private String genere;
	@NotNull
	private BigDecimal length;
	@NotNull
	private Date releasedate;

	@NotBlank
	private String trailer;
	@NotBlank
	private String cast;
	
	
	
	
//	public void setMovieName(String movieName) throws InvalidNameException {
//		if(movieName==null || movieName=="" ||movieName.length()<2)
//		{
//			throw new InvalidNameException("Name Exception");
//		}
//			
//		this.movieName = movieName;
//	}
//	
//	
//	
//	public void setId(String id) throws InvalidIdLengthException {
//		if(id.length()>2)
//		{
//			throw new InvalidIdLengthException("id length is lesser or eqaul to 2");
//		}
//			
//		this.id = id;
//	}
//
////	public void setLanguage(String language) throws InvalidNameException {
////		if(language!="Kannada" && language!="Hindi" && language!="English")
////		{
////			throw new InvalidNameException("Name Exception!!");
////		}
////			
////		this.language = language;
////	}
//	
	@Override
	public int compareTo(Movie o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}




//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Movie other = (Movie) obj;
//		return Objects.equals(id, other.id) && Objects.equals(language, other.language)
//				&& Objects.equals(movieName, other.movieName);
//	}
//

//
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(id, language, movieName);
//	}

}
