package by.javatr.task2.util;
import by.javatr.task2.entity.Component;
import by.javatr.task2.entity.Text;
import by.javatr.task2.valid.ValidationStr;
import jdk.nashorn.internal.runtime.ParserException;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

// ParserText - парсер текста на абзацы

public class ParserText extends ParserComponent<Component> {
    private static Logger LOGGER = Logger.getLogger(ParserText.class);

    private static final Pattern PARAGRAPH_DELIMETER = Pattern.compile("\n(\\s{4,}|\t)");
    private static final Pattern SENTENCE_DELIMETER = Pattern.compile("[.!?]{1,}");

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

    public List<String> parseToParagraphs(String str) throws ParserException {
        if(!ValidationStr.ifExist(str)) {
            throw new ParserException("Attention: input string is empty!");
        }
        List<String> listOfParagraphs = new ArrayList<>();
        String[] strings = str.trim().split(PARAGRAPH_DELIMETER.pattern());
        for (String s : strings) {
            listOfParagraphs.add(s);
        }
        return listOfParagraphs;
    }


    public List<String> parseToSentences(String str) throws ParserException {
        if(!ValidationStr.ifExist(str)) {
            throw new ParserException("Attention: input string is empty!");
        }
        List<String> listOfParagraphs = parseToParagraphs(str);
        List<String> listOfSentences = new ArrayList<>();
        for (int i = 0; i < listOfParagraphs.size(); i++) {
            String stringOfSentences = listOfParagraphs.get(i);
            stringOfSentences = stringOfSentences.replace("...", "[***].")
                    .replace(".", "[*].")
                    .replace("?", "[**]?")
                    .replace("!", "[****]!");
            List<String> listOfSentencesTemp = Arrays.asList(stringOfSentences.trim().split(SENTENCE_DELIMETER.pattern()));
                for (String s : listOfSentencesTemp) {
                    s = s.replace("[***][*]","...")
                            .replace("[***]","...")
                            .replace("[*]", ".")
                            .replace("[**]", "?")
                            .replace("[****]", "!");
                    listOfSentences.add(s);
                }
            }
            return listOfSentences;

    }
}
