package by.javatr.webparsing.service.parser;
import java.io.IOException;
import java.util.List;
import by.javatr.webparsing.service.entity.Gem;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class GemsSAXParser extends Parser {
    private List<Gem> gems;
    private SAXHandler sh;
    private XMLReader reader;

    public GemsSAXParser() {
        // создание SAX-анализатора
        sh = new SAXHandler();
        try {
            // создание объекта-обработчика
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(sh);
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера: " + e);
        }
    }
    public List<Gem> getGems() {
        return gems;
    }
    public void buildSetGems(String fileName) {
        try {
            // разбор XML-документа
            reader.parse(fileName);
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера: " + e);
        } catch (IOException e) {
            System.err.print("ошибка I/О потока: " + e);
        }
        gems = sh.getGems();
    }
}
