package by.javatr.entity;

import java.util.ArrayList;
import java.util.List;

public enum City {
    MINSK("Minsk"),
    GRODNO("Grodno"),
    LIDA("Lida"),
    POZNAN("Poznan"),
    BIALYSTOK ("Bialystok"),
    KRAKOV ("Krakov"),
    VILNIUSE ("Vilnius"),
    KAUNAS("Kaunas"),
    TRAKAJ("Trakai");

    private static final Integer START_INDEX_BELARUS_CITIES = 0;
    private static final Integer FINISH_INDEX_BELARUS_CITIES = 2;
    private static final Integer START_INDEX_POLAND_CITIES = 3;
    private static final Integer FINISH_INDEX_POLAND_CITIES = 5;
    private static final Integer START_INDEX_LITHUANIA_CITIES = 6;
    private static final Integer FINISH_INDEX_LITHUANIA_CITIES = 8;
    private String name;

    private City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getIdentity() {
        return ordinal();
    }

    public static City getByIdentity(Integer identity) {
        return City.values()[identity];
    }

    public static List<City> getByCountry(Country country) {
        List<City>cityList = new ArrayList<>();
        for (int i = 0; i < City.values().length; i++) {
            if (country.equals(Country.BELARUS)) {
                cityList.subList(START_INDEX_BELARUS_CITIES, FINISH_INDEX_BELARUS_CITIES);
            }
            else if (country.equals(Country.POLAND)){
                cityList.subList(START_INDEX_POLAND_CITIES, FINISH_INDEX_POLAND_CITIES);
            }
            else if (country.equals(Country.LITHUANIA)) {
                cityList.subList(START_INDEX_LITHUANIA_CITIES, FINISH_INDEX_LITHUANIA_CITIES);
            }
            else {
                try {
                    throw new InformationException("Please contact the developer to extend the software application" +
                            " to the level of your region!");
                } catch (InformationException e) {
                    e.printStackTrace();
                }
            }
        }
        return cityList;
    }
}
