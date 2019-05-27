package by.javatr.entity;
import org.apache.log4j.Logger;
import java.util.List;

public class Text extends CompositeText {
    private static Logger LOGGER = Logger.getLogger(Text.class);

    public Text() {
    }

    public Text(List<Component> list) {
        super(list);
    }

    // Параграфы начинаются с табуляции и заканчиваются переходом на новую строку
    @Override
    public String toText() {
        String str = "";
        //for (Component component : listOfComponents) {
        for (int i = 0; i < listOfComponents.size(); i++)  {

            str += "\t" + listOfComponents.get(i).toText();
            if (i!=listOfComponents.size()-1)
                str+="\n";
        }
        return str;
    }

}
