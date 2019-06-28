package by.javatr.exc;

public class NotCorrectCountryException extends  Exception{

        public NotCorrectCountryException(String message) {
            super(message);
        }

        @Override
        public String toString() {
            return "NotCorrectCountryException {"
                    + ", message=" + getMessage()
                    + "} ";
        }
    }
