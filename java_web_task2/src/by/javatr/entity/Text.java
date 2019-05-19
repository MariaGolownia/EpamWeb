package by.javatr.entity;

import java.util.List;

public class Text extends Composite {
    public Text() {
    }

    public Text(List<ComponentOfText> list) {
        super(list);
    }

    // Параграфы начинаются с табуляции и заканчиваются переходом на новую строку
    @Override
    public String print() {
        String str = "";
        for (ComponentOfText componentOfText : listOfComponents) {
            str += "\t" + componentOfText.print() + "\n";
        }
        return str;
    }
}
