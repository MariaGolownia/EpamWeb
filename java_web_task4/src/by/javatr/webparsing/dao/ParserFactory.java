package by.javatr.webparsing.dao;
import by.javatr.webparsing.service.parser.GemsSAXParser;
import by.javatr.webparsing.service.parser.GemsSTAXParser;
import by.javatr.webparsing.service.parser.Parser;
import by.javatr.webparsing.service.parser.GemsDOMParser;
import by.javatr.webparsing.service.util.ValidationException;

public class ParserFactory {

    public enum TypeParser {
        SAX, STAX, DOM
    }

    public Parser getParser (TypeParser type) {
        switch (type) {
            case DOM:
                return new GemsDOMParser();
            case STAX:
                return new GemsSTAXParser();
            case SAX:
                return new GemsSAXParser();
            default:
                throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
        }
    }

    public Parser getParser (String type) {
        switch (type) {
            case "DOM":
                return new GemsDOMParser();
            case "STAX":
                return new GemsSTAXParser();
            case "SAX":
                return new GemsSAXParser();
            default:
                return new GemsDOMParser();
        }
    }
}



