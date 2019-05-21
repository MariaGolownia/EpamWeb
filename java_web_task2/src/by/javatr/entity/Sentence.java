package by.javatr.entity;
import java.util.List;

// Sentence имеет доступ ко всем методам класса Composite и возможность переопределить метод print()
public class Sentence extends Composite {

    public Sentence() {
    }

    public Sentence(List<Component> listOfComponents) {
        super(listOfComponents);
    }

    // Предложения состоят из слов
    @Override
    public String toText() {
        String str = "";
        for (Component component : listOfComponents) {
            str += component.toText() + " ";
        }
        return str;
    }
}
