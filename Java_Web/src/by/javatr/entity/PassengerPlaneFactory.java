package by.javatr.entity;

public interface PassengerPlaneFactory {

    PassengerPlane getPassengerPlane();

    PassengerPlane getPassengerPlane(String modelOfPlane, String typeOfPlane, Integer yearOfProduction, String producingCountry,
                                     String manufacturingCompany, Integer seatingCapacityUnit,
                                     Integer carryingCapacityKilo, Integer fuelConsumptionKiloPerHour, Integer emptyWeightKilo,
                                     Integer hoursOfFlightsHours, Integer numberOfEconomyClassSeats, Boolean businessClassAvailability,
                                     Integer numberOfBusinessClassSeats);
}
