package by.javatr.util;

import by.javatr.entity.Airline;
import by.javatr.entity.Plane;

import java.util.ArrayList;
import java.util.List;

public class IDAssignment {

    public static Integer assign (Airline airline, Plane plane, Integer ID) {
        List<Integer> listOfID = new ArrayList<>();
        Integer numberOfID = 0;
        for (int i = 0; i < airline.getCountOfPlanes(); i++) {
            listOfID.add(airline.getPlaneByIndex(i).getIDOfPlane());
        }
        if (listOfID.size() == 0) {
            return numberOfID = 1;
        }
        else {
            // Пробегаемся по массиву, если желаемого к присвоению ID нет в нем, выделяем номер
            for (int i = 0; i < listOfID.size(); i++) {
                if (listOfID.contains(ID)) {
                    if (ID == 0) {
                        numberOfID = ++ID;
                    } else {
                        numberOfID = ID;
                    }
                } else {
                    // В противном случае, присваиваем свой номер
                    numberOfID = airline.getMaxIdOfPlanes() + 1;
                }
            }
            return numberOfID;
        }
    }


}
