package by.javatr.webparsing.service.parser;
import by.javatr.webparsing.service.entity.*;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GemsDOMParser extends Parser {
    private static Logger LOGGER = Logger.getLogger(GemsDOMParser.class);
    private List<Gem> gems;
    private DocumentBuilder docBuilder;
    private static final String NATURAL_GEM = "naturalGem";
    private static final String SYNTHETIC_GEM = "syntheticGem";

    public GemsDOMParser() {
     //   LOGGER.debug("Start GemsDOMParser");
        String xmlFileName = "gems.xml";
        String xsdSchemaName = "gems.xsd";
        String logName = "logs/log.txt";
        this.gems = new ArrayList<>();
        // создание DOM-анализатора
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory schemaFactory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(xsdSchemaName);
        try {
            Schema schema = schemaFactory.newSchema(schemaLocation);
            factory.setSchema(schema);
            factory.setNamespaceAware(true);
        } catch (SAXException e) {
            e.printStackTrace();
        }
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.err.println("Ошибка конфигурации парсера: " + e);
        }
    }

    public List<Gem> getGems() {
        return gems;
    }

    public void buildListGems(String fileName) {
    //    LOGGER.debug("Start buildListGems");
        Document doc = null;
        try {
            // parsing XML-документа и создание древовидной структуры
            docBuilder.setErrorHandler(new GemErrorHandler());
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            NodeList gemsListNaturalGem = root.getElementsByTagName("naturalGem");
            NodeList gemsListSyntheticGem = root.getElementsByTagName("syntheticGem");
            for (int i = 0; i < gemsListNaturalGem.getLength(); i++) {
                Element gemElement = (Element) gemsListNaturalGem.item(i);
                    Gem gem = buildNaturalGem(gemElement);
                    gems.add(gem);
                }
            for (int i = 0; i < gemsListSyntheticGem.getLength(); i++) {
                Element gemElement = (Element) gemsListSyntheticGem.item(i);
                Gem gem = buildSyntheticGem(gemElement);
                gems.add(gem);
            }
        } catch (IOException e) {
            System.err.println("File error or I/O error: " + e);
        } catch (SAXException e) {
            System.err.println("Parsing failure: " + e);
        }
    }
    private Gem buildNaturalGem(Element gemElement) {
//      <naturalGem id ="d1" preciousness = "precious" >
//        <name>diamond</name>
//        <valueGr>1.512</valueGr>
//        <visualParameters>
//            <color>colorless</color>
//            <transparencyPr>20.99</transparencyPr>
//            <facesNumber>15</facesNumber>
//        </visualParameters>
//        <originTreatment>France</originTreatment>
//        <treater>Limited liability company Dimond</treater>
//        <dateTreatment>1991-11-20</dateTreatment>
//        <originExtraction>Russia</originExtraction>
//        <dateExtraction>1990-02-20</dateExtraction>
//    </naturalGem>

         Gem gem = new NaturalGem();
        // заполнение объекта gem
        //      <naturalGem id ="d1" preciousness = "precious" >
        gem.setId(gemElement.getAttribute("id"));
        LOGGER.debug(gemElement.getAttribute("id"));

        //      <naturalGem id ="d1" preciousness = "precious" >
        gem.setPreciousness(gemElement.getAttribute("preciousness"));
        LOGGER.debug(gemElement.getAttribute("preciousness"));

        //        <name>diamond</name>
        String nameOfGem = String.valueOf(getElementTextContent(gemElement, "name"));
        gem.setName(nameOfGem);
        LOGGER.debug(nameOfGem);

        //        <valueGr>1.512</valueGr>
        Double valueGr = Double.valueOf(getElementTextContent(
                gemElement, "valueGr"));
        gem.setValueGr(valueGr);
        LOGGER.debug(valueGr);

        //        <visualParameters>
        //            <color>colorless</color>
        //            <transparencyPr>20.99</transparencyPr>
        //            <facesNumber>15</facesNumber>
        //        </visualParameters>
        VisualParameters visualParameters = new VisualParameters();
        Element visualParametersElement = (Element) gemElement.getElementsByTagName("visualParameters").item(0);
        visualParameters.setColor(getElementTextContent(visualParametersElement, "color"));
        LOGGER.debug(getElementTextContent(visualParametersElement, "color"));

        visualParameters.setTransparencyPr(Double.valueOf(getElementTextContent(visualParametersElement, "transparencyPr")));
        LOGGER.debug(getElementTextContent(visualParametersElement, "transparencyPr"));

        visualParameters.setFacesNumber(Double.valueOf(getElementTextContent(visualParametersElement, "facesNumber")));
        LOGGER.debug(getElementTextContent(visualParametersElement, "facesNumber"));
        gem.setVisualParameters(visualParameters);

        //        <originTreatment>France</originTreatment>
        String originTreatmentGem = String.valueOf(getElementTextContent(gemElement, "originTreatment"));
        gem.setOriginTreatment(originTreatmentGem);
        LOGGER.debug(originTreatmentGem);

        //        <treater>Limited liability company Dimond</treater>
        String treaterGem = String.valueOf(getElementTextContent(gemElement, "treater"));
        gem.setTreater(treaterGem);
        LOGGER.debug(treaterGem);

        //        <dateTreatment>1991-11-20</dateTreatment>
        try {
            XMLGregorianCalendar resultDateTreatment = DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar(getElementTextContent(gemElement, "dateTreatment"));
            gem.setDateTreatment(resultDateTreatment);
            LOGGER.debug(resultDateTreatment);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }

        //        <originExtraction>Russia</originExtraction>
        String originExtractionGem = String.valueOf(getElementTextContent(gemElement, "originExtraction"));
        ((NaturalGem) gem).setOriginExtraction(originExtractionGem);
        LOGGER.debug(originExtractionGem);

        //        <dateExtraction>1990-02-20</dateExtraction>
        try {
            XMLGregorianCalendar resultDateExtraction = DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar(getElementTextContent(gemElement, "dateExtraction"));
            ((NaturalGem) gem).setDateExtraction(resultDateExtraction);
            LOGGER.debug(resultDateExtraction);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        return gem;
    }

    private Gem buildSyntheticGem(Element gemElement) {
//        <syntheticGem id="d3" preciousness = "precious">
//        <name>diamond</name>
//        <valueGr>3.010</valueGr>
//        <visualParameters>
//            <color>colorless</color>
//            <transparencyPr>89.9</transparencyPr>
//            <facesNumber>13</facesNumber>
//        </visualParameters>
//        <originTreatment>France</originTreatment>
//        <treater>Limited liability company Dimond</treater>
//        <dateTreatment>1992-02-05</dateTreatment>
//        <manufacturingMethod>Hydrothermal method</manufacturingMethod>
//    </syntheticGem>
        Gem gem = new SyntheticGem();
        // заполнение объекта gem
        //      <naturalGem id ="d1" preciousness = "precious" >
        gem.setId(gemElement.getAttribute("id"));
        LOGGER.debug(gemElement.getAttribute("id"));
        gem.setPreciousness(gemElement.getAttribute("preciousness"));
        LOGGER.debug(gemElement.getAttribute("preciousness"));

        //        <name>diamond</name>
        String nameOfGem = String.valueOf(getElementTextContent(gemElement, "name"));
        gem.setName(nameOfGem);
        LOGGER.debug(nameOfGem);

        //        <valueGr>1.512</valueGr>
        Double valueGr = Double.valueOf(getElementTextContent(
                gemElement, "valueGr"));
        gem.setValueGr(valueGr);
        LOGGER.debug(valueGr);

        //        <visualParameters>
        //            <color>colorless</color>
        //            <transparencyPr>20.99</transparencyPr>
        //            <facesNumber>15</facesNumber>
        //        </visualParameters>
        VisualParameters visualParameters = new VisualParameters();
        Element visualParametersElement = (Element) gemElement.getElementsByTagName("visualParameters").item(0);
        visualParameters.setColor(getElementTextContent(visualParametersElement, "color"));
        LOGGER.debug(getElementTextContent(visualParametersElement, "color"));

        visualParameters.setTransparencyPr(Double.valueOf(getElementTextContent(visualParametersElement, "transparencyPr")));
        LOGGER.debug(getElementTextContent(visualParametersElement, "transparencyPr"));

        visualParameters.setFacesNumber(Double.valueOf(getElementTextContent(visualParametersElement, "facesNumber")));
        LOGGER.debug(getElementTextContent(visualParametersElement, "facesNumber"));
        gem.setVisualParameters(visualParameters);

        //        <originTreatment>France</originTreatment>
        String originTreatmentGem = String.valueOf(getElementTextContent(gemElement, "originTreatment"));
        gem.setOriginTreatment(originTreatmentGem);
        LOGGER.debug(originTreatmentGem);

        //        <treater>Limited liability company Dimond</treater>
        String treaterGem = String.valueOf(getElementTextContent(gemElement, "treater"));
        gem.setTreater(treaterGem);
        LOGGER.debug(treaterGem);

        //        <dateTreatment>1991-11-20</dateTreatment>
        try {
            XMLGregorianCalendar resultDateTreatment = DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar(getElementTextContent(gemElement, "dateTreatment"));
            gem.setDateTreatment(resultDateTreatment);
            LOGGER.debug(resultDateTreatment);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }


        ObjectFactory objFactory = new ObjectFactory();
        List<JAXBElement<String>> methodList = new ArrayList<>();
        String method = String.valueOf(getElementTextContent(gemElement, "manufacturingMethod"));

        if (method.equals(null)) {
            method = String.valueOf(getElementTextContent(gemElement, "processinggMethod"));
            JAXBElement<String> elementJAX = objFactory.createSyntheticGemManufacturingMethod(method);
            methodList.add(elementJAX);
        }
        else{
            JAXBElement<String> elementJAX = objFactory.createSyntheticGemManufacturingMethod(method);
            methodList.add(elementJAX);
        }

        ((SyntheticGem) gem).setManufacturingMethodOrProcessingMethod(methodList);
        for (int i = 0; i < methodList.size(); i++)
            LOGGER.debug(methodList.get(i).getValue());
        return gem;
    }


    // получение текстового содержимого тега
    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }

}
