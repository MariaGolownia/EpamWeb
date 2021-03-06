package by.javatr.webparsing.service.util;
import by.javatr.webparsing.service.entity.Gems;
import org.xml.sax.SAXException;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

public class SAXUnMarshalGem {
    private final static String INSTANCE_ENTITY = "by.javatr.webparsing.service.entity";

    public SAXUnMarshalGem(String xmlName, String schemaName) {
        JAXBContext jc = null;
        Gems fl = null;
        try {
            jc = JAXBContext.newInstance(INSTANCE_ENTITY);
            Unmarshaller um = jc.createUnmarshaller();
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            File schemaLocation = new File(schemaName);
            // создание схемы и перадача ее демарашаллизатору
            Schema schema = factory.newSchema(schemaLocation);
            // set schema
            um.setSchema(schema);
            fl =
                    (Gems) um.unmarshal(new File(xmlName));
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

//        for (JAXBElement<? extends Gem> gem:fl.getGem()) {
//            System.out.println(gem.getValue().toString());
//        }
    }

}

