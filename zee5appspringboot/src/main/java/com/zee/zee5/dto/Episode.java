package com.zee.zee5.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zee.zee5.exeption.InvalidIdLengthException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@NoArgsConstructor
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "episodeName")}, name = "episodes")
public class Episode implements Comparable<Episode>{

	@Id
	@Column(name="epiId")
	private String epiId;


	
	private String episodeName;

	private int length;

	private String location;

	private String trailer;
	



	@ManyToOne
	@JoinColumn(name="seriesid")
	private Series series;




	@Override
	public int compareTo(Episode o) {
		// TODO Auto-generated method stub
		return this.epiId.compareTo(o.getEpiId());
	}
}
