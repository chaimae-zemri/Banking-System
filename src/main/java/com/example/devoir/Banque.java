package com.example.devoir;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor


public class Banque {

    //les attributs
    private String Id;
    private String pays;
    private List<Compte> Comptes;

    //les getters and setters

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public List<Compte> getComptes() {
        return Comptes;
    }

    public void setComptes(List<Compte> comptes) {
        Comptes = comptes;
    }


}

