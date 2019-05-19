package by.javatr.entity;
import java.util.List;

// Sentence имеет доступ ко всем методам класса Composite и возможность переопределить метод print()
public class Sentence extends Composite {

    public Sentence() {
    }

    public Sentence(List<ComponentOfText> listOfComponents) {
        super(listOfComponents);
    }

    // Предложения состоят из слов
    @Override
    public String print() {
        String str = "";
        for (ComponentOfText componentOfText : listOfComponents) {
            str += componentOfText.print() + " ";
        }
        return str;
    }
}
