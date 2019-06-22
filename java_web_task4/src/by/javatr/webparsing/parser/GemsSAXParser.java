package by.javatr.webparsing.parser;
import java.io.IOException;
import java.util.List;
import by.javatr.webparsing.entity.Gem;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import by.javatr.webparsing.entity.Gem;

import java.util.List;

public class GemsSAXParser {
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
    public void buildSetStudents(String fileName) {
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
