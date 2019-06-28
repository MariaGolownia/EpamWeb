package by.javatr.webparsing.service.util;
import by.javatr.webparsing.dao.GemsDAO;
import by.javatr.webparsing.dao.ParserFactory;
import by.javatr.webparsing.service.entity.Gem;
import by.javatr.webparsing.service.entity.NaturalGem;
import by.javatr.webparsing.service.entity.SyntheticGem;
import java.util.ArrayList;
import java.util.List;

public class Selection {

    public static List<Gem> selectNaturalGem (GemsDAO gems) {
        List<Gem> naturalGemsList = new ArrayList<>();
        List <SyntheticGem> syntheticGemList = new ArrayList<>();
        for (int i = 0; i < gems.getGems().size(); i++) {
            if (gems.getGems().get(i) instanceof NaturalGem) {
                naturalGemsList.add(gems.getGems().get(i));
            }
        }
        return naturalGemsList;
    }

    public static List<Gem> selectSyntheticGem (GemsDAO gems) {
        List <Gem> syntheticGemList = new ArrayList<>();
        for (int i = 0; i < gems.getGems().size(); i++) {
            if (gems.getGems().get(i) instanceof SyntheticGem) {
                syntheticGemList.add(gems.getGems().get(i));
            }
        }
        return syntheticGemList;
    }
}
