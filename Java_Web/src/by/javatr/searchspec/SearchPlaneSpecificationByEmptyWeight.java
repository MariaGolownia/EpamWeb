package by.javatr.searchspec;
import by.javatr.entity.Plane;
import by.javatr.util.TagForSearch;

public class SearchPlaneSpecificationByEmptyWeight extends SearchPlaneSpecification {

    public SearchPlaneSpecificationByEmptyWeight (String searchValue) {
        super(searchValue);
    }

    @Override
    public Boolean specified(Plane plane) {
        TagForSearch.EmptyWeightTagForSearch tagForSearch = new TagForSearch.EmptyWeightTagForSearch();
        return tagForSearch.ifContainsTag(plane, searchValue);
    }
}
