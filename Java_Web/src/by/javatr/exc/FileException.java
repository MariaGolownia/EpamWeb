package by.javatr.exc;
import org.apache.log4j.Logger;

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
