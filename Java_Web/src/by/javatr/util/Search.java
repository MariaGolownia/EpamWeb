package by.javatr.util;
import by.javatr.entity.Airline;
import by.javatr.entity.Plane;
import java.util.ArrayList;
import java.util.List;

public class Search {

    public static List<Plane> searchByTag(List<Plane>listOfPlanes, AbstractTagForSearch checkByTag, String tagValue) {
        List<Plane> rezList = new ArrayList<>();
        for (Plane planeItem : listOfPlanes) {
            if (checkByTag.ifContainsTag(planeItem, tagValue)) {
                rezList.add(planeItem);
            }
        }
        return rezList;
    }


    public static List<Plane> searchByTagInRange(List<Plane>listOfPlanes, AbstractTagForSearch checkByTag, String tagValue1, String tagValue2) {
        List<Plane> rezList = new ArrayList<>();
        for (Plane planeItem : listOfPlanes) {
            if (checkByTag.ifContainsTag(planeItem, tagValue1, tagValue2)) {
                rezList.add(planeItem);
            }
        }
        return rezList;
    }

    public static List<Plane> searchByTag(Airline airline, AbstractTagForSearch checkByTag, String tagValue) {
        List<Plane> rezList = new ArrayList<>();
        rezList = searchByTag(airline.getPlanes(), checkByTag, tagValue);
        return rezList;
    }


    public static List<Plane> searchByTagInRange(Airline airline, AbstractTagForSearch checkByTag, String tagValue1, String tagValue2) {
        List<Plane> rezList = new ArrayList<>();
        rezList = searchByTagInRange(airline.getPlanes(), checkByTag, tagValue1, tagValue2);
        return rezList;
    }
}
