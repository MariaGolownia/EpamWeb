package by.javatr.util;
import org.apache.log4j.Logger;

public class ParserCreator {
    private static Logger LOGGER = Logger.getLogger(ParserCreator.class);
 //ParserCreator - создание последовательности парсеров

    public static ParserText createParser() {
        ParserText parser = new ParserText();
        parser
                .setNext(new ParserParagraph()
                        .setNext(new ParserSentence()
                                .setNext(new ParserLexeme()
                                        .setNext(new ParserLeaf()))));
        return parser;
    }
}
