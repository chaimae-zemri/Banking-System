package com.example.devoir;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class Transaction {

    public enum Type{
        VIRIN, VIREST, VIRMULTA, VIRCHAC
    }

    //les attributs
    private final Type Type;
    private final Date TimeStamp;
    private final String reference;
    private final List<Compte> Comptes;


    //les getters
    public Transaction.Type getType() {
        return Type;
    }

    public Date getTimeStamp() {
        return TimeStamp;
    }

    public String getReference() {
        return reference;
    }

    public List<Compte> getComptes() {
        return Comptes;
    }


    //le constructeur
    public Transaction(Date timeStamp, String reference, List<Compte> comptes) {
        this.TimeStamp = timeStamp;
        this.reference = reference;
        this.Comptes = comptes;
        this.Type = calculerType();  // Initialisation du type automatiquement
    }


    private Type calculerType() {
        if (Comptes.size() == 1) {
            return null; // Cas invalide, au moins 2 comptes sont nécessaires pour une transaction
        }

        Banque banque1 = Comptes.get(0).getBanque();
        String pays1 = banque1.getPays();

        // Vérifier si c'est une transaction entre plusieurs comptes
        if (Comptes.size() > 2) {
            return Type.VIRMULTA;
        }

        Banque banque2 = Comptes.get(1).getBanque();
        String pays2 = banque2.getPays();

        if (banque1.equals(banque2)) {
            // Même banque et même pays
            if (pays1.equals(pays2)) {
                return Type.VIRIN;
            }
        } else {
            // Banques différentes
            if (pays1.equals(pays2)) {
                return Type.VIREST;
            } else {
                return Type.VIRCHAC;
            }
        }

        return null;
    }

}

