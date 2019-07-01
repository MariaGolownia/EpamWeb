package by.javatr.webparsing.dao;
import by.javatr.webparsing.service.util.ValidationException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.*;

public class FileHandler {

    public void updateFile(String destination, HttpServletRequest request) throws IOException, ServletException {
        Part filePart = request.getPart(destination);
        File file = new File(destination);
        try {
            if (filePart == null)
                throw new ValidationException("Check connect wiht system!");
        }
        catch (ValidationException e) {
            e.printStackTrace();
        }

        try(InputStream filecontent = filePart.getInputStream();
            OutputStream out = new FileOutputStream(file)) {
            int read;
            final byte[] bytes = new byte[1024];
            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
        }
    }
}
