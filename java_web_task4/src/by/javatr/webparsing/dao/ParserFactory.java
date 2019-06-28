package by.javatr.webparsing.dao;
<<<<<<< HEAD
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
=======
import by.javatr.webparsing.parser.Builder;
import by.javatr.webparsing.parser.GemsDOMParser;

public class ParserFactory {

        private enum TypeParser {
            SAX, STAX, DOM
        }


        public Builder getBuilder (TypeParser type) {
            switch (type) {
                case DOM:
                    return new GemsDOMParser();
                case STAX:
                    return new GemsDOMParser();
                    //return new GemsStAXBuilder();
                case SAX:
                    return new GemsDOMParser();
                    //return new SAXStAXBuilder();
                default:
                    throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
            }
        }
    }
>>>>>>> 7866105f43e6b95699e903769a3c89d6dc70b67c

