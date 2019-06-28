package by.javatr.rep;
import by.javatr.entity.Airline;
import by.javatr.entity.Plane;
import by.javatr.reader.ReaderAirlineFromFile;
import by.javatr.record.RecordAirlineToFile;
import by.javatr.searchspec.SearchPlaneSpecification;
import by.javatr.sortspec.SortPlaneSpecification;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileRepository implements RepositoryPlane<Plane> {
    String FILE_NAME = "result.txt";
    @Override
    public void addPlane(Plane plane) {
        Airline airlineFromFile = Airline.getInstance();
        ReaderAirlineFromFile readerAirlineFromFile = new ReaderAirlineFromFile();
        airlineFromFile = readerAirlineFromFile.readPlanesFromFile(FILE_NAME);
        airlineFromFile.addPlane(plane);
        RecordAirlineToFile recordAirlineToFile = new RecordAirlineToFile();
        try {
            recordAirlineToFile.record(airlineFromFile, FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removePlane(Plane plane) {
        Airline airlineFromFile = Airline.getInstance();
        ReaderAirlineFromFile readerAirlineFromFile = new ReaderAirlineFromFile();
        airlineFromFile = readerAirlineFromFile.readPlanesFromFile(FILE_NAME);
        airlineFromFile.remove(plane);
        RecordAirlineToFile recordAirlineToFile = new RecordAirlineToFile();
        try {
            recordAirlineToFile.record(airlineFromFile, FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePlane(Plane plane) {
        Airline airlineFromFile = Airline.getInstance();
        ReaderAirlineFromFile readerAirlineFromFile = new ReaderAirlineFromFile();
        airlineFromFile = readerAirlineFromFile.readPlanesFromFile(FILE_NAME);
        airlineFromFile.update(plane);
        RecordAirlineToFile recordAirlineToFile = new RecordAirlineToFile();
        try {
            recordAirlineToFile.record(airlineFromFile, FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Plane> query(SortPlaneSpecification sortPlaneSpecification) {
        List<Plane> rezList = new ArrayList<>();
        Airline airlineFromFile = Airline.getInstance();
        ReaderAirlineFromFile readerAirlineFromFile = new ReaderAirlineFromFile();
        airlineFromFile = readerAirlineFromFile.readPlanesFromFile(FILE_NAME);
        airlineFromFile.sort(sortPlaneSpecification.comparatorSpecified());
        for (int i = 0; i < airlineFromFile.getCountOfPlanes();i++) {
            rezList.add(airlineFromFile.getPlaneByIndex(i));
        }
        return rezList;
    }


    @Override
    public List<Plane> query(SearchPlaneSpecification searchPlaneSpecification) {
        List<Plane> rezList = new ArrayList<>();
        Airline airlineFromFile = Airline.getInstance();
        ReaderAirlineFromFile readerAirlineFromFile = new ReaderAirlineFromFile();
        airlineFromFile = readerAirlineFromFile.readPlanesFromFile(FILE_NAME);

        for (int i = 0; i < airlineFromFile.getCountOfPlanes(); i++) {

        if (searchPlaneSpecification.specified(airlineFromFile.getPlaneByIndex(i))){
            rezList.add(airlineFromFile.getPlaneByIndex(i));
            }
        }
        return rezList;
    }
}
