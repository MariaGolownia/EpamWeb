package by.javatr.exc;

public class NotCorrectTypeException extends  Exception {

    public NotCorrectTypeException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "NotCorrectTypeException {"
                + ", message=" + getMessage()
                + "} ";
    }
}

