package by.javatr.reader;
import by.javatr.entity.*;
import by.javatr.exc.FileException;
import by.javatr.print.PrintToConsole;
import by.javatr.valid.ValidationFile;
import by.javatr.valid.ValidationPlane;
import javax.xml.bind.ValidationException;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReaderAirlineFromFile {

    public static final String AIRCRAFT_DATA_SEPARATOR_IN_FILE = ",";

    public Airline readPlanesFromFile (String fileName) {
        String FILES_NAME = "src/by/javatr/data/"+ fileName;
        String errorStatusBar = "";
        int countOfLine = 0;
        Airline airline = new Airline();
        List<Plane> arrayOfPlanes = new ArrayList<>();                      // Массив для хранения считываемых самолетов

        try {
            File file = new File(FILES_NAME);                              //Необходимость создания для последующей валидации файлв
            ValidationFile validationFile = new ValidationFile();
            if (validationFile.checkFile(file)) {
                List<String> lines = Files.readAllLines(Paths.get(FILES_NAME), StandardCharsets.UTF_8);
                for (String line : lines) {
                    countOfLine++;
                    if (ValidationPlane.ifCorrectPlaneString(line)) {
                        String[] valuesOfLine = line.split(AIRCRAFT_DATA_SEPARATOR_IN_FILE);
                        if ("passenger".equals(valuesOfLine[2].trim())) {
                            PassengerPlane passengerPlane = PlaneCreator.createPlane(PassengerPlane.factory);
                            passengerPlane.setIDOfPlane(Integer.parseInt(valuesOfLine[0].trim()));
                            passengerPlane.setModelOfPlane(valuesOfLine[1].trim());
                            passengerPlane.setTypeOfPlane("passenger");
                            passengerPlane.setYearOfProduction(Integer.parseInt(valuesOfLine[3].trim()));
                            passengerPlane.setProducingCountry(valuesOfLine[4].trim());
                            passengerPlane.setManufacturingCompany(valuesOfLine[5].trim());
                            passengerPlane.setSeatingCapacityUnit(Integer.parseInt(valuesOfLine[6].trim()));
                            passengerPlane.setCarryingCapacityKilo(Integer.parseInt(valuesOfLine[7].trim()));
                            passengerPlane.setFuelConsumptionKiloPerHour(Integer.parseInt(valuesOfLine[8].trim()));
                            passengerPlane.setEmptyWeightKilo(Integer.parseInt(valuesOfLine[9].trim()));
                            passengerPlane.setHoursOfFlightsHours(Integer.parseInt(valuesOfLine[10].trim()));
                            passengerPlane.setNumberOfEconomyClassSeats(Integer.parseInt(valuesOfLine[11].trim()));
                            passengerPlane.setBusinessClassAvailability(Boolean.parseBoolean(valuesOfLine[12].trim()));
                            passengerPlane.setNumberOfBusinessClassSeats(Integer.parseInt(valuesOfLine[13].trim()));
                            airline.addPlane(passengerPlane);

                        }

                       else if ("transport".equals(valuesOfLine[2].trim())) {
                            TransportPlane transportPlane = PlaneCreator.createPlane(TransportPlane.factory);
                            transportPlane.setIDOfPlane(Integer.parseInt(valuesOfLine[0].trim()));
                            transportPlane.setModelOfPlane(valuesOfLine[1].trim());
                            transportPlane.setTypeOfPlane("transport");
                            transportPlane.setYearOfProduction(Integer.parseInt(valuesOfLine[3].trim()));
                            transportPlane.setProducingCountry(valuesOfLine[4].trim());
                            transportPlane.setManufacturingCompany(valuesOfLine[5].trim());
                            transportPlane.setSeatingCapacityUnit(Integer.parseInt(valuesOfLine[6].trim()));
                            transportPlane.setCarryingCapacityKilo(Integer.parseInt(valuesOfLine[7].trim()));
                            transportPlane.setFuelConsumptionKiloPerHour(Integer.parseInt(valuesOfLine[8].trim()));
                            transportPlane.setEmptyWeightKilo(Integer.parseInt(valuesOfLine[9].trim()));
                            transportPlane.setHoursOfFlightsHours(Integer.parseInt(valuesOfLine[10].trim()));
                            transportPlane.setVolumeOfCargoCompartmentCubicMeter(Integer.parseInt(valuesOfLine[11].trim()));
                            transportPlane.setAreaOfCargoHatchSquareMeter(Integer.parseInt(valuesOfLine[12].trim()));
                            airline.addPlane(transportPlane);
                        }
                        else {
                            Plane plane = PlaneCreator.createPlane(Plane.factory);
                            plane.setIDOfPlane(Integer.parseInt(valuesOfLine[0].trim()));
                            plane.setModelOfPlane(valuesOfLine[1].trim());
                            plane.setTypeOfPlane("not defined");
                            plane.setYearOfProduction(Integer.parseInt(valuesOfLine[3].trim()));
                            plane.setProducingCountry(valuesOfLine[4].trim());
                            plane.setManufacturingCompany(valuesOfLine[5].trim());
                            plane.setSeatingCapacityUnit(Integer.parseInt(valuesOfLine[6].trim()));
                            plane.setCarryingCapacityKilo(Integer.parseInt(valuesOfLine[7].trim()));
                            plane.setFuelConsumptionKiloPerHour(Integer.parseInt(valuesOfLine[8].trim()));
                            plane.setEmptyWeightKilo(Integer.parseInt(valuesOfLine[9].trim()));
                            plane.setHoursOfFlightsHours(Integer.parseInt(valuesOfLine[10].trim()));
                            airline.addPlane(plane);
                        }
                    }
                    else {
                        errorStatusBar += "Error in: " + countOfLine + " line. The line is '" + line + "' does not match the planes parameters and " +
                                "was not included in the database! \n";
                    }
                }
            }
            else {
                throw new FileException("Error accessing file! Check the file!");
            }

        }
        catch (FileException ex1){

            PrintToConsole.println(ex1.getMessage());
        }
        catch (IOException ex2) {
            PrintToConsole.println(ex2.getMessage());
        }
        try {
            if (!"".equals(errorStatusBar)) {
                throw new ValidationException("Attention! \n" + errorStatusBar);
            }
        }
        catch (ValidationException ex3) {
            PrintToConsole.println(ex3.getMessage());
        }
        return airline;
    }
}
