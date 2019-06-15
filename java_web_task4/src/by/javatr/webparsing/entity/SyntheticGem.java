package by.javatr.webparsing.entity;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SyntheticGem", propOrder = {
        "manufacturingMethod"
}) // задание последовательности элементов XML

public class SyntheticGem {
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlAttribute(required = true)
    private String manufacturingMethod;

    public SyntheticGem( ) {  }

    public SyntheticGem(String manufacturingMethod) {
        this.manufacturingMethod = manufacturingMethod;
    }

    public void setManufacturingMethod(String manufacturingMethod) {
        this.manufacturingMethod = manufacturingMethod;
    }

    public String getManufacturingMethod() {
        return manufacturingMethod;
    }

    @Override
    public String toString() {
        return "SyntheticGem{" +
                "manufacturingMethod='" + manufacturingMethod + '\'' +
                '}';
    }
}
