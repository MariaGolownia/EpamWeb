package by.javatr.util;

import by.javatr.entity.ComponentOfText;
import by.javatr.entity.Lexeme;
import jdk.nashorn.internal.runtime.ParserException;

public class ParserLexeme implements IParser <ComponentOfText> {

    @Override
    public Lexeme parseComponent(String str) throws ParserException {
        return new Lexeme(str);
    }
}
