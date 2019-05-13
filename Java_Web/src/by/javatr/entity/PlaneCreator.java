package by.javatr.entity;

public class PlaneCreator {
    private int i  = 10;
    public static Plane createPlane (PlaneFactory factory) {
        return factory.getPlane();
    }

    public static Plane createPlane (PlaneFactory factory, String modelOfPlane, String typeOfPlane, Integer yearOfProduction,
                                     String producingCountry, String manufacturingCompany, Integer seatingCapacityUnit,
                                     Integer carryingCapacityKilo, Integer fuelConsumptionKiloPerHour, Integer emptyWeightKilo,
                                     Integer hoursOfFlightsHours) {
        return factory.getPlane(modelOfPlane, typeOfPlane, yearOfProduction, producingCountry, manufacturingCompany,
                seatingCapacityUnit, carryingCapacityKilo, fuelConsumptionKiloPerHour, emptyWeightKilo,
                hoursOfFlightsHours);
    }


    public static TransportPlane createPlane (TransportPlaneFactory factory) {
        return factory.getTransportPlane();
    }

    public static TransportPlane createPlane (TransportPlaneFactory factory, String modelOfPlane, String typeOfPlane, Integer yearOfProduction, String producingCountry,
                                              String manufacturingCompany, Integer seatingCapacityUnit, Integer carryingCapacityKilo,
                                              Integer fuelConsumptionKiloPerHour, Integer emptyWeightKilo, Integer hoursOfFlightsHours,
                                              Integer volumeOfCargoCompartmentCubicMeter, Integer areaOfCargoHatchSquareMeter) {
        return factory.getTransportPlane(modelOfPlane, typeOfPlane, yearOfProduction, producingCountry,
                manufacturingCompany, seatingCapacityUnit, carryingCapacityKilo, fuelConsumptionKiloPerHour,
                emptyWeightKilo, hoursOfFlightsHours, volumeOfCargoCompartmentCubicMeter, areaOfCargoHatchSquareMeter);
    }


    public static PassengerPlane createPlane (PassengerPlaneFactory factory) {
        return factory.getPassengerPlane();
    }

    public static PassengerPlane createPlane (PassengerPlaneFactory factory, String modelOfPlane, String typeOfPlane, Integer yearOfProduction, String producingCountry,
                                              String manufacturingCompany, Integer seatingCapacityUnit,
                                              Integer carryingCapacityKilo, Integer fuelConsumptionKiloPerHour, Integer emptyWeightKilo,
                                              Integer hoursOfFlightsHours, Integer numberOfEconomyClassSeats, Boolean businessClassAvailability,
                                              Integer numberOfBusinessClassSeats) {
        return factory.getPassengerPlane(modelOfPlane, typeOfPlane, yearOfProduction, producingCountry,manufacturingCompany,
                seatingCapacityUnit, carryingCapacityKilo, fuelConsumptionKiloPerHour, emptyWeightKilo,
                hoursOfFlightsHours, numberOfEconomyClassSeats, businessClassAvailability, numberOfBusinessClassSeats);
    }
}
