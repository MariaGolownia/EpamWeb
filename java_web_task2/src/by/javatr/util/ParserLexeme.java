package by.javatr.util;
import by.javatr.entity.Component;
import by.javatr.entity.Lexeme;
import by.javatr.valid.ValidationStr;
import jdk.nashorn.internal.runtime.ParserException;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class ParserLexeme extends ParserComponent<Component>{
    private static Logger LOGGER = Logger.getLogger(ParserLexeme.class);

    @Override
    public Lexeme parseComponent(String str) throws ParserException {
        if(!ValidationStr.ifExist(str)) {
            throw new ParserException("Attention: input string is empty!");
        }
        List<Component> listOfLeafs = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            String s = String.valueOf(str.charAt(i));
            listOfLeafs.add(parseNext(s));
        }
        Lexeme lexeme = new Lexeme(listOfLeafs);
        return lexeme;
    }


}
