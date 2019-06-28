package by.javatr.task2.entity;
import org.apache.log4j.Logger;
import java.util.List;
/**
 * Class Lexeme.
 */
public class Lexeme extends CompositeText {
/* Lexeme  имеет возможность переопределить метод print() */
    private final static Logger LOGGER = Logger.getLogger(Lexeme.class);

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
    /**
     * Constructs an instance of this class.
     * @param listOfComponents describe
     */
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
}
