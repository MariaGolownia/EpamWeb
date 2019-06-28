package by.javatr.entity;
import org.apache.log4j.Logger;

import java.util.Optional;

public class PassengerPlane extends Plane implements PlaneInterface{
    private static Logger LOGGER = Logger.getLogger(PassengerPlane.class);
    private Optional<Integer> numberOfEconomyClassSeats;             // Число мест эконом классса
    private Optional<Boolean> businessClassAvailability;             // Наличие бизнес класса
    private Optional<Integer> numberOfBusinessClassSeats;            // Число мест бизнесс класса

    public static PassengerPlaneFactory factory = new PassengerPlaneFactory() {
        @Override
        public PassengerPlane getPassengerPlane() {
            return new PassengerPlane();
        }

        @Override
        public PassengerPlane getPassengerPlane(Integer IDOfPlane, String modelOfPlane, String typeOfPlane, Integer yearOfProduction, String producingCountry,
                                       String manufacturingCompany, Integer seatingCapacityUnit,
                                       Integer carryingCapacityKilo, Integer fuelConsumptionKiloPerHour, Integer emptyWeightKilo,
                                       Integer hoursOfFlightsHours, Integer numberOfEconomyClassSeats, Boolean businessClassAvailability,
                                       Integer numberOfBusinessClassSeats) {
            return new PassengerPlane(IDOfPlane, modelOfPlane, typeOfPlane, yearOfProduction, producingCountry,manufacturingCompany,
                    seatingCapacityUnit, carryingCapacityKilo, fuelConsumptionKiloPerHour, emptyWeightKilo,
                    hoursOfFlightsHours, numberOfEconomyClassSeats, businessClassAvailability, numberOfBusinessClassSeats);
        }
    };

    private PassengerPlane() {
        super();
        numberOfEconomyClassSeats = Optional.of(0);
        businessClassAvailability = Optional.of(false);
        numberOfBusinessClassSeats = Optional.of(0);
    }

    private PassengerPlane(Integer IDOfPlane, String modelOfPlane, String typeOfPlane, Integer yearOfProduction, String producingCountry,
                          String manufacturingCompany, Integer seatingCapacityUnit,
                          Integer carryingCapacityKilo, Integer fuelConsumptionKiloPerHour, Integer emptyWeightKilo,
                          Integer hoursOfFlightsHours, Integer numberOfEconomyClassSeats, Boolean businessClassAvailability,
                          Integer numberOfBusinessClassSeats) {
        super(IDOfPlane, modelOfPlane, typeOfPlane, yearOfProduction, producingCountry, manufacturingCompany, seatingCapacityUnit, carryingCapacityKilo, fuelConsumptionKiloPerHour, emptyWeightKilo, hoursOfFlightsHours);
       setNumberOfEconomyClassSeats(numberOfEconomyClassSeats);
       setBusinessClassAvailability(businessClassAvailability);
       setNumberOfBusinessClassSeats(numberOfBusinessClassSeats);
    }

    public void setNumberOfEconomyClassSeats(Integer numberOfEconomyClassSeats) {
        this.numberOfEconomyClassSeats = Optional.ofNullable(numberOfEconomyClassSeats);
        if (!this.numberOfEconomyClassSeats.isPresent())
            System.out.println("Warning: not a valid value (null)!" +
                    "'NumberOfEconomyClassSeats' parameter must be filled!");

    }

    public void setBusinessClassAvailability(Boolean businessClassAvailability) {
        this.businessClassAvailability = Optional.ofNullable(businessClassAvailability);
        if (!this.businessClassAvailability.isPresent())
            System.out.println("Warning: not a valid value (null)!" +
                    "'BusinessClassAvailability' parameter must be filled!");
    }

    public void setNumberOfBusinessClassSeats(Integer numberOfBusinessClassSeats) {
        this.numberOfBusinessClassSeats = Optional.ofNullable(numberOfBusinessClassSeats);
        if (!this.numberOfBusinessClassSeats.isPresent())
            System.out.println("Warning: not a valid value (null)!" +
                    "'NumberOfBusinessClassSeats' parameter must be filled!");
    }

    public Integer getNumberOfEconomyClassSeats() {
        return numberOfEconomyClassSeats.get();
    }

    public Boolean getBusinessClassAvailability() {
        return businessClassAvailability.get();
    }

    public Integer getNumberOfBusinessClassSeats() {
        return numberOfBusinessClassSeats.get();
    }

    @Override
    public String toString() {
        return super.toString() +
                " numberOfEconomyClassSeats=" + numberOfEconomyClassSeats +
                ",\n businessClassAvailability=" + businessClassAvailability +
                ",\n numberOfBusinessClassSeats=" + numberOfBusinessClassSeats +
                "}";
    }


    public int compareTo(PassengerPlane anotherPlane) {
        int result = super.compareTo(anotherPlane);
        if(result !=0) return result;

        result= this.getNumberOfBusinessClassSeats() - anotherPlane.getNumberOfBusinessClassSeats();
        if(result !=0) return result;

        result= this.getNumberOfEconomyClassSeats() - anotherPlane.getNumberOfEconomyClassSeats();
         return result;

    }
}
