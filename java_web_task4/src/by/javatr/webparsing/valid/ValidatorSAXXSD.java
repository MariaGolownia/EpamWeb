package by.javatr.webparsing.valid;
import java.io.*;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import by.javatr.webparsing.parser.GemErrorHandler;
import org.xml.sax.SAXException;

public class ValidatorSAXXSD {

    public ValidatorSAXXSD (String fileName, String schemaName, String logname) {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaName);
        try {
        // создание схемы
            Schema schema = factory.newSchema(schemaLocation);
        // создание валидатора на основе схемы
            Validator validator = schema.newValidator();
        // проверка документа
            Source source = new StreamSource(fileName);
            validator.validate(source);
            System.out.println(fileName + " is valid.");
            GemErrorHandler sh = new GemErrorHandler(logname);
            validator.setErrorHandler(sh);
            validator.validate(source);
            System.out.println(fileName + " validating is ended.");
        } catch (SAXException e) {
            System.err.print("validation "+ fileName + " is not valid because "
                    + e.getMessage());
        } catch (IOException e) {
            System.err.print(fileName + " is not valid because "
                    + e.getMessage());
        }
    }
}
