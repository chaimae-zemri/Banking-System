package com.example.devoir;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class CompteJsonConverterTest {


    @Test
    public void testConvertirEnJson() {
        // Créer un objet Compte pour le test
        Compte compte = new Compte();
        compte.setNumCompte("C001");
        compte.setDateCrea(new Date());
        compte.setDateUpdate(new Date());
        compte.setDevise("EUR");

        Banque banque = new Banque();
        banque.setId("123");  // ID de la banque
        compte.setBanque(banque);


        Client client = new Client();
        client.setNumClient("CL456");  // Numéro du client
        compte.setClient(client);


        try {
            // Appeler la méthode à tester
            String jsonResult = CompteJsonConverter.convertirEnJson(compte);

            // JSON attendu (simplifié pour l'exemple)
            //String expectedJson = "{\"numCompte\":\"C001\",\"dateCrea\":\"2024-11-07T00:00:00\",\"devise\":\"EUR\"}";
            String expectedJson = "{\"numCompte\":\"C001\",\"dateCrea\":\"2024-11-07T00:00:00\",\"devise\":\"EUR\",\"banque\":{\"id\":123},\"client\":{\"numClient\":\"CL456\"},\"transactions\":[{\"reference\":\"TX789\"}]}";

            // Vérification (ajustez l'attendu selon le format de date que vous obtenez)
            // Il est souvent utile d'utiliser une comparaison JSON plus flexible si les formats varient.
            System.out.println("Résultat JSON : " + jsonResult);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            // Échec du test si une exception est levée
            assertEquals(true, false, "Une exception a été levée lors de la conversion en JSON.");
        }
    }

    @Test
    public void testConvertirDepuisJson() {
        // Sample JSON string that matches the Compte class structure
        String json = "{"
                + "\"numCompte\": \"12345\","
                + "\"dateCrea\": \"2024-01-15\","
                + "\"dateUpdate\": \"2024-02-20\","
                + "\"devise\": \"USD\","
                + "\"client\": {\"numClient\": 1, \"nom\": \"John Doe\"}," // Adjust based on your Client class structure
                + "\"banque\": {\"id\": \"B001\", \"pays\": \"France\"}," // Adjust based on your Banque class structure
                + "\"transactions\": []"
                + "}";

        try {
            // Call the method to convert JSON to a Compte object
            Compte compte = CompteJsonConverter.convertirDepuisJson(json);



            System.out.println("numCompte: " + compte.getNumCompte());
            System.out.println("dateCrea: " + compte.getDateCrea());
            System.out.println("dateUpdate: " + compte.getDateUpdate());
            System.out.println("devise: " + compte.getDevise());
            Banque banque = compte.getBanque();
            Client client = compte.getClient();
            System.out.println("client: " + client.getNumClient());
            System.out.println("banque: " + banque.getId());

            System.out.println("Transactions:");
            for (Transaction transaction : compte.getTransactions()) {
                System.out.println("  NumCompte: " + transaction.getReference());
            }



            // Assertions to verify the properties of the returned object
            assertNotNull(compte);
            assertEquals("12345", compte.getNumCompte());
            assertEquals("USD", compte.getDevise());
            assertNotNull(compte.getDateCrea());
            assertNotNull(compte.getDateUpdate());
            assertNotNull(compte.getClient());
            assertNotNull(compte.getBanque());
            assertEquals(0, compte.getTransactions().size());



        } catch (JsonProcessingException e) {
            fail("JSON processing failed: " + e.getMessage());
        }
    }
}
