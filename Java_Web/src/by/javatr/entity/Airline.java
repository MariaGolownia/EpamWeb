package by.javatr.entity;
import by.javatr.util.AbstractTagForSearch;
import by.javatr.util.IDAssignment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Airline implements Cloneable {
    private Integer digitToCountIDOfPlane = 0;
    List<Plane> listOfPlanes = new ArrayList<>();


    public void addPlane(Plane plane) {
        plane.setIDOfPlane(IDAssignment.assign(this, plane, 0));
        listOfPlanes.add(plane);
    }

    public void addPlanes(Plane... plane) {
        for (int i = 1; i < plane.length; i++) {
            plane[i].setIDOfPlane(IDAssignment.assign(this, plane[i], 0));
            listOfPlanes.add(plane[i]);
        }
    }

    public Plane getPlaneByIndex(int index) {
        return listOfPlanes.get(index);
    }

    public List<Plane> getPlanes() {
        return listOfPlanes;
    }

    public Integer getCountOfPlanes() {
        return listOfPlanes.size();
    }

    public  void remove (Plane plane) {
        for (int i = 0; i < listOfPlanes.size(); i++){
            if (listOfPlanes.get(i).getIDOfPlane().equals(plane.getIDOfPlane())) {
                listOfPlanes.remove(i);
            }
        }
    }

    public  void update (Plane plane) {
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
