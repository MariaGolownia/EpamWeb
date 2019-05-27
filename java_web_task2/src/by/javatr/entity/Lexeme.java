package by.javatr.entity;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Objects;

// Lexeme  имеет возможность переопределить метод print()
public class Lexeme extends CompositeText {
    private static Logger LOGGER = Logger.getLogger(Lexeme.class);

    private String lexeme;

    public Lexeme() {
    }

    public Lexeme(String lexeme) {
        LOGGER.debug("Start Lexeme constructor");
        this.lexeme = lexeme;
    }


    public String getLexeme() {
        LOGGER.debug("Start Lexeme getLexeme");
        return lexeme;
    }

    public void setLexeme(String lexeme) {
        LOGGER.debug("Start Lexeme setLexeme");
        this.lexeme = lexeme;
    }

    public Lexeme(List<Component> listOfComponents) {
        super(listOfComponents);
        LOGGER.debug("Start Lexeme constructor");
    }

        @Override
    public String toText() {
            LOGGER.debug("Start Lexeme toText");
            String str = "";
            for (Component component : listOfComponents) {
                str += component.toText();
            }
            return str;
    }

//    @Override
//    public String toText() {
//        return this.toString();
//    }

//    @Override
//    public String toString() {
//        return lexeme ;
//    }
}
