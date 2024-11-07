package com.example.devoir;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.Arrays;
import java.util.List;

class BanqueJsonConverterTest {


    @Test
    public void testConvertirEnJson() {
        // Préparer une instance de Banque
        Compte compte1 = new Compte("C001");
        Compte compte2 = new Compte("C002");
        List<Compte> comptes = Arrays.asList(compte1, compte2);

        Banque banque = new Banque();
        banque.setId("B001");
        banque.setPays("France");
        banque.setComptes(comptes);

        try {
            // Convertir l'objet Banque en JSON
            String json = BanqueJsonConverter.convertirEnJson(banque);

            // Vérifier que la conversion a réussi
            assertNotNull(json);
            System.out.println(json);

            // Vérifier que le JSON contient les valeurs attendues
            assertEquals("{\"id\":\"B001\",\"pays\":\"France\",\"comptes\":[{\"numCompte\":\"C001\"},{\"numCompte\":\"C002\"}]}", json.trim());

        } catch (JsonProcessingException e) {
            // Échouer le test si une exception est levée
            e.printStackTrace();
            org.junit.jupiter.api.Assertions.fail("La conversion en JSON a échoué : " + e.getMessage());
        }
    }



    @Test
    public void testConvertirDepuisJson() {
        // JSON d'entrée pour le test
        String json = "{\"id\":\"B001\",\"pays\":\"France\",\"comptes\":[{\"numCompte\":\"C001\"},{\"numCompte\":\"C002\"}]}";

        try {
            // Convertir le JSON en objet Banque
            Banque banque = BanqueJsonConverter.convertirDepuisJson(json);

            // Vérifier que l'objet n'est pas nul
            assertNotNull(banque);

            // Afficher chaque attribut sur une ligne
            System.out.println("Id: " + banque.getId());
            System.out.println("Pays: " + banque.getPays());

            System.out.println("Comptes:");
            for (Compte compte : banque.getComptes()) {
                System.out.println("  NumCompte: " + compte.getNumCompte());
            }

            // Vérifications des valeurs des attributs
            assertEquals("B001", banque.getId());
            assertEquals("France", banque.getPays());
            assertEquals(2, banque.getComptes().size());
            assertEquals("C001", banque.getComptes().get(0).getNumCompte());
            assertEquals("C002", banque.getComptes().get(1).getNumCompte());

        } catch (JsonProcessingException e) {
            fail("La conversion depuis JSON a échoué : " + e.getMessage());
        }
    }

}