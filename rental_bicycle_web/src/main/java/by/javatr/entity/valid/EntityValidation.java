package by.javatr.entity.valid;

import by.javatr.entity.City;
import by.javatr.entity.Country;

import java.util.ArrayList;
import java.util.List;

public class EntityValidation {

    // Валидация принадлежности города к конкретной стране
    public Boolean ifCityBelongsToCountry (Country country, City city) {
        List<City> listCity = new ArrayList<>();
        listCity = City.getByCountry(country);
        if (listCity.contains(city)) {
            return true;
        }
        else {
            return false;
        }
    }
}
