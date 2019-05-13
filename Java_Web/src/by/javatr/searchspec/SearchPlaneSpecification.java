package by.javatr.searchspec;
import by.javatr.entity.Plane;

public abstract class SearchPlaneSpecification {

    protected String searchValue;

    public SearchPlaneSpecification (String searchValue) {
        this.searchValue = searchValue;
    }

    public abstract Boolean specified(Plane plane);

}