package by.javatr.valid;

import java.io.File;

public class ValidationFile {
    public Boolean checkFile(File file) {
        return file.exists()  && file.canRead();

    }
}
