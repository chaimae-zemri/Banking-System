package com.example.devoir;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class ClientJsonConverterTest {


    @Test
    public void testConvertirEnJson() {
        // Préparer un objet Client
        Client client = new Client(
                "12345",
                "Dupont",
                "Jean",
                "123 Rue Exemple",
                "0123456789",
                "jean.dupont@example.com",
                new ArrayList<>()
        );

        try {
            // Convertir l'objet Client en JSON
            String json = ClientJsonConverter.convertirEnJson(client);

            // Vérifier que le JSON n'est pas nul ou vide
            //assertNotNull(json);
            //assertFalse(json.isEmpty());

            // Vérifier que le JSON contient certaines clés/valeurs attendues
            assertTrue(json.contains("\"numClient\":\"12345\""));
            assertTrue(json.contains("\"nom\":\"Dupont\""));
            assertTrue(json.contains("\"prenom\":\"Jean\""));
            assertTrue(json.contains("\"adresse\":\"123 Rue Exemple\""));
            assertTrue(json.contains("\"phone\":\"0123456789\""));
            assertTrue(json.contains("\"email\":\"jean.dupont@example.com\""));
            assertTrue(json.contains("\"comptes\":[]"));

            System.out.println(json);
        } catch (JsonProcessingException e) {
            fail("La conversion en JSON a échoué : " + e.getMessage());
        }


    }




    @Test
    public void testConvertirDepuisJson() {
        // Préparer une chaîne JSON
        String json = "{\"numClient\":\"12345\",\"nom\":\"Dupont\",\"prenom\":\"Jean\",\"adresse\":\"123 Rue Exemple\",\"phone\":\"0123456789\",\"email\":\"jean.dupont@example.com\",\"comptes\":[]}";
        try {
            // Convertir le JSON en objet Client
            Client client = ClientJsonConverter.convertirDepuisJson(json);

            // Vérifier que l'objet Client n'est pas nul
            assertNotNull(client);


            System.out.println("numClient: " + client.getNumClient());
            System.out.println("nom: " + client.getNom());
            System.out.println("prenom: " + client.getPrenom());
            System.out.println("adresse: " + client.getAdresse());
            System.out.println("phone: " + client.getPhone());
            System.out.println("email: " + client.getEmail());

            System.out.println("Comptes:");
            for (Compte compte : client.getComptes()) {
                System.out.println("  NumCompte: " + compte.getNumCompte());
            }

            // Vérifier les valeurs des attributs
            assertEquals("12345", client.getNumClient());
            assertEquals("Dupont", client.getNom());
            assertEquals("Jean", client.getPrenom());
            assertEquals("123 Rue Exemple", client.getAdresse());
            assertEquals("0123456789", client.getPhone());
            assertEquals("jean.dupont@example.com", client.getEmail());

        } catch (JsonProcessingException e) {
            fail("La conversion depuis JSON a échoué : " + e.getMessage());
        }
    }
}