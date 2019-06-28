//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.06.16 at 12:19:37 PM AST 
//


package by.javatr.webparsing.service.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for NaturalGem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NaturalGem">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.epam.training.by/classes}Gem">
 *       &lt;sequence>
 *         &lt;element name="originExtraction" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dateExtraction" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NaturalGem", propOrder = {
    "originExtraction",
    "dateExtraction"
})
public class NaturalGem extends Gem implements Cloneable
{

    @XmlElement(required = true)
    protected String originExtraction;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateExtraction;

    /**
     * Gets the value of the originExtraction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginExtraction() {
        return originExtraction;
    }

    /**
     * Sets the value of the originExtraction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginExtraction(String value) {
        this.originExtraction = value;
    }

    /**
     * Gets the value of the dateExtraction property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateExtraction() {
        return dateExtraction;
    }

    /**
     * Sets the value of the dateExtraction property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateExtraction(XMLGregorianCalendar value) {
        this.dateExtraction = value;
    }

    @Override
    public String toString() {
        return "\nNaturalGem{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", preciousness=" + preciousness +
                ", valueGr=" + valueGr +
                ", visualParameters=" + visualParameters +
                ", originTreatment='" + originTreatment + '\'' +
                ", treater='" + treater + '\'' +
                ", dateTreatment=" + dateTreatment +
                ", originExtraction='" + originExtraction + '\'' +
                ", dateExtraction=" + dateExtraction +
                '}';
    }

    public NaturalGem clone() throws CloneNotSupportedException {
        NaturalGem clone = new NaturalGem();
        clone.setId(super.id);
        clone.setPreciousness(super.preciousness.value());
        clone.setName(super.name);
        clone.setValueGr(super.valueGr);
        clone.setOriginTreatment(super.originTreatment);
        clone.setDateTreatment(super.dateTreatment);
        clone.setTreater(super.treater);
        clone.setVisualParameters(super.visualParameters);
        ((NaturalGem) clone).setOriginExtraction(this.originExtraction);
        ((NaturalGem) clone).setDateExtraction(this.dateExtraction);
        return clone;
    }
}
