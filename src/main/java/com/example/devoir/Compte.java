package com.example.devoir;

import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor


public class Compte {

    //les attributs
    private String NumCompte;
    private Date DateCrea;
    private Date DateUpdate;
    private String Devise;
    private Client client;
    private Banque banque;
    private List<Transaction> transactions;

    //les getters and setters
    public String getNumCompte() {
        return NumCompte;
    }

    public void setNumCompte(String numCompte) {
        NumCompte = numCompte;
    }

    public Date getDateCrea() {
        return DateCrea;
    }

    public void setDateCrea(Date dateCrea) {
        DateCrea = dateCrea;
    }

    public Date getDateUpdate() {
        return DateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        DateUpdate = dateUpdate;
    }

    public String getDevise() {
        return Devise;
    }

    public void setDevise(String devise) {
        Devise = devise;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Banque getBanque() {
        return banque;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }


}
