package by.javatr.searchspec;
import by.javatr.entity.Plane;
import by.javatr.util.TagForSearch;

public class SearchPlaneSpecificationByYear extends SearchPlaneSpecification {

    public SearchPlaneSpecificationByYear (String searchValue) {
        super( searchValue);
    }


    @Override
    public Boolean specified(Plane plane) {
        TagForSearch.YearTagForSearch tagForSearch = new TagForSearch.YearTagForSearch();
        return tagForSearch.ifContainsTag(plane, searchValue);
    }
}
