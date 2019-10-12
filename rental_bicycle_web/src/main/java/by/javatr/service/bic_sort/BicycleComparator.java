package by.javatr.service.bic_sort;

import java.util.Comparator;

public class SortBicycle {

    public class SortBicycleByModel extends SortBicycleSpecification {
        @Override
        public Comparator comparatorSpecified() {
            return new BicycleComparator.ByModel();
        }
    }

    public class SortBicycleByRate extends SortBicycleSpecification {
        @Override
        public Comparator comparatorSpecified() {
            return new BicycleComparator.ByRate();
        }
    }


    public class SortBicycleByCountry extends SortBicycleSpecification {
        @Override
        public Comparator comparatorSpecified() {
            return new BicycleComparator.ByCountry();
        }
    }

    public class SortBicycleByYear extends SortBicycleSpecification {
        @Override
        public Comparator comparatorSpecified() {
            return new BicycleComparator.ByYear();
        }
    }
}
