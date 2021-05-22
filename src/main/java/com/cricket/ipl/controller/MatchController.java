package com.cricket.ipl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cricket.domain.Match;
import com.cricket.ipl.service.MatchService;

@RestController
@CrossOrigin
public class MatchController {

	@Autowired
	public MatchService matchService;
	
	@GetMapping("team/{teamName}/matches")
	public List<Match> getMatchInfoForYear(@PathVariable("teamName") String teamName, @RequestParam("year") String year)
	{
		return matchService.getMatchInfoByTeamNameAndYear(teamName, year);
	}
}
