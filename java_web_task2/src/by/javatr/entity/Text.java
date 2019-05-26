package by.javatr.entity;

import java.util.List;

public class Text extends CompositeText {
    public Text() {
    }

    public Text(List<Component> list) {
        super(list);
    }

    // Параграфы начинаются с табуляции и заканчиваются переходом на новую строку
    @Override
    public String toText() {
        String str = "";
        for (Component component : listOfComponents) {
            str += "\t" + component.toText() + "\n";
        }
        return str;
    }

}
