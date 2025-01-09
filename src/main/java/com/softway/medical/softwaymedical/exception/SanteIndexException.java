package com.softway.medical.softwaymedical.exception;

public class SanteIndexException extends RuntimeException {

    private static final String  PATHOLOGIE_NOT_FOUND = "la pathologie correspondante à l'index  %s est introuvable" ;
    public SanteIndexException(int index) {
        super(String.format(PATHOLOGIE_NOT_FOUND,index));
    }
}
