package Excepciones;

public class incorrectPasswordException extends RuntimeException {
    public incorrectPasswordException(String message) {
        super(message);
    }
}
