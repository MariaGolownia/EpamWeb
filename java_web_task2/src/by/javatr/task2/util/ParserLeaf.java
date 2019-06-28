package by.javatr.task2.util;
import by.javatr.task2.entity.Leaf;
import by.javatr.task2.entity.Component;
import org.apache.log4j.Logger;

public class ParserLeaf implements IParser<Component> {
    private static Logger LOGGER = Logger.getLogger(ParserLeaf.class);
    @Override
    public Leaf parseComponent(String str)  {
        return new Leaf(str);
    }
}
