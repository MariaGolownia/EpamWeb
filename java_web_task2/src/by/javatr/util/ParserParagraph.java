package by.javatr.util;
import by.javatr.entity.ComponentOfText;
import by.javatr.entity.Paragraph;
import by.javatr.valid.ValidationStr;
import jdk.nashorn.internal.runtime.ParserException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ParserParagraph extends ParserComponent<ComponentOfText> {

    // Осуществление разделения абзаца на предложения на основании знаков пунктуации: [.!?]
    // [] - групповой символ, {1,} - одно или более вхождений

    private static final Pattern SENTENCE_DELIMETER = Pattern.compile("[.!?]{1,}");

    @Override
    public Paragraph parseComponent(String str) throws ParserException {
        if(!ValidationStr.ifExist(str)) {
            throw new ParserException("Attention: input string is empty!");
        }

        str = str.replace("...", "[***].")
                .replace(".", "[*].")
                .replace("?", "[**]?")
                .replace("!", "[****]!");

        List<ComponentOfText> listOfSentences = new ArrayList<>();
        String[] strings = str.trim().split(SENTENCE_DELIMETER.pattern());

        for (String s : strings) {
            s = s.replace("[***][*]","...")
                    .replace("[***]","...")
                    .replace("[*]", ".")
                    .replace("[**]", "?")
                    .replace("[****]", "!");
            listOfSentences.add(parseNext(s));
        }
        Paragraph paragraph = new Paragraph(listOfSentences);
        return paragraph;
    }

}
