package com.cricket.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Team")
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String teamName;
	private Long totalMatches;
	private Long totalWins;
	@Transient
	private List<Match> matches;
	  
	
	public Team(String teamName, Long totalMatches)
	{
		this.teamName = teamName;
		this.totalMatches = totalMatches;
	}
	
}
