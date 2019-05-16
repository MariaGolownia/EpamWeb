package by.javatr.reader;
import by.javatr.entity.*;
import by.javatr.exc.ValidationException;
import by.javatr.util.IDAssignment;

public class PlaneReader {
    public static final Integer COUNT_PASSENGER_PLANES_PARAMETERS = 14;
    public static final Integer COUNT_TRANSPORT_PLANES_PARAMETERS = 13;
    public static final Integer COUNT_PLANE_PARAMETERS = 11;
    public static final Integer TYPE_INDEX = 2;
    public static final Integer ID_INDEX = 0;

    public static PassengerPlane readPassengerPlaneFromStrArray (Airline airline, String[] valuesOfLine) {
        PassengerPlane passengerPlane = null;
        try {
            if (valuesOfLine.length != COUNT_PASSENGER_PLANES_PARAMETERS) {
                throw new ValidationException("String with information about passenger plane is not correct!");
            }
            int i = 1;
                Integer IDOfPlaneTemp = IDAssignment.assignForPlane(airline, Integer.parseInt(valuesOfLine[ID_INDEX].trim()));
                    passengerPlane = PassengerPlane.factory.getPassengerPlane (IDOfPlaneTemp, valuesOfLine[i++].trim(),
                    valuesOfLine[i++].trim(), Integer.parseInt(valuesOfLine[i++].trim()), valuesOfLine[i++].trim(),
                    valuesOfLine[i++].trim(), Integer.parseInt(valuesOfLine[i++].trim()),
                    Integer.parseInt(valuesOfLine[i++].trim()), Integer.parseInt(valuesOfLine[i++].trim()),
                    Integer.parseInt(valuesOfLine[i++].trim()), Integer.parseInt(valuesOfLine[i++].trim()),
                    Integer.parseInt(valuesOfLine[i++].trim()), Boolean.parseBoolean(valuesOfLine[i++].trim()),
                    Integer.parseInt(valuesOfLine[i++].trim()));
        }
        catch (ValidationException ex) {
            ex.getMessage();
        }
        return passengerPlane;
    }

    public static TransportPlane readTransportPlaneFromStrArray (Airline airline, String[] valuesOfLine) {
        TransportPlane transportPlane = null;
        try {
            if (valuesOfLine.length != COUNT_TRANSPORT_PLANES_PARAMETERS) {
                throw new ValidationException("String with information about transport plane is not correct!");
            }
            int i = 0;
            Integer IDOfPlaneTemp = IDAssignment.assignForPlane(airline, Integer.parseInt(valuesOfLine[ID_INDEX].trim()));
            transportPlane = TransportPlane.factory.getTransportPlane(IDOfPlaneTemp, valuesOfLine[++i].trim(), valuesOfLine[++i].trim(),
                    Integer.parseInt(valuesOfLine[++i].trim()), valuesOfLine[++i].trim(), valuesOfLine[++i].trim(),
                    Integer.parseInt(valuesOfLine[++i].trim()), Integer.parseInt(valuesOfLine[++i].trim()),
                    Integer.parseInt(valuesOfLine[++i].trim()), Integer.parseInt(valuesOfLine[++i].trim()),
                    Integer.parseInt(valuesOfLine[++i].trim()), Integer.parseInt(valuesOfLine[++i].trim()),
                    Integer.parseInt(valuesOfLine[++i].trim()));
        }
        catch (ValidationException ex) {
            ex.getMessage();
        }
        return transportPlane;
    }

    public static Plane readPlaneFromStrArray (Airline airline, String[] valuesOfLine) {
        Plane plane = null;
        try {
            if (valuesOfLine.length != COUNT_PLANE_PARAMETERS) {
                throw new ValidationException("String with information about plane is not correct!");
            }
            int i = TYPE_INDEX;
            Integer IDOfPlaneTemp = IDAssignment.assignForPlane(airline, Integer.parseInt(valuesOfLine[ID_INDEX].trim()));
            plane = Plane.factory.getPlane(IDOfPlaneTemp, valuesOfLine[1].trim(),
                    "not defined", Integer.parseInt(valuesOfLine[++i].trim()),
                    valuesOfLine[++i].trim(),valuesOfLine[++i].trim(), Integer.parseInt(valuesOfLine[++i].trim()),
                    Integer.parseInt(valuesOfLine[++i].trim()), Integer.parseInt(valuesOfLine[++i].trim()),
                    Integer.parseInt(valuesOfLine[++i].trim()), Integer.parseInt(valuesOfLine[++i].trim()));
        }
        catch (ValidationException ex) {
            ex.getMessage();
        }
        return plane;
    }


}
