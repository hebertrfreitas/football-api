package com.hebertrfreitas.footballapi.resource;

import com.hebertrfreitas.footballapi.model.Player;
import com.hebertrfreitas.footballapi.model.Team;
import com.hebertrfreitas.footballapi.repository.PlayerRepository;
import com.hebertrfreitas.footballapi.repository.TeamRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("players")
public class PlayerResource {

    private PlayerRepository playerRepository;

    public PlayerResource(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(this.playerRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") String id){
        Optional<Player> player = this.playerRepository.findById(id);

        if(! player.isPresent()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(player);
    }


    @PostMapping
    public Player save(@RequestBody Player newPlayer){
        return this.playerRepository.save(newPlayer);
    }




}
