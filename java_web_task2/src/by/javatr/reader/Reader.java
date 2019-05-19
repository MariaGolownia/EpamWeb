package by.javatr.reader;
import by.javatr.entity.Text;
import by.javatr.exc.ReaderException;
import by.javatr.util.ParserCreator;
import by.javatr.util.ParserText;
import jdk.nashorn.internal.runtime.ParserException;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Reader {

    public static Text readTextFromFile (String fileName) throws IOException, ReaderException {
            String FILE_PATH = "src/by/javatr/data/"+ fileName;
            Path path = Paths.get(FILE_PATH);
            byte[] bytes = Files.readAllBytes(path);
            String str = new String(bytes);
            ParserText parser = ParserCreator.createParser();
            try {
                Text text = parser.parseComponent(str);
                return text;
            } catch (ParserException ex) {
                throw new ReaderException("Error!");
            }
    }

}
