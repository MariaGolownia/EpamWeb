package by.javatr.util;
import by.javatr.entity.Component;
import by.javatr.entity.Sentence;
import by.javatr.valid.ValidationStr;
import jdk.nashorn.internal.runtime.ParserException;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ParserSentence extends ParserComponent<Component> {
    private static Logger LOGGER = Logger.getLogger(ParserSentence.class);
    private static final Pattern LEXEME_DELIMETER = Pattern.compile("[\\s]{1,}");

    @Override
    public Sentence parseComponent(String str) throws ParserException {
        if(!ValidationStr.ifExist(str)) {
            throw new ParserException("Attention: input string is empty!");
        }
        List<Component> listOfLexemes = new ArrayList<>();
        String[] strings = str.trim().split(LEXEME_DELIMETER.pattern());
        for (String s : strings) {
            listOfLexemes.add(parseNext(s));
        }
        Sentence sentence = new Sentence(listOfLexemes);
        return sentence;
    }

}
