package by.javatr.searchspec;
import by.javatr.entity.Plane;
import by.javatr.util.TagForSearch;

public class SearchPlaneSpecificationByCompany extends SearchPlaneSpecification {

    public SearchPlaneSpecificationByCompany (String searchValue) {
        super(searchValue);
    }

    @Override
    public Boolean specified(Plane plane) {
        TagForSearch.ManufacturingCompanyTagForSearch tagForSearch = new TagForSearch.ManufacturingCompanyTagForSearch();
        return tagForSearch.ifContainsTag(plane, searchValue);
    }

}
