package by.javatr.entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Composite получает доступ к методу print () интерфейса ComponentOfText

public abstract class Composite implements Component {

    protected List<Component> listOfComponents = new ArrayList<>();

    public Composite() {
    }

    public Composite(List<Component>listOfComponents) {
        this.listOfComponents = listOfComponents;
    }

    public void add(Composite composite) {
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
        if (!(o instanceof Composite)) return false;
        Composite composite = (Composite) o;
        return listOfComponents.equals(composite.listOfComponents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listOfComponents);
    }
}
