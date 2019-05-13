package by.javatr.sortspec;

import by.javatr.util.ComparatorPlaneForSort;

import java.util.Comparator;

public class SortPlaneSpecificationByType extends SortPlaneSpecification {
    @Override
    public Comparator comparatorSpecified() {
        return new ComparatorPlaneForSort.byTypeComparator();
    }
}
