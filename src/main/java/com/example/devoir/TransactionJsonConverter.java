package com.example.devoir;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TransactionJsonConverter {

    private static final ObjectMapper objectMapper = new ObjectMapper();


        static {
            // Configurer pour ignorer les valeurs null globalement
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        }

    // Method to convert TRANSACTION to a JSON
        public static String convertirEnJson(Transaction transaction) throws JsonProcessingException {
            return objectMapper.writeValueAsString(transaction);
        }

        // Method to convert JSON to a Transaction
        public static Transaction convertirDepuisJson(String json) throws JsonProcessingException {
            return objectMapper.readValue(json, Transaction.class);
        }

}
