package by.javatr.util;

import by.javatr.entity.Airline;

public class Count {

    public Integer countSeatingCapacity (Airline airline) {
        Integer generalSeatingCapacity = 0;
        for (int i = 0; i < airline.getCountOfPlanes(); i++) {
            generalSeatingCapacity += Integer.parseInt(airline.getPlaneByIndex(i).getSeatingCapacityUnit().toString());
        }
        return generalSeatingCapacity;
    }

    public Integer countCarryingCapacity(Airline airline) {
        Integer generalCarryingCapacity = 0;
        for (int i = 0; i < airline.getCountOfPlanes(); i++) {
            generalCarryingCapacity += Integer.parseInt(airline.getPlaneByIndex(i).getCarryingCapacityKilo().toString());
        }
        return generalCarryingCapacity;
    }
}
