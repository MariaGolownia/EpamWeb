package webparsing.service.parser;
import webparsing.service.entity.Gem;
import webparsing.service.entity.NaturalGem;
import webparsing.service.entity.SyntheticGem;
import webparsing.service.entity.VisualParameters;
import webparsing.service.util.Converter;
import webparsing.service.util.GemEnum;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GemsSTAXParser extends Parser{
    private List<Gem> gems = new ArrayList<>();
    private XMLInputFactory inputFactory;
    private VisualParameters visualParameters;

    public GemsSTAXParser() {
        inputFactory = XMLInputFactory.newInstance();
    }
    public List<Gem> getGems() {
        return gems;
    }

    public void buildSetGems(String fileName) {
        FileInputStream inputStream = null;
        XMLStreamReader reader = null;
        String name;
        try {
            inputStream = new FileInputStream(new File(fileName));
            reader = inputFactory.createXMLStreamReader(inputStream);
            // StAX parsing
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (GemEnum.valueOf(name.toUpperCase()) == GemEnum.NATURALGEM) {
                        Gem gem = buildNaturalGemGem(reader);
                        gems.add(gem);
                    }
                    else if (GemEnum.valueOf(name.toUpperCase()) == GemEnum.SYNTHETICGEM) {
                        Gem gem = buildSyntheticGemGem(reader);
                        gems.add(gem);
                    }
                }
            }
        } catch (XMLStreamException ex) {
            System.err.println("StAX parsing error! " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            System.err.println("File " + fileName + " not found! " + ex);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.err.println("Impossible close file "+fileName+" : "+e);
            }
        }
    }

    private Gem buildNaturalGemGem(XMLStreamReader reader) throws XMLStreamException {
        Gem gem = new NaturalGem();
        Converter converter = new Converter();
        gem.setId(reader.getAttributeValue(null, GemEnum.ID.getValue()));
        gem.setPreciousness(reader.getAttributeValue(null, GemEnum.PRECIOUSNESS.getValue()));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (GemEnum.valueOf(name.toUpperCase())) {
                        case NAME:
                            gem.setName(getXMLText(reader));
                            break;
                        case ID:
                            gem.setId(getXMLText(reader));
                            break;
                        case VALUEGR:
                            gem.setValueGr(Double.valueOf(getXMLText(reader)));
                            break;
                        case VISUALPARAMETERS:
                            visualParameters = new VisualParameters();
                            break;
                        case COLOR:
                            visualParameters.setColor(getXMLText(reader));
                            break;
                        case TRANSPARENCYPR:
                            visualParameters.setTransparencyPr(Double.valueOf(getXMLText(reader)));
                            break;
                        case FACESNUMBER:
                            visualParameters.setFacesNumber(Double.valueOf(getXMLText(reader)));
                            gem.setVisualParameters(visualParameters);
                            break;
                        case ORIGINTREATMENT:
                            gem.setOriginTreatment(getXMLText(reader));
                            break;
                        case TREATER:
                            gem.setOriginTreatment(getXMLText(reader));
                            break;
                        case DATETREATMENT:
                            gem.setDateTreatment(converter.convertStringToXMLGregorianCalendar(getXMLText(reader)));
                            break;
                        case ORIGINEXTRACTION:
                            ((NaturalGem)gem).setOriginExtraction(getXMLText(reader));
                            break;
                        case DATEEXTRACTION:
                            ((NaturalGem) gem).setDateExtraction(converter.
                                    convertStringToXMLGregorianCalendar(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (GemEnum.valueOf(name.toUpperCase()) == GemEnum.NATURALGEM) {
                        return gem;
                    }
                    else {}
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Student");
    }

    private Gem buildSyntheticGemGem(XMLStreamReader reader) throws XMLStreamException {
        Gem gem = new SyntheticGem();
        Converter converter = new Converter();
        gem.setId(reader.getAttributeValue(null, GemEnum.ID.getValue()));
        gem.setPreciousness(reader.getAttributeValue(null, GemEnum.PRECIOUSNESS.getValue()));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (GemEnum.valueOf(name.toUpperCase())) {
                        case NAME:
                            gem.setName(getXMLText(reader));
                            break;
                        case ID:
                            gem.setId(getXMLText(reader));
                            break;
                        case VALUEGR:
                            gem.setValueGr(Double.valueOf(getXMLText(reader)));
                            break;
                        case VISUALPARAMETERS:
                            visualParameters = new VisualParameters();
                            break;
                        case COLOR:
                            visualParameters.setColor(getXMLText(reader));
                            break;
                        case TRANSPARENCYPR:
                            visualParameters.setTransparencyPr(Double.valueOf(getXMLText(reader)));
                            break;
                        case FACESNUMBER:
                            visualParameters.setFacesNumber(Double.valueOf(getXMLText(reader)));
                            gem.setVisualParameters(visualParameters);
                            break;
                        case ORIGINTREATMENT:
                            gem.setOriginTreatment(getXMLText(reader));
                            break;
                        case TREATER:
                            gem.setOriginTreatment(getXMLText(reader));
                            break;
                        case DATETREATMENT:
                            gem.setDateTreatment(converter.convertStringToXMLGregorianCalendar(getXMLText(reader)));
                            break;
                        case MANUFACTURINGMETHOD:
                            ((SyntheticGem)gem).
                                    setManufacturingMethodOrProcessingMethod(converter.convertStringToListJAX(getXMLText(reader)));
                            break;
                        case PROCESSINGMETHOD:
                            ((SyntheticGem)gem).
                                    setManufacturingMethodOrProcessingMethod(converter.convertStringToListJAX(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (GemEnum.valueOf(name.toUpperCase()) == GemEnum.SYNTHETICGEM) {
                        return gem;
                    }
                    else {}
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Student");
    }


    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }

}
