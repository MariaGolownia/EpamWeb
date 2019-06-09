package by.javatr.task2.entity;
import org.apache.log4j.Logger;

import java.util.List;

// Paragraph  имеет доступ ко всем методам класса Composite и возможность переопределить метод print()
public class Paragraph extends CompositeText {
    private static Logger LOGGER = Logger.getLogger(Paragraph.class);

    public Paragraph() {
    }

    public Paragraph(List <Component> listOfComponents) {
       super(listOfComponents);
        LOGGER.debug("Start Paragraph constructor");
    }

    // Параграфы состоят из предложений и собираются их соединением через точку. После точки всегда следует пробел
    @Override
    public String toText() {
        LOGGER.debug("Start Paragraph toText");
      String str = "";
      for (Component component : listOfComponents) {
          str += component.toText();
      }
      return str.trim();
    }

}
