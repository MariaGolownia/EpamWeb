package by.javatr.rep;
import by.javatr.entity.Plane;
import by.javatr.searchspec.SearchPlaneSpecification;
import by.javatr.sortspec.SortPlaneSpecification;

import java.util.List;

public interface RepositoryPlane<T extends Plane> {

    void addPlane(T plane);
    void removePlane(T plane);
    void updatePlane(T plane);
    List<T> query(SortPlaneSpecification sortPlaneSpecification);
    List<T> query(SearchPlaneSpecification searchPlaneSpecification);
}
