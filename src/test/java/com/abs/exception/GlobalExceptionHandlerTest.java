package com.abs.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GlobalExceptionHandlerTest {

    @Test
    void testCustomExceptionHandling() {
        // Create an instance of CustomException with a specific message
        String errorMessage = "Custom exception message";
        CustomException customException = new CustomException(errorMessage);

        // Call the exception handler method
        GlobalExceptionHandler exceptionHandler = new GlobalExceptionHandler();
        ResponseEntity<String> responseEntity = exceptionHandler.customException(customException);

        // Verify the response entity
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals(errorMessage, responseEntity.getBody());
    }
}
