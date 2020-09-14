package com.hebertrfreitas.footballapi.repository;

import com.hebertrfreitas.footballapi.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player,String> {


}
