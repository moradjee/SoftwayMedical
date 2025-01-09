package com.softway.medical.softwaymedical.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SanteIndexExceptionHandler {
    @ExceptionHandler(SanteIndexException.class)
    public ResponseEntity<String> handleHealthIndexNotValidException(SanteIndexException ex) {
        // Retourner un message d'erreur avec un statut HTTP 400 (Bad Request)
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
