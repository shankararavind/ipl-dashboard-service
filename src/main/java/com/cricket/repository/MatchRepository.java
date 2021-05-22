package com.cricket.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cricket.domain.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long>{

	@Query("select distinct team1, count(*) from Match group by team1")
	public List<Object[]> findDistinctCountOfTeam1();
	
	@Query("select distinct team2, count(*) from Match group by team2")
	public List<Object[]> findDistinctCountOfTeam2();
	
	@Query("select distinct matchWinner, count(*) from Match group by matchWinner")
	public List<Object[]> findDistinctMatchWinner();
	
	@Query(value = "select top(?3) * from Match where team1=?1 or team2=?2 order by date desc", nativeQuery = true)
	public List<Match> findMatchByTeamName(String teamName1, String teamName2, int recordCount);
	
	@Query(value = "select * from Match where (team1=?1 or team2=?1) and date between ?2 and ?3 order by date desc", nativeQuery = true)
	public List<Match> findMatchByTeamNameBetweenDate(String teamName, LocalDate startDate, LocalDate endDate);
	
	
}
