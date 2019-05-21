package by.javatr.util;
import by.javatr.entity.Component;
import by.javatr.entity.Text;
import by.javatr.valid.ValidationStr;
import jdk.nashorn.internal.runtime.ParserException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

// ParserText - парсер текста на абзацы

public class ParserText extends ParserComponent<Component> {

    private static final Pattern PARAGRAPH_DELIMETER = Pattern.compile("\n(\\s{4,}|\t)");

    @Override
    public Text parseComponent(String str) throws ParserException {
        if(!ValidationStr.ifExist(str)) {
            throw new ParserException("Attention: input string is empty!");
        }
        List<Component> listOfParagraphs = new ArrayList<>();
        String[] strings = str.trim().split(PARAGRAPH_DELIMETER.pattern());
        for (String s : strings) {
            listOfParagraphs.add(parseNext(s));
        }
        Text text = new Text(listOfParagraphs);
        return text;

    }
}
