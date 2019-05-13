package by.javatr.entity;

public interface PlaneFactory {

    Plane getPlane();

    Plane getPlane(String modelOfPlane, String typeOfPlane, Integer yearOfProduction, String producingCountry,
                   String manufacturingCompany, Integer seatingCapacityUnit, Integer carryingCapacityKilo,
                   Integer fuelConsumptionKiloPerHour, Integer emptyWeightKilo, Integer hoursOfFlightsHours);
}
