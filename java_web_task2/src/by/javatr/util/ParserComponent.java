package by.javatr.util;
import jdk.nashorn.internal.runtime.ParserException;

// Класс для связи с другими парсерами

public abstract class ParserComponent<T> implements IParser<T> {
    private IParser next;

    public ParserComponent() {
    }

    public IParser<T> setParser (IParser <T> parser) {
        return this.next = parser;
    }

//---------------------------------------------------------------------------------------------

    public T parseNext(String str) throws ParserException {
       if (str != null) {
            return (T) next.parseComponent(str);
       }
       return this.parseComponent(str);
    }
}
