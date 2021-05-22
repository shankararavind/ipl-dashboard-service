package com.cricket.ipl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cricket.domain.Team;
import com.cricket.ipl.service.TeamService;

@RestController
@CrossOrigin
public class TeamController {

	@Autowired
	public TeamService teamService;
	
	@GetMapping("team/{teamName}")
	public Team getTeamInfo(@PathVariable("teamName") String teamName)
	{
		return teamService.getTeamInfoByTeamName(teamName);
	}
	
	@GetMapping("/team")
	public List<Team> getAllTeams()
	{
		return teamService.getAllTeams();
	}
	
}
