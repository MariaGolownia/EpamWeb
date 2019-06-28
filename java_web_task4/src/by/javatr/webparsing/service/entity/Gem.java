//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.06.16 at 12:19:37 PM AST 
//


package by.javatr.webparsing.service.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Gem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Gem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="valueGr" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="visualParameters" type="{http://www.epam.training.by/classes}VisualParameters"/>
 *         &lt;element name="originTreatment" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="treater" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dateTreatment" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.epam.training.by/classes}Unique" />
 *       &lt;attribute name="preciousness" type="{http://www.epam.training.by/classes}Preciousness" default="vague" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Gem", propOrder = {
    "name",
    "valueGr",
    "visualParameters",
    "originTreatment",
    "treater",
    "dateTreatment"
})
@XmlSeeAlso({
    SyntheticGem.class,
    NaturalGem.class
})
public class Gem implements Cloneable {

    @XmlElement(required = true)
    protected String name;
    protected double valueGr;
    @XmlElement(required = true)
    protected VisualParameters visualParameters;
    @XmlElement(required = true)
    protected String originTreatment;
    @XmlElement(required = true)
    protected String treater;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateTreatment;
    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;
    @XmlAttribute(name = "preciousness")
    protected Preciousness preciousness;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the valueGr property.
     * 
     */
    public double getValueGr() {
        return valueGr;
    }

    /**
     * Sets the value of the valueGr property.
     * 
     */
    public void setValueGr(double value) {
        this.valueGr = value;
    }

    /**
     * Gets the value of the visualParameters property.
     * 
     * @return
     *     possible object is
     *     {@link VisualParameters }
     *     
     */
    public VisualParameters getVisualParameters() {
        return visualParameters;
    }

    /**
     * Sets the value of the visualParameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link VisualParameters }
     *     
     */
    public void setVisualParameters(VisualParameters value) {
        this.visualParameters = value;
    }

    /**
     * Gets the value of the originTreatment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginTreatment() {
        return originTreatment;
    }

    /**
     * Sets the value of the originTreatment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginTreatment(String value) {
        this.originTreatment = value;
    }

    /**
     * Gets the value of the treater property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTreater() {
        return treater;
    }

    /**
     * Sets the value of the treater property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTreater(String value) {
        this.treater = value;
    }

    /**
     * Gets the value of the dateTreatment property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateTreatment() {
        return dateTreatment;
    }

    /**
     * Sets the value of the dateTreatment property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateTreatment(XMLGregorianCalendar value) {
        this.dateTreatment = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the preciousness property.
     * 
     * @return
     *     possible object is
     *     {@link Preciousness }
     *     
     */
    public Preciousness getPreciousness() {
        if (preciousness == null) {
            return Preciousness.VAGUE;
        } else {
            return preciousness;
        }
    }

    /**
     * Sets the value of the preciousness property.
     *
     * @param value
     *     allowed object is
     *     {@link Preciousness }
     *     
     */
    public void setPreciousness(String value) {
        if (value.equals("precious"))
        this.preciousness = Preciousness.PRECIOUS;
        else if (value.equals("semiprecious"))
            this.preciousness = Preciousness.SEMIPRECIOUS;
        else
            this.preciousness = Preciousness.VAGUE;

    }

    @Override
    public String toString() {
        return "\nGem{" +
                ", id='" + id + '\'' +
                "name='" + name + '\'' +
                ", preciousness=" + preciousness +
                ", valueGr=" + valueGr +
                ", visualParameters=" + visualParameters +
                ", originTreatment='" + originTreatment + '\'' +
                ", treater='" + treater + '\'' +
                ", dateTreatment=" + dateTreatment +
                '}';
    }

    public Gem clone() throws CloneNotSupportedException {
        Gem clone = new Gem();
        clone.setId(this.id);
        clone.setPreciousness(this.preciousness.value());
        clone.setName(this.name);
        clone.setValueGr(this.valueGr);
        clone.setOriginTreatment(this.originTreatment);
        clone.setDateTreatment(this.dateTreatment);
        clone.setTreater(this.treater);
        clone.setVisualParameters(this.visualParameters);
        return clone;
    }
}
