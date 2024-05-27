package org.eventsmanager.exceptions;

public class InvalidTimeException extends IllegalArgumentException{
    public InvalidTimeException(String s){
        super(s);
    }
}
