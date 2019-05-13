package by.javatr.searchspec;
import by.javatr.entity.Plane;
import by.javatr.util.TagForSearch;

public class SearchPlaneSpecificationByFuelConsumption extends SearchPlaneSpecification {

    public SearchPlaneSpecificationByFuelConsumption (String searchValue) {
        super(searchValue);
    }

    @Override
    public Boolean specified(Plane plane) {
        TagForSearch.FuelConsumptionTagForSearch tagForSearch = new TagForSearch.FuelConsumptionTagForSearch();
        return tagForSearch.ifContainsTag(plane, searchValue);
    }
}
