package com.example.mentalgame.entities;

public class Perso extends BaseEntity {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Perso(Integer id) {

        this.id = id;
    }
}
