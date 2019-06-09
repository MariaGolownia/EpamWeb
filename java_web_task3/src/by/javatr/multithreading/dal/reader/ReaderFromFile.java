package by.javatr.multithreading.dal.reader;
import by.javatr.multithreading.service.valid.Validation;
import org.apache.log4j.Logger;
import javax.xml.bind.ValidationException;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * ReaderFromFile is designed to read information from a file
 * **/

public class ReaderFromFile {
    private static Logger LOGGER = Logger.getLogger(ReaderFromFile.class);

    public static List<String> readFromFile(String fileName) {
        LOGGER.debug("Start readFromFile");
        List<String> lines = null;
        File file = new File(fileName);
        Validation validation = new Validation();
        try {
            if (!validation.checkFile(file)) {
                throw new ValidationException ("Error reading from file! Check the file's existence and the veracity of his name!");
            }
            try {
                lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        catch (ValidationException ex1) {
            ex1.printStackTrace();
        }
        return lines;
    }

//    public static List<String> readFromFile(String fileName) {
//        LOGGER.debug("Start readFromFile");
//        List<String> lines = null;
//        try {
//            lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return lines;
//    }
}
