package by.javatr.exc;

public class NotCorrectModelException extends Exception {

    public NotCorrectModelException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "NotCorrectModelException {"
                + ", message=" + getMessage()
                + "} ";
    }
}
