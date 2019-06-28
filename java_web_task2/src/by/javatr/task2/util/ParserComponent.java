package by.javatr.task2.util;
import jdk.nashorn.internal.runtime.ParserException;
import org.apache.log4j.Logger;

// Класс для связи с другими парсерами

public abstract class ParserComponent<T> implements IParser<T> {
    private static Logger LOGGER = Logger.getLogger(ParserComponent.class);

    private IParser next;

    public ParserComponent() {
    }

    public IParser<T> setNext (IParser <T> parser){
        return this.next = parser;
    }


    public T parseNext(String str) throws ParserException {
       if (str != null) {
            return (T) next.parseComponent(str);
       }
       return this.parseComponent(str);
    }
}
