package by.javatr.webparsing.dao;
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

