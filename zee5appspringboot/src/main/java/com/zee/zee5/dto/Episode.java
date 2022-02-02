package com.zee.zee5.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zee.zee5.exeption.InvalidIdLengthException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@NoArgsConstructor
@Setter
@ToString
@AllArgsConstructor
@Table(name="episodeName")
public class Episode implements Comparable<Episode>{

	@Id
	@Column(name="epiID")
	private String epiId;

	@NotBlank
	private String serialId;

	@NotBlank
	private String episodename;
	@NotNull
	private int length;
	@NotBlank
	private String location;
	@NotBlank
	private String trailer;
	@Override
	
	public int compareTo(Episode o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
