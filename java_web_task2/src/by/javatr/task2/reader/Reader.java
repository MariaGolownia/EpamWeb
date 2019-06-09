package by.javatr.task2.reader;
import by.javatr.task2.entity.Text;
import by.javatr.task2.exc.ReaderException;
import by.javatr.task2.util.ParserCreator;
import by.javatr.task2.util.ParserText;
import by.javatr.task2.valid.ValidationFile;
import jdk.nashorn.internal.runtime.ParserException;
import org.apache.log4j.Logger;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Reader {

    private static Logger LOGGER = Logger.getLogger(Reader.class);

    public static Text readTextFromFile(String fileName)  {
        String FILE_PATH = fileName;
        Text text = new Text();
        try {
            File file = new File(FILE_PATH);
            ValidationFile validationFile = new ValidationFile();
            if (validationFile.checkFile(file)) {
                Path path = Paths.get(FILE_PATH);
                byte[] bytes = Files.readAllBytes(path);
                String str = new String(bytes);
                ParserText parser = ParserCreator.createParser();
                try {
                    text = parser.parseComponent(str);

                } catch (ParserException ex) {
                    throw new ParserException("Parser-error!");
                }
            }
            else {
                throw new ReaderException("Error reading from file! Check the file's existence and the veracity of his name.");
            }
        } catch (ReaderException | IOException ex) {
            LOGGER.error(ex.getMessage());
        }
        return text;
    }

}
