package by.javatr.entity;

import org.apache.log4j.Logger;

public class PlaneCreator {
    private static Logger LOGGER = Logger.getLogger(PlaneCreator.class);
    public static Plane createPlane (PlaneFactory factory) {

        return factory.getPlane();
    }

    public static Plane createPlane (PlaneFactory factory, Integer IDOfPlane, String modelOfPlane, String typeOfPlane, Integer yearOfProduction,
                                     String producingCountry, String manufacturingCompany, Integer seatingCapacityUnit,
                                     Integer carryingCapacityKilo, Integer fuelConsumptionKiloPerHour, Integer emptyWeightKilo,
                                     Integer hoursOfFlightsHours) {
        return factory.getPlane(IDOfPlane, modelOfPlane, typeOfPlane, yearOfProduction, producingCountry, manufacturingCompany,
                seatingCapacityUnit, carryingCapacityKilo, fuelConsumptionKiloPerHour, emptyWeightKilo,
                hoursOfFlightsHours);
    }


    public static TransportPlane createPlane (TransportPlaneFactory factory) {
        return factory.getTransportPlane();
    }

    public static TransportPlane createPlane (TransportPlaneFactory factory, Integer IDOfPlane, String modelOfPlane, String typeOfPlane, Integer yearOfProduction, String producingCountry,
                                              String manufacturingCompany, Integer seatingCapacityUnit, Integer carryingCapacityKilo,
                                              Integer fuelConsumptionKiloPerHour, Integer emptyWeightKilo, Integer hoursOfFlightsHours,
                                              Integer volumeOfCargoCompartmentCubicMeter, Integer areaOfCargoHatchSquareMeter) {
        return factory.getTransportPlane(IDOfPlane, modelOfPlane, typeOfPlane, yearOfProduction, producingCountry,
                manufacturingCompany, seatingCapacityUnit, carryingCapacityKilo, fuelConsumptionKiloPerHour,
                emptyWeightKilo, hoursOfFlightsHours, volumeOfCargoCompartmentCubicMeter, areaOfCargoHatchSquareMeter);
    }


    public static PassengerPlane createPlane (PassengerPlaneFactory factory) {
        return factory.getPassengerPlane();
    }

    public static PassengerPlane createPlane (PassengerPlaneFactory factory, Integer IDOfPlane, String modelOfPlane, String typeOfPlane, Integer yearOfProduction, String producingCountry,
                                              String manufacturingCompany, Integer seatingCapacityUnit,
                                              Integer carryingCapacityKilo, Integer fuelConsumptionKiloPerHour, Integer emptyWeightKilo,
                                              Integer hoursOfFlightsHours, Integer numberOfEconomyClassSeats, Boolean businessClassAvailability,
                                              Integer numberOfBusinessClassSeats) {
        return factory.getPassengerPlane(IDOfPlane, modelOfPlane, typeOfPlane, yearOfProduction, producingCountry,manufacturingCompany,
                seatingCapacityUnit, carryingCapacityKilo, fuelConsumptionKiloPerHour, emptyWeightKilo,
                hoursOfFlightsHours, numberOfEconomyClassSeats, businessClassAvailability, numberOfBusinessClassSeats);
    }
}
