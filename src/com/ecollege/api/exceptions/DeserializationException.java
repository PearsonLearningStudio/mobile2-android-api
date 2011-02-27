package com.ecollege.api.exceptions;

public class DeserializationException extends ServiceException {

    private static final long serialVersionUID = 1;

    public DeserializationException (String string) {
        super(string);
    }

    public DeserializationException(Exception e) {
        super(e);
    }
	
    public DeserializationException(String s, Exception e) {
        super(s, e);
    }

}

