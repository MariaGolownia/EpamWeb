package by.javatr.webparsing.parser;
import by.javatr.webparsing.entity.Gem;
import by.javatr.webparsing.entity.NaturalGem;
import by.javatr.webparsing.entity.ObjectFactory;
import by.javatr.webparsing.entity.SyntheticGem;
import by.javatr.webparsing.util.Converter;
import by.javatr.webparsing.util.GemEnum;
import by.javatr.webparsing.util.ValidationException;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.bind.JAXBElement;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class SAXHandler extends DefaultHandler {
    private List<Gem> gems;
    private Gem current = null;
    private GemEnum currentEnum = null;
    private EnumSet<GemEnum> withText;

    public SAXHandler() {
        gems = new ArrayList<>();
        //???????withText = EnumSet.range(GemEnum.ID, GemEnum.PRECIOUSNESS);
    }
    public List<Gem> getGems() {
        return gems;
    }
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if ("gem".equals(localName)) {
            current = new Gem();
            GemEnum temp = GemEnum.valueOf(localName.toUpperCase());
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }
        else if ("naturalGem".equals(localName)) {
            current = new NaturalGem();
            GemEnum temp = GemEnum.valueOf(localName.toUpperCase());
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }
        else {
            current = new SyntheticGem();
            GemEnum temp = GemEnum.valueOf(localName.toUpperCase());
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if ("gem".equals(localName)) {
            gems.add(current);
        }
        else if ("naturalGem".equals(localName)) {
            gems.add(current);
        }
        else if ("syntheticGem".equals(localName)) {
            gems.add(current);
        }
        else {
            try {
                throw  new ValidationException("Error type gem!");
            } catch (ValidationException e) {
                e.printStackTrace();
            }
        }
    }

    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim();
        Converter converter = new Converter();
        if (currentEnum != null) {
            switch (currentEnum) {
                case NAME:
                    current.setName(s);
                    break;
                case ID:
                    current.setId(s);
                    break;
                case ORIGINTREATMENT:
                    current.setOriginTreatment(s);
                    break;
                case TREATER:
                    current.setTreater(s);
                    break;
                case DATETREATMENT:
                    current.setDateTreatment(converter.convertStringToXMLGregorianCalendar(s));
                    break;
                case ORIGINEXTRACTION:
                    ((NaturalGem)current).setOriginExtraction(s);
                    break;
                case DATEEXTRACTION:
                    ((NaturalGem)current).setDateExtraction(converter.convertStringToXMLGregorianCalendar(s));
                    break;
                case MANUFACTURINGMETHOD:
                {

                }
                    ((SyntheticGem)current).setManufacturingMethodOrProcessingMethod(s);
                    break;
                case PROCESSINGMETHOD:
                    ((SyntheticGem)current).setManufacturingMethodOrProcessingMethod(s);
                    break;
                default:
                    throw new EnumConstantNotPresentException(
                            currentEnum.getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;
    }
}