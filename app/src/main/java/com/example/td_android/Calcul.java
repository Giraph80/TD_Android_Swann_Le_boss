package com.example.td_android;

import java.util.Random;

public class Calcul {
    private Integer operandeA;
    private Integer operandeB;
    private String operateur;
    private Integer resultat;


    public Calcul() {
        Random rand = new Random();

        this.operandeA = rand.nextInt(100) + 1;
        this.operandeB = rand.nextInt(100) + 1;

        ChoixOperateur();

    }


    public String getResultat() {
        return resultat.toString();
    }

    @Override
    public String toString() {
        return operandeA.toString() + operateur + operandeB.toString();
    }

    private String ChoixOperateur() {
        Random rand = new Random();

        switch (rand.nextInt(3)){
            case 0:
                this.operateur = " + ";
                this.resultat = operandeA + operandeB;
                break;

            case 1:
                this.operateur = " - ";
                this.resultat = operandeA - operandeB;
                break;

            case 2:
                this.operateur = " * ";
                this.resultat = operandeA * operandeB;
                break;


        }

        return null;

    }

    public Integer getOperandeA() {
        return operandeA;
    }

    public Integer getOperandeB() {
        return operandeB;
    }


    public boolean verifResultat(String reponse){

        return resultat.toString().equals(reponse);

    }


}
