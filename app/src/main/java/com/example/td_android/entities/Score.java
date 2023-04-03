package com.example.td_android.entities;

public class Score extends BaseEntity{
    private String nom;
    private Integer score;

    public String getNom() {
        return nom;
    }

    public void setCalcul(String nom) {
        this.nom = nom;
    }

    public Integer getScore() {
        return score;
    }

    public void setResultat(Integer score) {
        this.score = score;
    }

    public Score(String nom, Integer score) {
        this.nom = nom;
        this.score = score;
    }
}
