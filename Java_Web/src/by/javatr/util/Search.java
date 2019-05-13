package by.javatr.util;
import by.javatr.entity.Plane;
import java.util.ArrayList;
import java.util.List;

public class Search {

    public List<Plane> searchByTag(List<Plane>listOfPlanes, AbstractTagForSearch checkByTag, String tagValue) {
        List<Plane> rezList = new ArrayList<>();
        for (Plane planeItem : listOfPlanes) {
            if (checkByTag.ifContainsTag(planeItem, tagValue)) {
                rezList.add(planeItem);
            }
        }
        return rezList;
    }


    public List<Plane> searchByTagInRange(List<Plane>listOfPlanes, AbstractTagForSearch checkByTag, String tagValue1, String tagValue2) {
        List<Plane> rezList = new ArrayList<>();
        for (Plane planeItem : listOfPlanes) {
            if (checkByTag.ifContainsTag(planeItem, tagValue1, tagValue2)) {
                rezList.add(planeItem);
            }
        }
        return rezList;
    }
}
