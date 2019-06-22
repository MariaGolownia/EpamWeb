package by.javatr.webparsing.dao;
import by.javatr.webparsing.entity.Gem;
import by.javatr.webparsing.entity.NaturalGem;
import by.javatr.webparsing.entity.SyntheticGem;

import java.util.ArrayList;
import java.util.List;

public class GemsDAO implements Cloneable{
    private List<Gem> gems = new ArrayList<>();

    private GemsDAO () {}

    private static class GemsDAOHolder {
        private final static GemsDAO instance = new GemsDAO ();
    }

    public static GemsDAO getInstance () {
        return GemsDAOHolder.instance;
    }

    public void setGems(List<Gem> gems) {
        this.gems = gems;
    }

    public List<Gem> getGems() {
        return gems;
    }

    public GemsDAO clone() throws CloneNotSupportedException {
        GemsDAO gemsDAOClone = new GemsDAO();
        List<Gem> GemsClone = new ArrayList<>();
        for (int i = 0; i < gems.size(); i++) {
            if (gems.get(i) instanceof NaturalGem) {
                Gem naturalGemClone = new NaturalGem();
                naturalGemClone = gems.get(i).clone();
                GemsClone.add(naturalGemClone);
            }
            else {
                Gem syntheticGemClone = new SyntheticGem();
                syntheticGemClone = gems.get(i).clone();
                GemsClone.add(syntheticGemClone);
            }
        }
        gemsDAOClone.setGems(GemsClone);
        return gemsDAOClone;
    }

    @Override
    public String toString() {
        return "GemsDAO{" +
                "gems=" + gems +
                '}';

    }
}
