package by.javatr.util;
import by.javatr.entity.Composite;
import jdk.nashorn.internal.runtime.ParserException;

public interface IParser<T> {

    T parseComponent(String str) throws ParserException;
}
