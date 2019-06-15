package by.javatr.webparsing.dao;
import by.javatr.webparsing.entity.Gem;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement

public class Gems {
    @XmlElement(name="gem")
    private ArrayList<Gem> list = new ArrayList<Gem>();

    public Gems() {
        super();
    }
    public void setList(ArrayList<Gem> list) {
        this.list = list;
    }
    public boolean add(Gem st) {
        return list.add(st);
    }
    @Override
    public String toString() {
        return "Gems [list=" + list + "]";
    }
}
