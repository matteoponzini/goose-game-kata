package it.matteoponzini.exception;

public class PlayerNotExistException extends Exception {
    public PlayerNotExistException(String errorMessage) {
        super(errorMessage);
    }

}
