package by.javatr.webparsing.entity;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.*;
import java.util.Date;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NaturalGem", propOrder = {
        "originExtraction",
        "dateExtraction"
}) // задание последовательности элементов XML

public class NaturalGem extends Gem {
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlAttribute(required = true)
    private String originExtraction;
    @XmlElement(required = true)
    private Date dateExtraction;


    public NaturalGem() { } // необходим для маршаллизации/демаршалиизации XML

    public void setOriginExtraction(String originExtraction) {
        this.originExtraction = originExtraction;
    }

    public void setDateExtraction(Date dateExtraction) {
        this.dateExtraction = dateExtraction;
    }

    public String getOriginExtraction() {
        return originExtraction;
    }

    public Date getDateExtraction() {
        return dateExtraction;
    }

    @Override
    public String toString() {
        return "NaturalGem{" +
                "originExtraction='" + originExtraction + '\'' +
                ", dateExtraction=" + dateExtraction +
                '}';
    }
}
