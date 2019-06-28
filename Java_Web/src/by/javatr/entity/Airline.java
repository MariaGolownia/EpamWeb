package by.javatr.entity;
import by.javatr.util.AbstractTagForSearch;
import by.javatr.util.IDAssignment;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Airline implements Cloneable {
    private static Logger LOGGER = Logger.getLogger(Airline.class);
    private static List<Integer> listIDOfPlanesOfAiline = new ArrayList<>();
    private List<Plane> listOfPlanes = new ArrayList<>();

    private Airline () {}
    private static class AirlineHolder {
        private final static Airline instance = new Airline ();
    }

    public static Airline getInstance () {
        LOGGER.debug("Start getInstance()");
        return AirlineHolder.instance;
    }

    public void addPlane(Plane plane) {
        LOGGER.debug("Start addPlane");
       Integer ID = IDAssignment.assignForPlane(listIDOfPlanesOfAiline, plane.getIDOfPlane());
        listIDOfPlanesOfAiline.add(ID);
       plane.setIDOfPlaneOfAirline(ID);
        listOfPlanes.add(plane);
    }

    public void addPlanes(Plane... plane) {
        LOGGER.debug("Start addPlanes");
        for (int i = 1; i < plane.length; i++) {
            plane[i].setIDOfPlane(IDAssignment.assignForPlane(this, plane[i].getIDOfPlane()));
            listOfPlanes.add(plane[i]);
        }
    }

    public Plane getPlaneByIndex(int index) {
        LOGGER.debug("Start getPlaneByIndex");
        return listOfPlanes.get(index);
    }

    public List<Plane> getPlanes() {
        return listOfPlanes;
    }

    public Integer getCountOfPlanes() {
        LOGGER.debug("Start getCountOfPlanes");
        return listOfPlanes.size();
    }

    public  void remove (Plane plane) {
        LOGGER.debug("Start remove");
        Integer IDOfRemotePlane = plane.getIDOfPlane();
        for (int i = 0; i < listOfPlanes.size(); i++){
            if (listOfPlanes.get(i).getIDOfPlane().equals(IDOfRemotePlane)) {
                listOfPlanes.remove(i);
                listIDOfPlanesOfAiline.remove(IDOfRemotePlane);
            }
        }
    }

    public  void update (Plane plane) {
        LOGGER.debug("Start update");
        for (int i = 0; i < listOfPlanes.size(); i++)
            if (listOfPlanes.get(i).getIDOfPlane().equals(plane.getIDOfPlane())) {
                 listOfPlanes.set(i, plane);
            }
    }

    public List<Plane> searchByTag(AbstractTagForSearch checkByTag, String tagValue) {
            List<Plane> rezList = new ArrayList<>();
            for (Plane planeItem : listOfPlanes) {
                if (checkByTag.ifContainsTag(planeItem, tagValue)) {
                    rezList.add(planeItem);
                }
            }
            return rezList;
        }


        public List<Plane> searchByTagInRange(AbstractTagForSearch checkByTag, String tagValue1, String tagValue2) {
            List<Plane> rezList = new ArrayList<>();
            for (Plane planeItem : listOfPlanes) {
                if (checkByTag.ifContainsTag(planeItem, tagValue1, tagValue2)) {
                    rezList.add(planeItem);
                }
            }
            return rezList;
        }

        public Integer getMaxIdOfPlanes() {
        Integer maxIdOfPlanes = 0;
        for (int i = 0; i < this.getCountOfPlanes(); i++) {
            if (maxIdOfPlanes < this.getPlaneByIndex(i).getIDOfPlane()) {
                maxIdOfPlanes = this.getPlaneByIndex(i).getIDOfPlane();
            }
        }
        return  maxIdOfPlanes;
    }

//    public  List<Integer> getListOfPlanes() {
//        List<Integer> listOfPlanes = new ArrayList<>();
//        for (int i = 0; i <  this.getCountOfPlanes(); i++) {
//            listOfPlanes.add(i);
//        }
//        return  listOfPlanes;
//    }

    public void sort(Comparator<Plane> c) {listOfPlanes.sort(c);
    }

    public void sort() {
        Collections.sort(listOfPlanes);
   }


    @Override
    public String toString() {
        return "Airline{" +
                "listOfPlanes=" + listOfPlanes +
                '}';
    }

    public Airline clone()     {
        Airline airlineClone = new Airline ();
        for (int i = 0; i < this.getCountOfPlanes(); i++){
            airlineClone.addPlane(this.getPlaneByIndex(i));
            airlineClone.getPlaneByIndex(i).setIDOfPlane(this.getPlaneByIndex(i).getIDOfPlane());
        }
        return airlineClone;
    }
}
