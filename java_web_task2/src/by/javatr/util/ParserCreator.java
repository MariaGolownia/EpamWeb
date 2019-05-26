package by.javatr.util;

public class ParserCreator {
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
