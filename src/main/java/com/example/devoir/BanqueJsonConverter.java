package com.example.devoir;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonInclude;

public class BanqueJsonConverter {
    private static final ObjectMapper objectMapper = new ObjectMapper();


    static {
        // Configurer pour ignorer les valeurs null globalement
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }


    // Convertir un objet Client en JSON
    public static String convertirEnJson(Banque banque) throws JsonProcessingException {
        return objectMapper.writeValueAsString(banque);
    }

    // Convertir du JSON en un objet Client
    public static Banque convertirDepuisJson(String json) throws JsonProcessingException {
        return objectMapper.readValue(json, Banque.class);
    }
}
