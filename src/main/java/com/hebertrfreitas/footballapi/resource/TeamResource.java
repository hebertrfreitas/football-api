package com.hebertrfreitas.footballapi.resource;

import com.hebertrfreitas.footballapi.model.Team;
import com.hebertrfreitas.footballapi.repository.TeamRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("teams")
public class TeamResource {

    private TeamRepository teamRepository;

    public TeamResource(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(this.teamRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") String id){
        Optional<Team> team = this.teamRepository.findById(id);

        if(! team.isPresent()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(team);
    }



    @PostMapping
    public Team save(@RequestBody Team newTeam){
        return this.teamRepository.save(newTeam);
    }




}
