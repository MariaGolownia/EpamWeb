package by.javatr.searchspec;
import by.javatr.entity.Plane;
import by.javatr.util.TagForSearch;

public class SearchPlaneSpecificationByModel extends SearchPlaneSpecification {

    public SearchPlaneSpecificationByModel (String searchValue) {
        super(searchValue);
    }

    @Override
    public Boolean specified(Plane plane) {
        TagForSearch.ModelTagForSearch tagForSearch = new TagForSearch.ModelTagForSearch();
        return tagForSearch.ifContainsTag(plane, searchValue);
    }
}
