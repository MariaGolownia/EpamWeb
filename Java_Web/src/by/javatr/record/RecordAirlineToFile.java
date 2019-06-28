package by.javatr.record;
import by.javatr.entity.Airline;
import by.javatr.entity.PassengerPlane;
import by.javatr.entity.Plane;
import by.javatr.entity.TransportPlane;
import java.io.FileWriter;
import java.io.IOException;

public class RecordAirlineToFile {
    public static final String SEPARATOR_COMMA  = ",";

    public void record (Airline airline, String fileName) throws IOException {
        String FILES_NAME = "src/by/javatr/data/"+ fileName;
        FileWriter writer = new FileWriter(FILES_NAME);
        for (int i = 0; i < airline.getCountOfPlanes(); i++) {
            String typeOfPlane = airline.getPlaneByIndex(i).getTypeOfPlane();
            if (typeOfPlane.equals("passenger")) {
                PassengerPlane plane = (PassengerPlane)airline.getPlaneByIndex(i);
            writer.write(plane.getIDOfPlane().toString() + SEPARATOR_COMMA
                    + plane.getModelOfPlane() + SEPARATOR_COMMA
                    + plane.getTypeOfPlane() + SEPARATOR_COMMA
                    + plane.getYearOfProduction().toString() + SEPARATOR_COMMA
                    + plane.getProducingCountry() + SEPARATOR_COMMA
                    + plane.getManufacturingCompany() + SEPARATOR_COMMA
                    + plane.getSeatingCapacityUnit().toString() + SEPARATOR_COMMA
                    + plane.getCarryingCapacityKilo().toString() + SEPARATOR_COMMA
                    + plane.getFuelConsumptionKiloPerHour().toString() + SEPARATOR_COMMA
                    + plane.getEmptyWeightKilo().toString() + SEPARATOR_COMMA
                    + plane.getHoursOfFlightsHours().toString() + SEPARATOR_COMMA
                    + plane.getNumberOfEconomyClassSeats().toString() + SEPARATOR_COMMA
                    + plane.getBusinessClassAvailability().toString() + SEPARATOR_COMMA
                    + plane.getNumberOfBusinessClassSeats() + System.getProperty("line.separator"));}
            else if (typeOfPlane.equals("transport")) {
                TransportPlane plane = (TransportPlane) airline.getPlaneByIndex(i);
                writer.write(plane.getIDOfPlane().toString() + SEPARATOR_COMMA
                        + plane.getModelOfPlane() + SEPARATOR_COMMA
                        + plane.getTypeOfPlane() + SEPARATOR_COMMA
                        + plane.getYearOfProduction().toString() + SEPARATOR_COMMA
                        + plane.getProducingCountry() + SEPARATOR_COMMA
                        + plane.getManufacturingCompany() + SEPARATOR_COMMA
                        + plane.getSeatingCapacityUnit().toString() + SEPARATOR_COMMA
                        + plane.getCarryingCapacityKilo().toString() + SEPARATOR_COMMA
                        + plane.getFuelConsumptionKiloPerHour().toString() + SEPARATOR_COMMA
                        + plane.getEmptyWeightKilo().toString() + SEPARATOR_COMMA
                        + plane.getHoursOfFlightsHours().toString() + SEPARATOR_COMMA
                        + plane.getVolumeOfCargoCompartmentCubicMeter().toString() + SEPARATOR_COMMA
                        + plane.getAreaOfCargoHatchSquareMeter().toString() + System.getProperty("line.separator"));}
            else {
                Plane plane = airline.getPlaneByIndex(i);
                writer.write(plane.getIDOfPlane().toString() + SEPARATOR_COMMA
                        + plane.getModelOfPlane() + SEPARATOR_COMMA
                        + plane.getTypeOfPlane() + SEPARATOR_COMMA
                        + plane.getYearOfProduction().toString() + SEPARATOR_COMMA
                        + plane.getProducingCountry() + SEPARATOR_COMMA
                        + plane.getManufacturingCompany() + SEPARATOR_COMMA
                        + plane.getSeatingCapacityUnit().toString() + SEPARATOR_COMMA
                        + plane.getCarryingCapacityKilo().toString() + SEPARATOR_COMMA
                        + plane.getFuelConsumptionKiloPerHour().toString() + SEPARATOR_COMMA
                        + plane.getEmptyWeightKilo().toString() + SEPARATOR_COMMA
                        + plane.getHoursOfFlightsHours().toString() + System.getProperty("line.separator"));}
            }
            writer.close();
            }

        }


