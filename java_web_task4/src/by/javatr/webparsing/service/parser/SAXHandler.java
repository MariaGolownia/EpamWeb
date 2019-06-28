package by.javatr.webparsing.service.parser;
import by.javatr.webparsing.service.entity.Gem;
import by.javatr.webparsing.service.entity.NaturalGem;
import by.javatr.webparsing.service.entity.SyntheticGem;
import by.javatr.webparsing.service.entity.VisualParameters;
import by.javatr.webparsing.service.util.Converter;
import by.javatr.webparsing.service.util.GemEnum;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class SAXHandler extends DefaultHandler {
    private List<Gem> gems;
    private Gem current = null;
    private GemEnum currentEnum = null;
    private EnumSet<GemEnum> withText;
    private VisualParameters visualParameters;

    public SAXHandler() {
        gems = new ArrayList<>();
        withText = EnumSet.range(GemEnum.ID, GemEnum.PROCESSINGMETHOD);
    }
    public List<Gem> getGems() {
        return gems;
    }
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if ("syntheticGem".equals(localName)) {
            current = new SyntheticGem();
            current.setId(attrs.getValue(0));
            current.setPreciousness(attrs.getValue(1));
       }
        else if ("naturalGem".equals(localName)) {
            current = new NaturalGem();
            current.setId(attrs.getValue(0));
            current.setPreciousness(attrs.getValue(1));
        }
        else {
            GemEnum temp = GemEnum.valueOf(localName.toUpperCase());
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if ("visualParameters".equals(localName)) {
            current.setVisualParameters(visualParameters);
        }
        else if ("gem".equals(localName)) {
            gems.add(current);
        }
        else if ("naturalGem".equals(localName)) {
            gems.add(current);
        }
        else if ("syntheticGem".equals(localName)) {
            gems.add(current);
        }
        else {return;}
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
                case VALUEGR:
                    current.setValueGr(Double.valueOf(s));
                    break;
                case VISUALPARAMETERS:
                    visualParameters = new VisualParameters();
                    break;
                case COLOR:
                    visualParameters.setColor(s);
                    break;
                case TRANSPARENCYPR:
                    visualParameters.setTransparencyPr(Double.valueOf(s));
                    break;
                case FACESNUMBER:
                    visualParameters.setFacesNumber(Double.valueOf(s));
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
                    ((SyntheticGem)current).
                            setManufacturingMethodOrProcessingMethod(converter.convertStringToListJAX(s));
                    break;
                case PROCESSINGMETHOD:
                    ((SyntheticGem)current).
                            setManufacturingMethodOrProcessingMethod(converter.convertStringToListJAX(s));
                    break;
                default:
                    throw new EnumConstantNotPresentException(
                            currentEnum.getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;
    }
}