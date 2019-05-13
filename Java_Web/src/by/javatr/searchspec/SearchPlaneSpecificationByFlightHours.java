package by.javatr.searchspec;
import by.javatr.entity.Plane;
import by.javatr.util.TagForSearch;

public class SearchPlaneSpecificationByFlightHours extends SearchPlaneSpecification {

    public SearchPlaneSpecificationByFlightHours (String searchValue) {
        super(searchValue);
    }


    @Override
    public Boolean specified(Plane plane) {
        TagForSearch.HoursOfFlightsTagForSearch tagForSearch = new TagForSearch.HoursOfFlightsTagForSearch();
        return tagForSearch.ifContainsTag(plane, searchValue);
    }
}
