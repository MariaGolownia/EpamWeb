package by.javatr.task2.util;
import org.apache.log4j.Logger;

public class ParserCreator {
    private static Logger LOGGER = Logger.getLogger(ParserCreator.class);
 //ParserCreator - создание последовательности парсеров

    public static ParserText createParser() {
        ParserLeaf parserLeaf = new ParserLeaf();
        ParserLexeme parserLexeme = new ParserLexeme();
        parserLexeme.setNext(parserLeaf);

        ParserSentence parserSentence = new ParserSentence();
        parserSentence.setNext(parserLexeme);

        ParserParagraph parserParagraph = new ParserParagraph();
        parserParagraph.setNext(parserSentence);

        ParserText parser = new ParserText();
        parser.setNext(parserParagraph);
        return parser;

// Можно так:
//        ParserText parser = new ParserText();
//        parser
//                .setNext(new ParserParagraph()
//                        .setNext(new ParserSentence()
//                                .setNext(new ParserLexeme()
//                                        .setNext(new ParserLeaf()))));
//        return parser;
    }
}
