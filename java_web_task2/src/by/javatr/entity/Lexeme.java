package by.javatr.entity;
import java.util.List;

// Lexeme  имеет возможность переопределить метод print()
public class Lexeme implements ComponentOfText {
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

    @Override
    public String toString() {
        return lexeme;
    }

    @Override
    public String print() {
        return this.toString();
    }

}
