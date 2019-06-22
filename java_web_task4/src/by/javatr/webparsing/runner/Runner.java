import by.javatr.webparsing.dao.GemsDAO;
import by.javatr.webparsing.entity.Gem;
import by.javatr.webparsing.parser.GemsDOMParser;
import by.javatr.webparsing.util.SAXUnMarshalGem;
import by.javatr.webparsing.valid.ValidatorSAX;
import by.javatr.webparsing.valid.ValidatorSAXXSD;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        String xmlFileName = "gems.xml";
        String xsdSchemaName = "gems.xsd";
        String logName = "logs/log.txt";

//        System.out.println("\nValidation SAX:");
//        ValidatorSAX validatorSAX = new ValidatorSAX(xmlFileName, xsdSchemaName, logName);
        System.out.println("\nValidation SAXXSD:");
        ValidatorSAXXSD validatorSAXXSD = new ValidatorSAXXSD(xmlFileName, xsdSchemaName, logName);
        SAXUnMarshalGem SAXUnMarshalGem = new SAXUnMarshalGem(xmlFileName, xsdSchemaName);

        //ParserFactory parserFactory = new ParserFactory("SAX", fileName, schemaName, logName);
        GemsDOMParser gemsDOMParser = new GemsDOMParser();
        gemsDOMParser.buildListGems(xmlFileName);
        List<Gem> gems = gemsDOMParser.getGems();
        GemsDAO gemsDAO = GemsDAO.getInstance();
        gemsDAO.setGems(gems);
        System.out.print("\n" + gemsDAO.toString());

    }





}
