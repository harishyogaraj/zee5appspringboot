package com.zee.zee5.dto;


import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@Data
@Entity
//@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "seriesname")},name="series")
@Table(name="series")
public class Series implements Comparable<Series> {


	
	//@Setter(value=AccessLevel.NONE)
//	@NotBlank
//	@UniqueConstraint
	private String seriesName;
	
	
	//@Setter(value=AccessLevel.NONE)
//	@NotBlank
	private String language;
	
	@Id
	@Column(name="seriesid")
	private String seriesid;
	
//	@NotNull
	@Max(value=70)
	private int agelimit;
//	@NotBlank
	private String cast;
//	@NotBlank
	private String genere;	
	
//	@NotNull
	@Min(value=1)
	private int noOfEpisodes;
//	@NotBlank
	private String trailer;
//	@NotNull
	private Date releasedate;

	
	@OneToMany(mappedBy="series",cascade = CascadeType.ALL)
	private List<Episode> episodes=new ArrayList<Episode>();	
	
//	public Series(String seriesName, String language, String seriesid,
//			String releasedate,String agelimit,String cast,String genere,
//			String length, String noofepisodes) throws InvalidIdLengthException, InvalidNameException {
//		super();
//		this.setSeriesName(seriesName);
//		this.language=language;
//		this.setSeriesId(seriesid);
//		this.agelimit=agelimit;
//		this.releasedate=releasedate;
//		this.cast=cast;
//		this.genere=genere;
//		this.length=length;
//		this.noofepisodes=noofepisodes;
//		
//	}
//
//	public void setSeriesId(String id) throws InvalidIdLengthException {
//		// TODO Auto-generated method stub
//		if(id.length()>2)
//		{
//			throw new InvalidIdLengthException("id length is lesser or eqaul to 2");
//		}
//			
//		this.seriesid = id;
//	}
//
////	public void setLanguage(String language) throws InvalidNameException {
////		// TODO Auto-generated method stub
////		if(language!="Kannada" && language!="Hindi" && language!="English")
////		{
////			throw new InvalidNameException("Name Exception");
////		}
////			
////		this.language = language;
////		
////	}
//
//	public void setSeriesName(String seriesName2) throws InvalidNameException {
//		// TODO Auto-generated method stub
//		if(seriesName2==null || seriesName2=="" ||seriesName2.length()<6)
//		{
//			throw new InvalidNameException("Name Exception");
//		}
//			
//		this.seriesName = seriesName2;
//
//		
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Series other = (Series) obj;
//		return Objects.equals(seriesid, other.seriesid) && Objects.equals(language, other.language)
//				&& Objects.equals(seriesName, other.seriesName);
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(seriesid, language, seriesName);
//	}
	
public Series() {
	
}


	

//public Series( String seriesName,  String language, String seriesid, int agelimit,
//		String cast, String genere,  int noOfEpisodes, String trailer,
//		 Date releasedate, List<Episode> episodes) {
//	super();
//	this.seriesName = seriesName;
//	this.language = language;
//	this.seriesid = seriesid;
//	this.agelimit = agelimit;
//	this.cast = cast;
//	this.genere = genere;
//	this.noOfEpisodes = noOfEpisodes;
//	this.trailer = trailer;
//	this.releasedate = releasedate;
//	this.episodes = episodes;
//}

@Override
public int compareTo(Series o) {
	// TODO Auto-generated method stub
	return this.seriesid.compareTo(o.getSeriesid());
}

	
}
