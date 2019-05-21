package by.javatr.util;

public class ParserCreator {
 //ParserCreator - создание последовательности парсеров

    public static ParserText createParser() {
        ParserText parser = new ParserText();
        parser
                .setParser(new ParserParagraph()
                        .setParser(new ParserSentence()
                                .setParser(new ParserLexeme()
                                        .setParser(new ParserLeaf()))));
        return parser;
    }
}
