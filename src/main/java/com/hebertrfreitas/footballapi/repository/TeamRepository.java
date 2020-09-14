package com.hebertrfreitas.footballapi.repository;

import com.hebertrfreitas.footballapi.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, String> {
}
