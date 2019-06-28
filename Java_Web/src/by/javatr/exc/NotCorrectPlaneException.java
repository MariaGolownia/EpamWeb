package by.javatr.exc;

public class NotCorrectPlaneException extends Exception {

    public NotCorrectPlaneException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "NotCorrectPlaneException {"
                + ", message=" + getMessage()
                + "} ";
    }
}