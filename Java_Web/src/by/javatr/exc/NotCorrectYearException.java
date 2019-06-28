package by.javatr.exc;

public class NotCorrectYearException extends Exception {

        public NotCorrectYearException(String message) {
            super(message);
        }

        @Override
        public String toString() {
            return "NotCorrectYearException {"
                    + ", message=" + getMessage()
                    + "} ";
        }
    }

