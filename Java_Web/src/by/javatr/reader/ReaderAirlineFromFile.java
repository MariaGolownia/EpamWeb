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
import java.util.List;

public class ReaderAirlineFromFile {
    public static final String AIRCRAFT_DATA_SEPARATOR_IN_FILE = ",";
    public static final Integer TYPE_INDEX = 2;

    public static Airline readPlanesFromFile (String fileName) {
        String FILES_NAME = "src/by/javatr/data/"+ fileName;
        String errorStatusBar = "";
        int countOfLine = 0;
        Airline airline = Airline.getInstance();
        System.out.println(airline.toString());
        try {
            File file = new File(FILES_NAME);
            ValidationFile validationFile = new ValidationFile();
            if (validationFile.checkFile(file)) {
                List<String> lines = Files.readAllLines(Paths.get(FILES_NAME), StandardCharsets.UTF_8);
                for (String line : lines) {
                    countOfLine++;
                    if (ValidationPlane.ifCorrectPlaneStr(line)) {
                        String[] valuesOfLine = line.split(AIRCRAFT_DATA_SEPARATOR_IN_FILE);
                        if ("passenger".equals(valuesOfLine[TYPE_INDEX].trim())) {
                            PassengerPlane passengerPlane = PlaneReader.readPassengerPlaneFromStrArray(airline, valuesOfLine);
                            if (ValidationPlane.ifExistPlane(passengerPlane)) {
                            airline.addPlane(passengerPlane);}
                            else {throw new ValidationException("Error of passenger planes reading!");}
                        }

                       else if ("transport".equals(valuesOfLine[TYPE_INDEX].trim())) {
                            {
                                TransportPlane transportPlane = PlaneReader.readTransportPlaneFromStrArray(airline, valuesOfLine);
                                if (ValidationPlane.ifExistPlane(transportPlane)) {
                                    airline.addPlane(transportPlane);}
                                else {throw new ValidationException("Error of transport planes reading!");}
                            }
                        }
                        else {
                           Plane plane = PlaneReader.readPlaneFromStrArray(airline, valuesOfLine);
                            if (ValidationPlane.ifExistPlane(plane)) {
                                airline.addPlane(plane);}
                            else {throw new ValidationException("Error of planes reading!");}
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
        } catch (ValidationException e) {
            e.printStackTrace();
        }
        try {
            if (!"".equals(errorStatusBar)) {
                throw new ValidationException("Attention! \n" + errorStatusBar);
            }
        }
        catch (ValidationException ex3) {
            ex3.getMessage();
        }
        return airline;
    }
}
