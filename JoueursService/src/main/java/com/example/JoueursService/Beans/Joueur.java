package com.example.JoueursService.Beans;

public class Joueur {
    private Long id;
    private String nom;
    private Long equipeId; // L'ID de l'équipe à laquelle appartient le joueur

    public Joueur() {

    }

    public Joueur(Long id, String nom, Long equipeId) {
        this.id = id;
        this.nom = nom;
        this.equipeId = equipeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getEquipeId() {
        return equipeId;
    }

    public void setEquipeId(Long equipeId) {
        this.equipeId = equipeId;
    }
}

