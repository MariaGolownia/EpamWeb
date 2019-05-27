package by.javatr.util;
import by.javatr.entity.Leaf;
import by.javatr.entity.Component;
import org.apache.log4j.Logger;

public class ParserLeaf implements IParser<Component> {
    private static Logger LOGGER = Logger.getLogger(ParserLeaf.class);
    @Override
    public Leaf parseComponent(String str)  {
        return new Leaf(str);
    }
}
