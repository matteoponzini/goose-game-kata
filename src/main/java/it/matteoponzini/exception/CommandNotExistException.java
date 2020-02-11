package it.matteoponzini.exception;

public class CommandNotExistException extends Exception {
    public CommandNotExistException(String errorMessage) {
        super(errorMessage);
    }
}
