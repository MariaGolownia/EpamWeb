package by.javatr.entity;
import java.util.List;

// Paragraph  имеет доступ ко всем методам класса Composite и возможность переопределить метод print()
public class Paragraph extends Composite {

    public Paragraph() {
    }

    public Paragraph(List <ComponentOfText> listOfComponents) {
     super(listOfComponents);
    }

    // Параграфы состоят из предложений и собираются их соединением через точку. После точки всегда следует пробел
    @Override
    public String print() {
      String str = "";
      for (ComponentOfText componentOfText : listOfComponents) {
          str += componentOfText.print() + " ";
      }
      return str;
    }
}
