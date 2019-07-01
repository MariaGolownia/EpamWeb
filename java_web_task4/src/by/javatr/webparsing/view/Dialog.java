package by.javatr.webparsing.view;
import by.javatr.webparsing.dao.GemsDAO;
import by.javatr.webparsing.dao.ParserFactory;
import by.javatr.webparsing.service.entity.Gem;
import by.javatr.webparsing.service.parser.GemsDOMParser;
import by.javatr.webparsing.service.parser.GemsSAXParser;
import by.javatr.webparsing.service.parser.GemsSTAXParser;
import by.javatr.webparsing.service.parser.Parser;
import by.javatr.webparsing.service.util.ValidationException;
import org.apache.log4j.Logger;
import java.util.List;
/**
 * Dialog is designed to communicate with the user
 * **/
public class Dialog {
    private String xmlFileName;

    private static Logger LOGGER = Logger.getLogger(Dialog.class);
    public Dialog(String xmlFileName) {
        this.xmlFileName = xmlFileName;
    }

    public Dialog() {
    }


    public GemsDAO getGemsDAOfromXML (ParserFactory.TypeParser typeParser){
        GemsDAO gemsDAOReturn = GemsDAO.getInstance();
        ParserFactory parserFactory = new ParserFactory();
        List<Gem> gemsDOM = null;


        if (typeParser.equals(ParserFactory.TypeParser.DOM)) {
            Parser gemsDOMParser = parserFactory.getParser(ParserFactory.TypeParser.DOM);
            ((GemsDOMParser)gemsDOMParser).buildListGems(xmlFileName);
            gemsDOM = ((GemsDOMParser)gemsDOMParser).getGems();
            GemsDAO gemsDAO = GemsDAO.getInstance();
            gemsDAO.setGems(gemsDOM);
            gemsDAOReturn = gemsDAO;}

        else if(typeParser.equals(ParserFactory.TypeParser.SAX)) {
            Parser gemsSAXParser = parserFactory.getParser(ParserFactory.TypeParser.SAX);
            ((GemsSAXParser)gemsSAXParser).buildSetGems(xmlFileName);
            List<Gem> gemsSAX = ((GemsSAXParser)gemsSAXParser).getGems();
            GemsDAO gemsDAO = GemsDAO.getInstance();
            gemsDAO.setGems(gemsSAX);
            gemsDAOReturn = gemsDAO;
        }
        else if(typeParser.equals(ParserFactory.TypeParser.STAX)) {
            Parser gemsSTAXParser = parserFactory.getParser(ParserFactory.TypeParser.STAX);
            ((GemsSTAXParser)gemsSTAXParser).buildSetGems(xmlFileName);
            List<Gem> gemsSTAX = ((GemsSTAXParser)gemsSTAXParser).getGems();
            GemsDAO gemsDAO = GemsDAO.getInstance();
            gemsDAO.setGems(gemsSTAX);
            gemsDAOReturn = gemsDAO;
        }
        else {
            try {
                throw new ValidationException("Check corectness name's parser!");
            } catch (ValidationException e) {
                e.printStackTrace();
            }
        }
        return gemsDAOReturn;
    }

    public void printToConsoleGemsDAOfromXML (GemsDAO gemsDAO){
        System.out.print(gemsDAO.toString());
    }

    public void printToConsoleGemsDAOfromXML (ParserFactory.TypeParser typeParser){
        GemsDAO gemsDAO = getGemsDAOfromXML(typeParser);
        System.out.print(gemsDAO.toString());
    }
}
