package by.javatr.util;

public class ParserCreator {
// ParserCreator - создание последовательности парсеров и определение, что первым отработающим парсером будет ParserText

    public static ParserText createParser() {
        ParserLexeme parserLexeme = new ParserLexeme();

        ParserSentence parserSentence = new ParserSentence();
        parserSentence.setParser(parserLexeme);

        ParserParagraph parserParagraph = new ParserParagraph();
        parserParagraph.setParser(parserSentence);

        ParserText parserText = new ParserText();
        parserText.setParser(parserParagraph);

        //parserText.setParser(new ParserParagraph().setParser(new ParserSentence().setParser(new ParserLexeme())));
        return parserText;
    }

}
