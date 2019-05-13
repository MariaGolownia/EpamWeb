package by.javatr.exc;

public class FileException extends  Exception{

    public FileException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "FileException {"
                + ", message=" + getMessage()
                + "} ";
    }
}
