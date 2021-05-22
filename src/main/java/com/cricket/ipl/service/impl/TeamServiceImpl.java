package com.cricket.ipl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cricket.domain.Match;
import com.cricket.domain.Team;
import com.cricket.ipl.service.TeamService;
import com.cricket.repository.MatchRepository;
import com.cricket.repository.TeamRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class TeamServiceImpl implements TeamService{

	@Autowired
	private TeamRepository teamRepo;
	
	@Autowired
	private MatchRepository matchRepo;
	
	@Override
	public Team getTeamInfoByTeamName(String teamName)
	{
		log.info("Request received for team name : {}", teamName);
		Team team =	teamRepo.findByTeamName(teamName);
		if (null != team)
		{
			List<Match> matchList = matchRepo.findMatchByTeamName(teamName, teamName, 4);
			if(null != matchList && !matchList.isEmpty())
			{
				team.setMatches(matchList);
			}
		}
		return team;
	}

	@Override
	public List<Team> getAllTeams() {
		return teamRepo.findAll();
	}
}
