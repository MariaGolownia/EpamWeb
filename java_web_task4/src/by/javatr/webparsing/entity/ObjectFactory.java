//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.06.16 at 12:19:37 PM AST 
//


package by.javatr.webparsing.entity;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the by.training.epam.classes package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SyntheticGem_QNAME = new QName("http://www.epam.training.by/classes", "syntheticGem");
    private final static QName _Gem_QNAME = new QName("http://www.epam.training.by/classes", "gem");
    private final static QName _NaturalGem_QNAME = new QName("http://www.epam.training.by/classes", "naturalGem");
    private final static QName _SyntheticGemManufacturingMethod_QNAME = new QName("http://www.epam.training.by/classes", "manufacturingMethod");
    private final static QName _SyntheticGemProcessingMethod_QNAME = new QName("http://www.epam.training.by/classes", "processingMethod");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: by.training.epam.classes
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Gems }
     * 
     */
    public Gems createGems() {
        return new Gems();
    }

    /**
     * Create an instance of {@link Gem }
     * 
     */
    public Gem createGem() {
        return new Gem();
    }

    /**
     * Create an instance of {@link SyntheticGem }
     * 
     */
    public SyntheticGem createSyntheticGem() {
        return new SyntheticGem();
    }

    /**
     * Create an instance of {@link NaturalGem }
     * 
     */
    public NaturalGem createNaturalGem() {
        return new NaturalGem();
    }

    /**
     * Create an instance of {@link VisualParameters }
     * 
     */
    public VisualParameters createVisualParameters() {
        return new VisualParameters();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SyntheticGem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.epam.training.by/classes", name = "syntheticGem", substitutionHeadNamespace = "http://www.epam.training.by/classes", substitutionHeadName = "gem")
    public JAXBElement<SyntheticGem> createSyntheticGem(SyntheticGem value) {
        return new JAXBElement<SyntheticGem>(_SyntheticGem_QNAME, SyntheticGem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Gem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.epam.training.by/classes", name = "gem")
    public JAXBElement<Gem> createGem(Gem value) {
        return new JAXBElement<Gem>(_Gem_QNAME, Gem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NaturalGem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.epam.training.by/classes", name = "naturalGem", substitutionHeadNamespace = "http://www.epam.training.by/classes", substitutionHeadName = "gem")
    public JAXBElement<NaturalGem> createNaturalGem(NaturalGem value) {
        return new JAXBElement<NaturalGem>(_NaturalGem_QNAME, NaturalGem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.epam.training.by/classes", name = "manufacturingMethod", scope = SyntheticGem.class)
    public JAXBElement<String> createSyntheticGemManufacturingMethod(String value) {
        return new JAXBElement<String>(_SyntheticGemManufacturingMethod_QNAME, String.class, SyntheticGem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.epam.training.by/classes", name = "processingMethod", scope = SyntheticGem.class)
    public JAXBElement<String> createSyntheticGemProcessingMethod(String value) {
        return new JAXBElement<String>(_SyntheticGemProcessingMethod_QNAME, String.class, SyntheticGem.class, value);
    }

}
