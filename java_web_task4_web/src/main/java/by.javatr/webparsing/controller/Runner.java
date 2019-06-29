package by.javatr.webparsing.controller;
import by.javatr.webparsing.service.valid.ValidatorSAX;
import lombok.extern.log4j.Log4j2;
import org.apache.log4j.PropertyConfigurator;
import by.javatr.webparsing.dao.ParserFactory;
import by.javatr.webparsing.service.util.SAXUnMarshalGem;
import by.javatr.webparsing.service.valid.ValidatorSAXXSD;
import by.javatr.webparsing.view.Dialog;


@Log4j2
public class Runner {
    public static void main(String[] args) {
        String log4jConfPath = "log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);

        String xmlFileName = "gems.xml";
        String xsdSchemaName = "gems.xsd";
         String logName = "logs/log.txt";

        System.out.println("\nValidation SAXXSD:");
        ValidatorSAXXSD validatorSAXXSD = new ValidatorSAXXSD(xmlFileName, xsdSchemaName, logName);
        SAXUnMarshalGem SAXUnMarshalGem = new SAXUnMarshalGem(xmlFileName, xsdSchemaName);

        System.out.println("----------------------------------------------------------------");
        System.out.println("DOM-PARSER:");
        System.out.println("----------------------------------------------------------------");
        Dialog dialog = new Dialog(xmlFileName);
        dialog.printToConsoleGemsDAOfromXML(ParserFactory.TypeParser.DOM);

        System.out.println("\n----------------------------------------------------------------");
        System.out.println("SAX-PARSER:");
        System.out.println("----------------------------------------------------------------");
        dialog.printToConsoleGemsDAOfromXML(ParserFactory.TypeParser.SAX);

        System.out.println("\n----------------------------------------------------------------");
        System.out.println("STAX-PARSER:");
        System.out.println("----------------------------------------------------------------");
        dialog.printToConsoleGemsDAOfromXML(ParserFactory.TypeParser.STAX);





 //        ParserFactory parserFactory = new ParserFactory();
//        Parser gemsDOMParser = parserFactory.getParser(ParserFactory.TypeParser.DOM);
//        ((GemsDOMParser)gemsDOMParser).buildListGems(xmlFileName);
//        List<Gem> gemsDOM = ((GemsDOMParser)gemsDOMParser).getGems();
//        GemsDAO gemsDAO = GemsDAO.getInstance();
//        gemsDAO.setGems(gemsDOM);
//        System.out.print(gemsDAO.toString());

//        Parser gemsSAXParser = parserFactory.getParser(ParserFactory.TypeParser.SAX);
//        ((GemsSAXParser)gemsSAXParser).buildSetGems(xmlFileName);
//        List<Gem> gemsSAX = ((GemsSAXParser)gemsSAXParser).getGems();
//        gemsDAO.setGems(gemsSAX);
//        System.out.print(gemsDAO.toString());

//        Parser gemsSTAXParser = parserFactory.getParser(ParserFactory.TypeParser.STAX);
//        ((GemsSTAXParser)gemsSTAXParser).buildSetGems(xmlFileName);
//        List<Gem> gemsSTAX = ((GemsSTAXParser)gemsSTAXParser).getGems();
//        gemsDAO.setGems(gemsSTAX);
//        System.out.print(gemsDAO.toString());

//        System.out.println("\nValidation SAX:");
//        ValidatorSAX validatorSAX = new ValidatorSAX(xmlFileName, xsdSchemaName, logName);
    }
}
