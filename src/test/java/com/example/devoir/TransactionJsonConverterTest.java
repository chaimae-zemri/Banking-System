package com.example.devoir;

import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class TransactionJsonConverterTest {



    @Test
    public void testConvertirEnJson() {
        // Préparer des instances de Compte

// Préparer des instances de Banque
        Banque banque1 = new Banque("Banque1", "France");
        Banque banque2 = new Banque("Banque2", "France");

        // Préparer des instances de Compte
        Compte compte1 = new Compte("C001");
        compte1.setBanque(banque1); // Associer la banque au compte
        Compte compte2 = new Compte("C002");
        compte2.setBanque(banque2); // Associer la banque au compte

        List<Compte> comptes = Arrays.asList(compte1, compte2);


        // Créer une instance de Transaction
        Date timeStamp = new Date();
        String reference = "Ref123";
        Transaction transaction = new Transaction(timeStamp, reference, comptes);

        try {
            // Convertir l'objet Transaction en JSON
            String json = TransactionJsonConverter.convertirEnJson(transaction);

            // Vérifier que la conversion a réussi
            assertNotNull(json);
            System.out.println(json);

            // Exemple de vérification que le JSON contient des valeurs attendues
            assertEquals("{\"reference\":\"Ref123\",\"type\":\"VIREST\",\"timeStamp\":1731106512534,\"comptes\":[{\"numCompte\":\"C001\",\"banque\":{\"id\":\"Banque1\",\"pays\":\"France\"}},{\"numCompte\":\"C002\",\"banque\":{\"id\":\"Banque2\",\"pays\":\"France\"}}]}", json.trim());


        } catch (JsonProcessingException e) {
            // Échouer le test si une exception est levée
            e.printStackTrace();
            org.junit.jupiter.api.Assertions.fail("La conversion en JSON a échoué : " + e.getMessage());
        }
    }
}