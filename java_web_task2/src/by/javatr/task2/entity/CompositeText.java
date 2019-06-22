package by.javatr.task2.entity;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**
 * Class CompositeText.
 */
public abstract class CompositeText implements Component {
    // Composite получает доступ к методу print () интерфейса ComponentOfText
    private static Logger LOGGER = Logger.getLogger(CompositeText.class);

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

}
