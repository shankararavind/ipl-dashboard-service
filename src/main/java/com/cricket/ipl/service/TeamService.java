package com.cricket.ipl.service;

import java.util.List;

import com.cricket.domain.Team;

public interface TeamService {

	
	public Team getTeamInfoByTeamName(String teamName);

	public List<Team> getAllTeams();
}
