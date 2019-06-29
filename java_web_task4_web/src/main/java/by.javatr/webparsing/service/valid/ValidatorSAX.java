package by.javatr.webparsing.service.valid;
import org.xml.sax.SAXException;
import by.javatr.webparsing.service.parser.GemErrorHandler;
import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

public class ValidatorSAX {

    public ValidatorSAX (String filename, String schemaname, String logname) {
        Schema schema = null;
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        try {
            // установка проверки с использованием XSD
            schema = factory.newSchema(new File(schemaname));
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setSchema(schema);
            // создание объекта-парсера
            SAXParser parser = spf.newSAXParser();
            // установка обработчика ошибок и запуск
            GemErrorHandler gemErrorHandler = new GemErrorHandler(logname);
            parser.parse(filename, new GemErrorHandler(logname));
            System.out.println(filename + " is valid");
        } catch (ParserConfigurationException e) {
            System.err.println(filename + " config error: " + e.getMessage());
        } catch (SAXException e) {
            System.err.println(filename + " SAX error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
        }
    }
}
