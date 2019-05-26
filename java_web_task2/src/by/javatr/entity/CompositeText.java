package by.javatr.entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Composite получает доступ к методу print () интерфейса ComponentOfText

public abstract class CompositeText implements Component {

    protected List<Component> listOfComponents = new ArrayList<>();

    public CompositeText() {
    }

    public CompositeText(List<Component>listOfComponents) {
        this.listOfComponents = listOfComponents;
    }

    public void add(CompositeText composite) {
        listOfComponents.add(composite);
    }

    public List<Component> getList() {
        return listOfComponents;
    }

    public Component get(int index) {
        return listOfComponents.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompositeText)) return false;
        CompositeText composite = (CompositeText) o;
        return listOfComponents.equals(composite.listOfComponents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listOfComponents);
    }
}
