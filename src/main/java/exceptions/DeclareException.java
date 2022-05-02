package exceptions;

public enum DeclareException {
    READING_CURRENT_FILE("Error occure while reading file"),
    INVALID_INPUT("Invalid input"),
    CURRENT_ERROR("An error is occurred");

    private String message;

    public String getMessage() {
        return message;
    }

    DeclareException(String message) {
        this.message = message;
    }
}
