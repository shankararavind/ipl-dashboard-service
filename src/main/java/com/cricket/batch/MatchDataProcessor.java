package com.cricket.batch;

import java.time.LocalDate;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.cricket.domain.Match;
import com.cricket.domain.MatchInput;

@Component
public class MatchDataProcessor implements ItemProcessor<MatchInput, Match>{

	@Override
	public Match process(MatchInput matchInput) throws Exception {
		Match match = new Match();
		match.setId(Long.parseLong(matchInput.getId()));
		match.setCity(matchInput.getCity());
		match.setDate(LocalDate.parse(matchInput.getDate()));
		match.setPlayerOfMatch(matchInput.getPlayer_of_match());
		match.setVenue(matchInput.getVenue());
		
		String firstInningsTeam = null, secondInningsTeam = null;
		
//		if("bat".equalsIgnoreCase(matchInput.getToss_decision()))
//		{
//			firstInningsTeam = matchInput.getToss_winner();
//			secondInningsTeam = matchInput.getToss_winner().equalsIgnoreCase(matchInput.getToss_winner())
//					? matchInput.getTeam2()
//					: matchInput.getTeam1();
//		}
//		else
//		{
//			secondInningsTeam = matchInput.getToss_winner();
//			firstInningsTeam = matchInput.getToss_winner().equalsIgnoreCase(matchInput.getToss_winner())
//					? matchInput.getTeam2()
//					: matchInput.getTeam1();
//		}
		if ("bat".equalsIgnoreCase(matchInput.getToss_decision())) 
		{
			if (matchInput.getToss_winner().equals(matchInput.getTeam1())) 
			{
				firstInningsTeam = matchInput.getTeam1();
				secondInningsTeam = matchInput.getTeam2();
			}
			else 
			{
				firstInningsTeam = matchInput.getTeam2();
				secondInningsTeam = matchInput.getTeam1();		
			}
		}
		else
		{
			if (matchInput.getToss_winner().equals(matchInput.getTeam1())) 
			{
				firstInningsTeam = matchInput.getTeam2();
				secondInningsTeam = matchInput.getTeam1();		
			}
			else
			{
				firstInningsTeam = matchInput.getTeam1();
				secondInningsTeam = matchInput.getTeam2();
			}
		}
	
		match.setTeam1(firstInningsTeam);
		match.setTeam2(secondInningsTeam);
		
		match.setTossWinner(matchInput.getToss_winner());
		match.setTossDecision(matchInput.getToss_decision());
		match.setResult(matchInput.getResult());
		match.setResultMargin(matchInput.getResult_margin());
		match.setMatchWinner(matchInput.getWinner());
		match.setUmpire1(matchInput.getUmpire1());
		match.setUmpire2(matchInput.getUmpire2());
		
		return match;
	}

}
