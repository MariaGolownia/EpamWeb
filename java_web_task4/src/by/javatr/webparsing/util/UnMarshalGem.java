package by.javatr.webparsing.util;
import by.javatr.webparsing.dao.Gems;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class UnMarshalGem {
    public UnMarshalGem () {
        try {
            JAXBContext jc = JAXBContext.newInstance(Gems.class);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader("data/studs_marsh.xml");
            Gems students = (Gems) u.unmarshal(reader);
            System.out.println(students);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

}
}
