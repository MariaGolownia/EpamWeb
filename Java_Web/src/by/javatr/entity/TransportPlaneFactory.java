package by.javatr.entity;

public interface TransportPlaneFactory {

    TransportPlane getTransportPlane();

    TransportPlane getTransportPlane(Integer IDOfPlane, String modelOfPlane, String typeOfPlane, Integer yearOfProduction, String producingCountry,
                                     String manufacturingCompany, Integer seatingCapacityUnit,
                                     Integer carryingCapacityKilo, Integer fuelConsumptionKiloPerHour, Integer emptyWeightKilo,
                                     Integer hoursOfFlightsHours, Integer volumeOfCargoCompartmentCubicMeter,
                                     Integer areaOfCargoHatchSquareMeter);
}
