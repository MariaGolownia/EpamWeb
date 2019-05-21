package by.javatr.entity;
import java.util.List;
import java.util.Objects;

// Lexeme  имеет возможность переопределить метод print()
public class Lexeme extends Composite {

    private String lexeme;

    public Lexeme() {
    }

    public Lexeme(String lexeme) {
        this.lexeme = lexeme;
    }


    public String getLexeme() {
        return lexeme;
    }

    public void setLexeme(String lexeme) {
        this.lexeme = lexeme;
    }

    public Lexeme(List<Component> listOfComponents) {
        super(listOfComponents);
    }

        @Override
    public String toText() {
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
