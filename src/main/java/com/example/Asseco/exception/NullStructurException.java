package com.example.Asseco.exception;

public class NullStructurException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public NullStructurException() {
	super("The object to convert to structur is null");
    }

}
