package by.javatr.webparsing.util;
import by.javatr.webparsing.entity.Gem;
import by.javatr.webparsing.entity.Gems;
import org.xml.sax.SAXException;
import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

public class UnMarshalGem {

    public UnMarshalGem(String xmlName, String schemaName) {
        JAXBContext jc = null;
        Gems fl = null;
        try {
            jc = JAXBContext.newInstance("by.javatr.webparsing.entity");
            Unmarshaller um = jc.createUnmarshaller();
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            File schemaLocation = new File(schemaName);
// создание схемы и перадача ее демарашаллизатору
            Schema schema = factory.newSchema(schemaLocation);
            um.setSchema(schema);
            fl =
                    (Gems) um.unmarshal(new File(xmlName));
            System.out.println(fl);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        for (JAXBElement<? extends Gem> gem:fl.getGem()) {
            System.out.println(gem.getValue().toString());
        }
//       try {
//            JAXBContext jc = JAXBContext.newInstance(Gems.class);
//            Unmarshaller u = jc.createUnmarshaller();
//            FileReader reader = new FileReader(xmlName);
//            Gems gems = (Gems) u.unmarshal(reader);
//            System.out.println(gems);
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }

}

