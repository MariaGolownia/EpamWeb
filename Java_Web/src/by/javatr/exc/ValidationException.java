package by.javatr.exc;

public class ValidationException extends Exception {

    public ValidationException (String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "ValidationException{"
                + ", message=" + getMessage()
                + "} ";
    }

}
