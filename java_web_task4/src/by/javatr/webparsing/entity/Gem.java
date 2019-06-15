package by.javatr.webparsing.entity;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.*;
import java.util.Date;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Gem", propOrder = {
        "id",
        "name",
        "preciousness",
        "valueGr",
        "visualParameters",
        "transparencyPr",
        "originTreatment",
        "treater",
        "dateTreatment",
}) // задание последовательности элементов XML

public class Gem {
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlAttribute(required = true)
    private String id;
    @XmlElement(required = true)
    private String name;
    @XmlElement(required = true)
    private Preciousness preciousness = new Preciousness();
    @XmlElement(required = true)
    private double valueGr;
    @XmlElement(required = true)
    private VisualParameters visualParameters = new VisualParameters();
    @XmlElement(required = true)
    private String originTreatment;
    @XmlElement(required = true)
    private String treater;
    @XmlElement(required = true)
    private Date dateTreatment;

    public Gem() { } // необходим для маршаллизации/демаршалиизации XML

    public void setName(String name) {
        this.name = name;
    }

    public void setPreciousness(Preciousness preciousness) {
        this.preciousness = preciousness;
    }

    public void setValueGr(double valueGr) {
        this.valueGr = valueGr;
    }

    public void setVisualParameters(VisualParameters visualParameters) {
        this.visualParameters = visualParameters;
    }

    public void setOriginTreatment(String originTreatment) {
        this.originTreatment = originTreatment;
    }

    public void setTreater(String treater) {
        this.treater = treater;
    }

    public void setDateTreatment(Date dateTreatment) {
        this.dateTreatment = dateTreatment;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Preciousness getPreciousness() {
        return preciousness;
    }

    public double getValueGr() {
        return valueGr;
    }

    public VisualParameters getVisualParameters() {
        return visualParameters;
    }

    public String getOriginTreatment() {
        return originTreatment;
    }

    public String getTreater() {
        return treater;
    }

    public Date getDateTreatment() {
        return dateTreatment;
    }

    @Override
    public String toString() {
        return "Gem{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", preciousness=" + preciousness +
                ", valueGr=" + valueGr +
                ", visualParameters=" + visualParameters +
                ", originTreatment='" + originTreatment + '\'' +
                ", treater='" + treater + '\'' +
                ", dateTreatment=" + dateTreatment +
                '}';
    }

    @XmlRootElement
    @XmlType(name = "visualParameters", propOrder = {
            "color",
            "transparencyPr",
            "facesNumber"
    })

    public static class VisualParameters { // внутренний класс
        private String color;
        private double transparencyPr;
        private int facesNumber;

        public VisualParameters() {// необходим для маршаллизации/демаршалиизации XML
        }

        public VisualParameters(String color, double transparencyPr, int facesNumber) {
            this.color = color;
            this.transparencyPr = transparencyPr;
            this.facesNumber = facesNumber;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public void setTransparencyPr(double transparencyPr) {
            this.transparencyPr = transparencyPr;
        }

        public void setFacesNumber(int facesNumber) {
            this.facesNumber = facesNumber;
        }

        public String getColor() {
            return color;
        }

        public double getTransparencyPr() {
            return transparencyPr;
        }

        public int getFacesNumber() {
            return facesNumber;
        }
    }
}
