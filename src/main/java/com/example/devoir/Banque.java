package com.example.devoir;

import java.util.Date;
import java.util.List;

public class Banque {

    //les attributs
    private String id;
    private String pays;
    private List<Compte> comptes;

    //les getters and setters


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPays() {
        return pays;
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }


    public Banque() {
    }

    public Banque(String id, String pays) {
        this.id = id;
        this.pays = pays;
    }

    public Banque(String id, String pays, List<Compte> comptes) {
        this.id = id;
        this.pays = pays;
        this.comptes = comptes;
    }
}

