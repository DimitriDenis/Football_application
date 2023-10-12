package com.example.EquipeService.controller;

import org.springframework.web.bind.annotation.*;
import com.example.EquipeService.Beans.Equipe;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teams")
public class EquipeServiceController {

    private static List<Equipe> equipeList = new ArrayList<>();

    // Initialise la liste statique avec des exemples d'équipes
    static {
        equipeList.add(new Equipe(1, "Tours FC"));
        equipeList.add(new Equipe(2, "Ajaccio"));
        equipeList.add(new Equipe(3, "Bastia"));
        equipeList.add(new Equipe(4, "Paris"));
        equipeList.add(new Equipe(5, "Marseille"));
        equipeList.add(new Equipe(6, "Lyon"));
    }


    // Endpoint GET /teams/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Equipe> getEquipe(@PathVariable Integer id) {
        Optional<Equipe> equipe = equipeList.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
        return equipe.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint POST /teams
    @PostMapping
    public ResponseEntity<Equipe> addEquipe(@RequestBody Equipe equipe) {
        equipeList.add(equipe);
        return ResponseEntity.ok(equipe);
    }

    // Endpoint PUT /teams/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Equipe> updateEquipe(@PathVariable Integer id, @RequestBody Equipe equipe) {
        Optional<Equipe> existingEquipe = equipeList.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
        if (existingEquipe.isPresent()) {
            existingEquipe.get().setName(equipe.getName());
            return ResponseEntity.ok(existingEquipe.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint DELETE /teams/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEquipe(@PathVariable Integer id) {
        Optional<Equipe> equipe = equipeList.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
        if (equipe.isPresent()) {
            equipeList.remove(equipe.get());
            return ResponseEntity.ok("Equipe supprimée avec succès.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}





