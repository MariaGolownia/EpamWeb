package by.javatr.util;
import by.javatr.entity.ComponentOfText;
import by.javatr.entity.Sentence;
import by.javatr.valid.ValidationStr;
import jdk.nashorn.internal.runtime.ParserException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ParserSentence extends ParserComponent<ComponentOfText> {
    private static final Pattern LEXEME_DELIMETER = Pattern.compile("[\\s]{1,}");

    @Override
    public Sentence parseComponent(String str) throws ParserException {
        if(!ValidationStr.ifExist(str)) {
            throw new ParserException("Attention: input string is empty!");
        }
        List<ComponentOfText> listOfLexemes = new ArrayList<>();
        String[] strings = str.trim().split(LEXEME_DELIMETER.pattern());
        for (String s : strings) {
            listOfLexemes.add(parseNext(s));
        }
        Sentence sentence = new Sentence(listOfLexemes);
        return sentence;
    }

}
