package by.javatr.webparsing.service.util;
import by.javatr.webparsing.dao.GemsDAO;
import by.javatr.webparsing.dao.ParserFactory;
import by.javatr.webparsing.service.entity.Gem;
import by.javatr.webparsing.service.entity.NaturalGem;
import by.javatr.webparsing.service.entity.SyntheticGem;
import java.util.ArrayList;
import java.util.List;

public class Selection {

    public static List<NaturalGem> selectNaturalGem (GemsDAO gems) {
        List<NaturalGem> naturalGemsList = new ArrayList<>();
        for (int i = 0; i < gems.getGems().size(); i++) {
            if (gems.getGems().get(i) instanceof NaturalGem) {
                naturalGemsList.add((NaturalGem) gems.getGems().get(i));
            }
        }
        return naturalGemsList;
    }

    public static List<SyntheticGem> selectSyntheticGem (GemsDAO gems) {
        List <SyntheticGem> syntheticGemList = new ArrayList<>();
        for (int i = 0; i < gems.getGems().size(); i++) {
            if (gems.getGems().get(i) instanceof SyntheticGem) {
                syntheticGemList.add((SyntheticGem)gems.getGems().get(i));
            }
        }
        return syntheticGemList;
    }
}
