package by.javatr.searchspec;
import by.javatr.entity.Plane;
import by.javatr.util.TagForSearch;

public class SearchPlaneSpecificationBySeatingCapacity extends SearchPlaneSpecification {

    public SearchPlaneSpecificationBySeatingCapacity (String searchValue) {
        super(searchValue);
    }

    @Override
    public Boolean specified(Plane plane) {
        TagForSearch.SeatingCapacityTagForSearch tagForSearch = new TagForSearch.SeatingCapacityTagForSearch();
        return tagForSearch.ifContainsTag(plane, searchValue);
    }
}
