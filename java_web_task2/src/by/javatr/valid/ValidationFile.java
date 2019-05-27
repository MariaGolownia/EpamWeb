package by.javatr.valid;

import org.apache.log4j.Logger;

import java.io.File;

public class ValidationFile {
    private static Logger LOGGER = Logger.getLogger(ValidationFile.class);
    public Boolean checkFile(File file) {
        return file.exists()  && file.canRead();

    }
}
