package by.javatr.util;

import by.javatr.entity.Plane;

import java.util.Comparator;

public class ComparatorPlaneForSort {

    public static class byModelComparator implements Comparator<Plane> {
        public int compare(Plane plane1, Plane plane2) {
            int result = (plane1.getModelOfPlane()).compareTo(plane2.getModelOfPlane());
            return result;
        }
    }

    public static class byTypeComparator implements Comparator<Plane> {
        public int compare(Plane plane1, Plane plane2) {
            int result = (plane1.getTypeOfPlane()).compareTo(plane2.getTypeOfPlane());
            return result;
        }
    }

    public static class byYearComparator implements Comparator<Plane> {
        public int compare(Plane plane1, Plane plane2) {
            int result = (plane1.getYearOfProduction()).compareTo(plane2.getYearOfProduction());
            return result;
        }
    }

    public static class byProducingCountry implements Comparator<Plane> {
        public int compare(Plane plane1, Plane plane2) {
            int result = (plane1.getProducingCountry()).compareTo(plane2.getProducingCountry());
            return result;
        }
    }

    public static class byManufacturingCompany implements Comparator<Plane> {
        public int compare(Plane plane1, Plane plane2) {
            int result = (plane1.getManufacturingCompany()).compareTo(plane2.getManufacturingCompany());
            return result;
        }
    }

    public static class bySeatingCapacity implements Comparator<Plane> {
        public int compare(Plane plane1, Plane plane2) {
            int result = (plane1.getSeatingCapacityUnit()).compareTo(plane2.getSeatingCapacityUnit());
            return result;
        }
    }

    public static class byCarryingCapacity implements Comparator<Plane> {
        public int compare(Plane plane1, Plane plane2) {
            int result = (plane1.getCarryingCapacityKilo()).compareTo(plane2.getCarryingCapacityKilo());
            return result;
        }
    }

    public static class byFuelConsumption implements Comparator<Plane> {
        public int compare(Plane plane1, Plane plane2) {
            int result = (plane1.getFuelConsumptionKiloPerHour()).compareTo(plane2.getFuelConsumptionKiloPerHour());
            return result;
        }
    }

    public static class byEmptyWeight implements Comparator<Plane> {
        public int compare(Plane plane1, Plane plane2) {
            int result = (plane1.getEmptyWeightKilo()).compareTo(plane2.getEmptyWeightKilo());
            return result;
        }
    }

    public static class byHoursOfFlightsHours implements Comparator<Plane> {
        public int compare(Plane plane1, Plane plane2) {
            int result = (plane1.getHoursOfFlightsHours()).compareTo(plane2.getHoursOfFlightsHours());
            return result;
        }
    }
}
