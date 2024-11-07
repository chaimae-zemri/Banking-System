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

}