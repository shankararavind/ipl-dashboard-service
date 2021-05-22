package com.cricket.ipl.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cricket.domain.Match;
import com.cricket.ipl.service.MatchService;
import com.cricket.repository.MatchRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class MatchServiceImpl implements MatchService{

//	@Autowired
//	private TeamRepository teamRepo;
	
	@Autowired
	private MatchRepository matchRepo;
	
	@Override
	public List<Match> getMatchInfoByTeamNameAndYear(String teamName, String year)
	{
		log.info("Request received for team name : {}", teamName);
		LocalDate startDate = LocalDate.of(Integer.valueOf(year), 1, 1);
		LocalDate endDate = LocalDate.of(Integer.valueOf(year) + 1, 1, 1);
		
		return matchRepo.findMatchByTeamNameBetweenDate(teamName, startDate, endDate);
	}
	
}
