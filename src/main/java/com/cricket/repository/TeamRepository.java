package com.cricket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cricket.domain.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long>{
	
	public Team findByTeamName(String teamName);
}
