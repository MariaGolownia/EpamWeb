package by.javatr.webparsing.dao;
import by.javatr.webparsing.util.UnMarshalGem;
import by.javatr.webparsing.valid.ValidatorSAX;
import by.javatr.webparsing.valid.ValidatorSAXXSD;

public class ParserCreator {

    public ParserCreator (String parserType, String xmlFileName, String xsdSchemaName, String logName) {
        ParserType sign = ParserType.valueOf(parserType.toUpperCase());
        switch(sign) {
            //case DOM: return new DOMParser();
            case SAX: {
                System.out.println("\nValidation SAX:");
                ValidatorSAX validatorSAX = new ValidatorSAX(xmlFileName, xsdSchemaName, logName);
                System.out.println("\nValidation SAXXSD:");
                ValidatorSAXXSD validatorSAXXSD = new ValidatorSAXXSD(xmlFileName, xsdSchemaName, logName);
                UnMarshalGem unMarshalGem = new UnMarshalGem(xmlFileName, xsdSchemaName);}
            //case STAX: return new StaxParser();
            default : throw new EnumConstantNotPresentException(ParserType.class, sign.name());
        }
    }
}
