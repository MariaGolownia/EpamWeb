package by.javatr.webparsing.service.parser;
import java.io.IOException;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import javax.security.sasl.SaslException;

public class GemErrorHandler extends DefaultHandler  {
    //создание регистратора ошибок для пакета by.bsu.valid
    private Logger logger = Logger.getLogger("by.javatr.webparsing.valid");

    public GemErrorHandler(String log) throws IOException {
// установка файла и формата вывода ошибок
        logger.addAppender(new FileAppender(new SimpleLayout(), log));
    }

    public GemErrorHandler() {
// установка файла и формата вывода ошибок

    }


    public void error(SAXParseException e) throws  SAXException {
        logger.error(getLineAddress(e) + " - " + e.getMessage());
        //----------------------------------------------------------------------------
        System.out.print(e.toString());
        throw new SAXException("Document doesn't correspond xsd-schema!", e);

    }

    public void fatalError(SAXParseException e) throws  SAXException {
        logger.fatal(getLineAddress(e) + " - " + e.getMessage());
        throw new SAXException("Document isn't well-formed!", e);
    }

    private String getLineAddress(SAXParseException e) throws  SAXException {
// определение строки и столбца ошибки
        return e.getLineNumber() + " : " + e.getColumnNumber();
    }
}