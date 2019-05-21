package by.javatr.util;
import by.javatr.entity.Leaf;
import by.javatr.entity.Component;
import jdk.nashorn.internal.runtime.ParserException;

public class ParserLeaf implements IParser <Component> {
    @Override
    public Leaf parseComponent(String str)  {
        return new Leaf(str);
    }
}
