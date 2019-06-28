package by.javatr.searchspec;
import by.javatr.entity.Plane;
import by.javatr.util.TagForSearch;

public class SearchPlaneSpecificationByType extends SearchPlaneSpecification {

    public SearchPlaneSpecificationByType (String searchValue) {
        super(searchValue);
    }

    @Override
    public Boolean specified(Plane plane) {
        TagForSearch.TypeTagForSearch tagForSearch = new TagForSearch.TypeTagForSearch();
        return tagForSearch.ifContainsTag(plane, searchValue);
    }
}
