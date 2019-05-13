package by.javatr.util;
import by.javatr.entity.Plane;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort {

    public void sort(List<Plane> listOfPlanes, Comparator<Plane> c)
    {listOfPlanes.sort(c);
    }

    public void sort(List<Plane> listOfPlanes) {
        Collections.sort(listOfPlanes);
    }
}
