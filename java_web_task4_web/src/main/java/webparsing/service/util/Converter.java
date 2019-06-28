package webparsing.service.util;
import webparsing.service.entity.ObjectFactory;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;

public class Converter {

    public XMLGregorianCalendar convertStringToXMLGregorianCalendar (String str) {
        XMLGregorianCalendar resultDateTreatment = null;
        try {
            resultDateTreatment = DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar(str);
        } catch (
                DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        return  resultDateTreatment;
    }


    public List<JAXBElement<String>> convertStringToListJAX(String str) {
        ObjectFactory objFactory = new ObjectFactory();
        List<JAXBElement<String>> list = new ArrayList<>();
        JAXBElement<String> elementJAX = objFactory.createSyntheticGemManufacturingMethod(str);
        list.add(elementJAX);
        return list;
        }
}
