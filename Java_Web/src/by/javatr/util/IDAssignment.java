package by.javatr.util;
import by.javatr.entity.Airline;
import by.javatr.entity.Plane;
import by.javatr.exc.ValidationException;

import java.util.ArrayList;
import java.util.List;

public class IDAssignment {

    public static Integer assignForPlane(Airline airline, Integer ID) {
        List<Integer> listOfID = new ArrayList<>();
        Integer numberOfID = -1;
        for (int i = 0; i < airline.getCountOfPlanes(); i++) {
            listOfID.add(airline.getPlaneByIndex(i).getIDOfPlane());
        }
        numberOfID = generateID(listOfID, ID);
        return numberOfID;
    }

        public static Integer assignForPlane (List <Integer> listOfID, Integer ID){
            Integer numberOfID = -1;
            numberOfID =  generateID(listOfID, ID);
            return numberOfID;
        }

        public static Integer generateID (List <Integer> listOfID, Integer numberOfID) {
            int maxValueOfList = 0;
                if (listOfID.size() == 0) {
                    numberOfID = 1;
                } else {
                    // Пробегаемся по массиву, если желаемого к присвоению ID нет в нем, выделяем номер
                    for (int i = 0; i < listOfID.size(); i++) {
                        if (listOfID.get(i) > maxValueOfList) {
                            maxValueOfList = listOfID.get(i);
                        }
                        if (!listOfID.contains(numberOfID) && numberOfID != 0) {
                            numberOfID = numberOfID;
                        } else {
                            // В противном случае, присваиваем свой номер
                            numberOfID = listOfID.get(listOfID.size() - 1) + 1;
                        }
                    }
                }
            return numberOfID;
        }

}

