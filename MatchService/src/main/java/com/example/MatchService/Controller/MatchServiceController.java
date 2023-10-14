package com.example.MatchService.Controller;

import com.example.MatchService.Beans.Matchs;
import com.example.MatchService.Repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/matchs")
public class MatchServiceController {
    private final MatchRepository matchRepository;

    @Autowired
    public MatchServiceController(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matchs> getMatchById(@PathVariable Integer id) {
        Optional<Matchs> matchOptional = matchRepository.findById(id);
        return matchOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Matchs> createMatch(@RequestBody Matchs match) {
        Matchs createdMatch = matchRepository.save(match);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMatch);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Matchs> updateMatch(@PathVariable Integer id, @RequestBody Matchs updatedMatch) {
        Optional<Matchs> existingMatchOptional = matchRepository.findById(id);
        if (existingMatchOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        updatedMatch.setId(id);
        Matchs updated = matchRepository.save(updatedMatch);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable Integer id) {
        if (matchRepository.existsById(id)) {
            matchRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<Matchs> getAllMatches() {
        return (List<Matchs>) matchRepository.findAll();
    }
}
