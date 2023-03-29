package com.example.mentalgame.entities;

public class Calcul extends BaseEntity {

    private Integer resultat;

    public Integer getResultat() {
        return resultat;
    }

    public void setResultat(Integer resultat) {
        this.resultat = resultat;
    }

    public Calcul(Integer resultat) {

        this.resultat = resultat;
    }
}
