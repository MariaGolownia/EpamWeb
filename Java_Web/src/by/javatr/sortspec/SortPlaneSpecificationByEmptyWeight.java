package by.javatr.sortspec;
import by.javatr.util.ComparatorPlaneForSort;

import java.util.Comparator;

public class SortPlaneSpecificationByEmptyWeight extends SortPlaneSpecification {
    @Override
    public Comparator comparatorSpecified() {
        return new ComparatorPlaneForSort.byEmptyWeight();
    }
}
