package com.hebertrfreitas.footballapi.resource;

import com.hebertrfreitas.footballapi.model.Team;
import com.hebertrfreitas.footballapi.repository.TeamRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

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
    public ResponseEntity<Object> save(@RequestBody Team newTeam, UriComponentsBuilder uriComponentsBuilder){

        Team savedTeam = this.teamRepository.save(newTeam);
        UriComponents uriComponents =
                uriComponentsBuilder.path("teams/{id}").buildAndExpand(savedTeam.getId());

        return ResponseEntity.created(uriComponents.toUri()).body(savedTeam);
    }



    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody Team updateTeam, @PathVariable String id){

        Optional<Team> team = this.teamRepository.findById(id);
        if(!team.isPresent()){
            return ResponseEntity.notFound().build();
        }

        Team savedTeam = team.get();
        savedTeam.setName(updateTeam.getName());

        return ResponseEntity.ok().body(this.teamRepository.save(savedTeam));

    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id){

        Optional<Team> team = this.teamRepository.findById(id);

        if(!team.isPresent()){
            return ResponseEntity.notFound().build();
        }

        this.teamRepository.delete(team.get());

        return ResponseEntity.ok().build();
    }

}
