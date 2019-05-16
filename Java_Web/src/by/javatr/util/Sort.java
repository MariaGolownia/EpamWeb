package by.javatr.util;
import by.javatr.entity.Airline;
import by.javatr.entity.Plane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort {

    public static void sort(List<Plane> listOfPlanes, Comparator<Plane> c)
    {listOfPlanes.sort(c);
    }

    public static void sort(List<Plane> listOfPlanes) {
        Collections.sort(listOfPlanes);
    }

    public static List<Plane> sort(Airline airline, Comparator<Plane> c) {
        List<Plane> listOfPlanes = new ArrayList<>();
        for (int i = 0; i < airline.getCountOfPlanes(); i++){
            listOfPlanes.add(airline.getPlaneByIndex(i));
        }
        listOfPlanes.sort(c);
        return listOfPlanes;
    }
}
