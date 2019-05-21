package by.javatr.entity;
import java.util.List;

// Paragraph  имеет доступ ко всем методам класса Composite и возможность переопределить метод print()
public class Paragraph extends Composite {

    public Paragraph() {
    }

    public Paragraph(List <Component> listOfComponents) {
        super(listOfComponents);
    }

    // Параграфы состоят из предложений и собираются их соединением через точку. После точки всегда следует пробел
    @Override
    public String toText() {
      String str = "";
      for (Component component : listOfComponents) {
          str += component.toText() + " ";
      }
      return str;
    }

}
