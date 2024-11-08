package com.example.devoir;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CompteJsonConverter {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    static {
        // Configurer pour ignorer les valeurs null globalement
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    // Convertir un objet Compte en JSON
    public static String convertirEnJson(Compte compte) throws JsonProcessingException {
        return objectMapper.writeValueAsString(compte);
    }

    // Convertir du JSON en un objet Compte
    public static Compte convertirDepuisJson(String json) throws JsonProcessingException {
        return objectMapper.readValue(json, Compte.class);
    }
}
