package by.javatr.util;
import by.javatr.entity.Plane;

public class TagForSearch {

    public static class ModelTagForSearch implements AbstractTagForSearch {
        @Override
        public boolean ifContainsTag(Plane plane, String tag) {
            return plane.getModelOfPlane().equals(tag.trim());
        }

        // Для поиска самолета, который является или одной или другой моделью поиска
        @Override
        public boolean ifContainsTag(Plane plane, String tag1, String tag2) {
            return plane.getModelOfPlane().equals(tag1.trim()) || plane.getModelOfPlane().equals(tag2.trim());
        }
    }

    public static class TypeTagForSearch implements AbstractTagForSearch {
        @Override
        public boolean ifContainsTag(Plane plane, String tag) {
            return plane.getTypeOfPlane().equals(tag.trim());
        }

        @Override
        public boolean ifContainsTag(Plane plane, String tag1, String tag2) {
            return plane.getTypeOfPlane().equals(tag1.trim())||
                    plane.getTypeOfPlane().equals(tag2.trim());
        }
    }

    public static class YearTagForSearch implements AbstractTagForSearch {
        @Override
        public boolean ifContainsTag(Plane plane, String tag) {
            return plane.getYearOfProduction().toString().equals(tag);
        }

        // Для поиска самолета, произведенного в диапазоне лет
        @Override
        public boolean ifContainsTag(Plane plane, String tag1, String tag2) {
            return Integer.parseInt(plane.getYearOfProduction().toString()) >= Integer.parseInt(tag1.trim()) &&
                    Integer.parseInt(plane.getYearOfProduction().toString()) <= Integer.parseInt(tag2.trim());
        }
    }

    public static class ProducingCountryTagForSearch implements AbstractTagForSearch {
        @Override
        public boolean ifContainsTag(Plane plane, String tag) {
            return plane.getProducingCountry().trim().equals(((String)tag).trim());
        }

        @Override
        public boolean ifContainsTag(Plane plane, String tag1, String tag2) {
            return plane.getProducingCountry().trim().equals(((String)tag1).trim()) ||
                    plane.getProducingCountry().trim().equals(((String)tag2).trim());
        }
    }

    public static class ManufacturingCompanyTagForSearch implements AbstractTagForSearch {
        @Override
        public boolean ifContainsTag(Plane plane, String tag) {
            return plane.getManufacturingCompany().trim().equals(((String)tag).trim());
        }

        @Override
        public boolean ifContainsTag(Plane plane, String tag1, String tag2) {
            return plane.getManufacturingCompany().trim().equals((tag1).trim()) ||
                    plane.getManufacturingCompany().trim().equals((tag2).trim());
        }
    }

    public static class SeatingCapacityTagForSearch implements AbstractTagForSearch {
        @Override
        public boolean ifContainsTag(Plane plane, String tag) {
            return plane.getSeatingCapacityUnit().equals(Integer.parseInt(tag.trim()));
        }

        @Override
        public boolean ifContainsTag(Plane plane, String tag1, String tag2) {
            return Integer.parseInt(plane.getSeatingCapacityUnit().toString()) >= Integer.parseInt(tag1.trim())
                    && Integer.parseInt(plane.getSeatingCapacityUnit().toString()) <= Integer.parseInt(tag2.trim());
        }
    }

    public static class CarryingCapacityTagForSearch implements AbstractTagForSearch {
        @Override
        public boolean ifContainsTag(Plane plane, String tag) {
            return plane.getCarryingCapacityKilo().equals(Integer.parseInt(tag.trim()));
        }

        @Override
        public boolean ifContainsTag(Plane plane, String tag1, String tag2) {
            return Integer.parseInt(plane.getCarryingCapacityKilo().toString()) >= Integer.parseInt(tag1.trim()) &&
                    Integer.parseInt(plane.getCarryingCapacityKilo().toString()) <= Integer.parseInt(tag2.trim());
        }
    }

    public static class FuelConsumptionTagForSearch implements AbstractTagForSearch {
        @Override
        public boolean ifContainsTag(Plane plane, String tag) {
            return plane.getFuelConsumptionKiloPerHour().equals(Integer.parseInt(tag.trim()));
        }

        @Override
        public boolean ifContainsTag(Plane plane, String tag1, String tag2) {
            return Integer.parseInt(plane.getFuelConsumptionKiloPerHour().toString()) >= Integer.parseInt(tag1.trim()) &&
                    Integer.parseInt(plane.getFuelConsumptionKiloPerHour().toString()) <= Integer.parseInt(tag2.trim());
        }
    }

    public static class EmptyWeightTagForSearch implements AbstractTagForSearch {
        @Override
        public boolean ifContainsTag(Plane plane, String tag) {
            return plane.getEmptyWeightKilo().equals(Integer.parseInt(tag.trim()));
        }

        @Override
        public boolean ifContainsTag(Plane plane, String tag1, String tag2) {
            return Integer.parseInt(plane.getEmptyWeightKilo().toString()) >= Integer.parseInt(tag1.trim()) &&
                    Integer.parseInt(plane.getEmptyWeightKilo().toString()) <= Integer.parseInt(tag2.trim());
        }
    }

    public static class HoursOfFlightsTagForSearch implements AbstractTagForSearch {
        @Override
        public boolean ifContainsTag(Plane plane, String tag) {
            return plane.getHoursOfFlightsHours().equals(Integer.parseInt(tag.trim()));
        }

        @Override
        public boolean ifContainsTag(Plane plane,  String tag1, String tag2) {
            return Integer.parseInt(plane.getHoursOfFlightsHours().toString()) >= Integer.parseInt(tag1.trim()) &&
                    Integer.parseInt(plane.getHoursOfFlightsHours().toString()) <= Integer.parseInt(tag2.trim());
        }
    }


}
