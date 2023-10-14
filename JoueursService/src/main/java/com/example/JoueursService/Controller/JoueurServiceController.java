package com.example.JoueursService.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.JoueursService.Beans.Joueur;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/players")
public class JoueurServiceController {

    private static List<Joueur> joueurList = new ArrayList<>();

    // Initialise la liste statique avec des exemples de joueurs
    static {
        joueurList.add(new Joueur(1, "Lionel Messi", 1));
        joueurList.add(new Joueur(2, "Cristiano Ronaldo", 2));
        joueurList.add(new Joueur(3, "Giroud", 1));
        joueurList.add(new Joueur(4, "Fode", 3));
        joueurList.add(new Joueur(5, "Jean", 5));
        joueurList.add(new Joueur(6, "Dimitri", 1));
        joueurList.add(new Joueur(7, "Jean jose", 6));
        joueurList.add(new Joueur(8, "Toussaint", 2));
        joueurList.add(new Joueur(9, "Idricealy", 4));
    }

    // Endpoint GET /players/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Joueur> getPlayer(@PathVariable Integer id) {
        Optional<Joueur> joueur = joueurList.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        return joueur.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint POST /players
    @PostMapping
    public ResponseEntity<Joueur> addPlayer(@RequestBody Joueur joueur) {
        // Générez un nouvel ID pour le joueur (par exemple, en utilisant une séquence ou une autre méthode)
        Integer newId = joueurList.size() + 1;
        joueur.setId(newId);
        joueurList.add(joueur);
        return ResponseEntity.ok().body(joueur);
    }

    // Endpoint PUT /players/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Joueur> updatePlayer(@PathVariable Integer id, @RequestBody Joueur updatedPlayer) {
        Optional<Joueur> existingPlayer = joueurList.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        if (existingPlayer.isPresent()) {
            Joueur player = existingPlayer.get();
            player.setNom(updatedPlayer.getNom());
            player.setEquipeId(updatedPlayer.getEquipeId());
            return ResponseEntity.ok().body(player);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint DELETE /players/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePlayer(@PathVariable Integer id) {
        Optional<Joueur> joueur = joueurList.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        if (joueur.isPresent()) {
            joueurList.remove(joueur.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

