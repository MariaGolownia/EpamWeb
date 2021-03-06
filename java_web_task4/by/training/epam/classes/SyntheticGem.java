//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.06.16 at 12:19:37 PM AST 
//


package by.training.epam.classes;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SyntheticGem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SyntheticGem">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.epam.training.by/classes}Gem">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="manufacturingMethod" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="processingMethod" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/choice>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SyntheticGem", propOrder = {
    "manufacturingMethodOrProcessingMethod"
})
public class SyntheticGem
    extends Gem
{

    @XmlElementRefs({
        @XmlElementRef(name = "manufacturingMethod", namespace = "http://www.epam.training.by/classes", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "processingMethod", namespace = "http://www.epam.training.by/classes", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<String>> manufacturingMethodOrProcessingMethod;

    /**
     * Gets the value of the manufacturingMethodOrProcessingMethod property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the manufacturingMethodOrProcessingMethod property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getManufacturingMethodOrProcessingMethod().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * 
     */
    public List<JAXBElement<String>> getManufacturingMethodOrProcessingMethod() {
        if (manufacturingMethodOrProcessingMethod == null) {
            manufacturingMethodOrProcessingMethod = new ArrayList<JAXBElement<String>>();
        }
        return this.manufacturingMethodOrProcessingMethod;
    }

}
