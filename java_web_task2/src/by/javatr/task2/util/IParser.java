package by.javatr.task2.util;
import jdk.nashorn.internal.runtime.ParserException;

public interface IParser<T> {

    T parseComponent(String str) throws ParserException;
}
