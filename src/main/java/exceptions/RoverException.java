package exceptions;

public class RoverException extends Exception {

    private DeclareException declareException;

    public RoverException(DeclareException declareException) {
        this.declareException = declareException;
    }
}
