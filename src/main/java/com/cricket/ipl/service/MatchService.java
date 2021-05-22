package com.cricket.ipl.service;

import java.util.List;

import com.cricket.domain.Match;

public interface MatchService {

	public List<Match> getMatchInfoByTeamNameAndYear(String teamName, String year);

}
