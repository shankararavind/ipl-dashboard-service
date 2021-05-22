package com.cricket.batch.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cricket.domain.Team;
import com.cricket.repository.MatchRepository;
import com.cricket.repository.TeamRepository;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	private TeamRepository teamRepository;

	@Autowired
	private MatchRepository matchRepository;

	@Autowired
	public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {

			log.info("Job Completed");
			Map<String, Team> teamData = new HashMap<>();

			List<Object[]> distinctTeam1 = matchRepository.findDistinctCountOfTeam1();

			distinctTeam1.stream().map(team -> new Team((String) team[0], (Long) team[1]))
					.forEach(team -> teamData.put(team.getTeamName(), team));

			List<Object[]> distinctTeam2 = matchRepository.findDistinctCountOfTeam1();

			distinctTeam2.stream().forEach(team -> {
				Team team1 = teamData.get(team[0]);
				team1.setTotalMatches(team1.getTotalMatches() + (Long) team[1]);
			});
			
			List<Object[]> distinctMatchWinner = matchRepository.findDistinctMatchWinner();
			distinctMatchWinner.stream().forEach(winner -> {
				Team team = teamData.get((String) winner[0]);
				if (null != team)
				{
					team.setTotalWins((Long) winner[1]);
				}
			});
			
			teamData.values().stream().forEach(teamRepository::save);
			teamData.values().stream().forEach(System.out::println);
			
		}
	}

}
