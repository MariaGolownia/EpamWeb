package by.javatr.entity;

import org.apache.log4j.Logger;

public interface PassengerPlaneFactory {

    PassengerPlane getPassengerPlane();

    PassengerPlane getPassengerPlane(Integer IDOfPlane, String modelOfPlane, String typeOfPlane, Integer yearOfProduction, String producingCountry,
                                     String manufacturingCompany, Integer seatingCapacityUnit,
                                     Integer carryingCapacityKilo, Integer fuelConsumptionKiloPerHour, Integer emptyWeightKilo,
                                     Integer hoursOfFlightsHours, Integer numberOfEconomyClassSeats, Boolean businessClassAvailability,
                                     Integer numberOfBusinessClassSeats);
}
