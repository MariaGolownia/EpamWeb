package by.javatr.searchspec;
import by.javatr.entity.Plane;
import by.javatr.util.TagForSearch;

public class SearchPlaneSpecificationByCountry extends SearchPlaneSpecification {

    public SearchPlaneSpecificationByCountry ( String searchValue) {
        super(searchValue);
    }

    @Override
    public Boolean specified(Plane plane) {
        TagForSearch.ProducingCountryTagForSearch tagForSearch = new TagForSearch.ProducingCountryTagForSearch();
        return tagForSearch.ifContainsTag(plane, searchValue);
    }
}
