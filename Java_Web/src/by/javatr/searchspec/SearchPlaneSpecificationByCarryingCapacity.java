package by.javatr.searchspec;
import by.javatr.entity.Plane;
import by.javatr.util.TagForSearch;

public class SearchPlaneSpecificationByCarryingCapacity extends SearchPlaneSpecification {

    public SearchPlaneSpecificationByCarryingCapacity (Plane plane, String searchValue) {
        super (searchValue);
    }

    @Override
    public Boolean specified(Plane plane) {
        TagForSearch.CarryingCapacityTagForSearch tagForSearch = new TagForSearch.CarryingCapacityTagForSearch();
        return tagForSearch.ifContainsTag(plane, searchValue);

    }


}
