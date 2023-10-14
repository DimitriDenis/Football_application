package com.example.JoueursService.Beans;

public class Joueur {
    private Integer id;
    private String nom;
    private Integer equipeId; // L'ID de l'équipe à laquelle appartient le joueur

    public Joueur() {

    }

    public Joueur(Integer id, String nom, Integer equipeId) {
        this.id = id;
        this.nom = nom;
        this.equipeId = equipeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getEquipeId() {
        return equipeId;
    }

    public void setEquipeId(Integer equipeId) {
        this.equipeId = equipeId;
    }
}

