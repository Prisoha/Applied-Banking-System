package com.abs.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ResponseTest {

    @Test
    void testResponseConstructor() {
        String message = "Success";
        String data = "Data";
        Response<String> response = new Response<>(message, data);
        
        assertNotNull(response);
        assertEquals(message, response.getMessage());
        assertEquals(data, response.getData());
    }

    @Test
    void testResponseGettersAndSetters() {
        String message = "Success";
        String data = "Data";
        Response<String> response = new Response<>();
        
        response.setMessage(message);
        response.setData(data);
        
        assertEquals(message, response.getMessage());
        assertEquals(data, response.getData());
    }
}
