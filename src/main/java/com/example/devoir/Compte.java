package com.example.devoir;

import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Compte {

    //les attributs
    private String numCompte;
    private Date dateCrea;
    private Date dateUpdate;
    private String devise;
    private Client client;
    private Banque banque;
    private List<Transaction> transactions;

    //les getters and setters


    public String getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(String numCompte) {
        this.numCompte = numCompte;
    }

    public Date getDateCrea() {
        return dateCrea;
    }

    public void setDateCrea(Date dateCrea) {
        this.dateCrea = dateCrea;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
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


    public Compte() {
    }

    public Compte(String numCompte) {
        this.numCompte = numCompte;
    }

    public Compte(String numCompte, Banque banque) {
        this.numCompte = numCompte;
        this.banque = banque;
    }

    public Compte(String numCompte, Date dateCrea, Date dateUpdate , String devise, Client client, Banque banque, List<Transaction> transactions) {
        this.numCompte = numCompte;
        this.dateCrea = dateCrea;
        this.dateUpdate = dateUpdate;
        this.devise = devise;
        this.client = client;
        this.banque = banque;
        this.transactions = transactions;
    }
}
