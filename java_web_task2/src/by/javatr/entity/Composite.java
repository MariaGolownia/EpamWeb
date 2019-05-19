package by.javatr.entity;

import java.util.ArrayList;
import java.util.List;

// Composite получает доступ к методу print () интерфейса ComponentOfText

public abstract class Composite implements ComponentOfText {

    protected List<ComponentOfText> listOfComponents = new ArrayList<>();

    public Composite() {
    }

    public Composite(List<ComponentOfText>listOfComponents) {
        this.listOfComponents = listOfComponents;
    }

    public void add(Composite composite) {
        listOfComponents.add(composite);
    }

    public List<ComponentOfText> getList() {
        return listOfComponents;
    }

    public ComponentOfText get(int index) {
        return listOfComponents.get(index);
    }
}
