package by.javatr.valid;

import by.javatr.en.ProducingCountry;
import by.javatr.exc.ValidationException;
import by.javatr.print.PrintToConsole;

import java.util.Calendar;
import java.util.Optional;

public class ValidationPlane {

    public static final int YEAR_OF_FIRST_AIRCRAFT_INVENTION  = 1903;

    public static Boolean ifCorrectModel (String value){
        Boolean result = !value.trim().isEmpty() && value.length()> 2 && value.length() < 30;
        return result;
    }

    public static Boolean ifCorrectType (String value){
        Boolean result = value.trim().equals("passenger") || value.trim().equals("transport")|| value.trim().equals("not defined");
        return result;
    }

    public static Boolean ifCorrectYear (int value){
        Boolean result = value >= YEAR_OF_FIRST_AIRCRAFT_INVENTION && value < Calendar.getInstance().get(Calendar.YEAR)+ 1;
        return result;
    }

    public static Boolean ifCorrectCountry (String value){
        for (ProducingCountry country : ProducingCountry.values()) {
          if (value.toUpperCase().trim().equals(country.toString().trim())) {
              return true;
          }
        }
        return false;
    }

    public static Boolean ifCorrectPlaneString(String value){
        Boolean result = ifCorrectPassengerPlaneString(value) || ifCorrectTransportPlaneString(value);
        return result;
    }

    public static Boolean ifCorrectPassengerPlaneString(String value){
        String regex = "^\\d{1,}\\s{0,}\\w{1,}[,]{1}\\s{0,}[A-Za-z_]{1,}[,]{1}\\s{0,}\\d{1,}[,]{1}\\s{0,}[A-Za-z_]{1,}[,]{1}\\s{0,}" +
                "[A-Za-z_]{1,}[,]{1}\\s{0,}\\d{1,}[,]{1}\\s{0,}\\d{1,}[,]{1}\\s{0,}\\d{1,}[,]{1}\\s{0,}\\d{1,}[,]{1}" +
                "\\s{0,}\\d{1,}[,]{1}\\s{0,}\\d{1,}[,]{1}\\s{0,}[A-Za-z_]{1,}[,]{1}\\s{0,}\\d{1,}\\s{0,}$";
//        String regex = "^\\w{1,}[,]{1}\\s{0,}[A-Za-z_]{1,}[,]{1}\\s{0,}\\d{1,}[,]{1}\\s{0,}[A-Za-z_]{1,}[,]{1}\\s{0,}" +
//                "[A-Za-z_]{1,}[,]{1}\\s{0,}\\d{1,}[,]{1}\\s{0,}\\d{1,}[,]{1}\\s{0,}\\d{1,}[,]{1}\\s{0,}\\d{1,}[,]{1}" +
//                "\\s{0,}\\d{1,}[,]{1}\\s{0,}\\d{1,}[,]{1}\\s{0,}[A-Za-z_]{1,}[,]{1}\\s{0,}\\d{1,}\\s{0,}$";
        Boolean result = value.matches (regex);
        return result;
        // \w - буквенно-цифровой символ или знак подчёркивания
        //\D - нецифровой символ
        // \s - символ пробела
        // \d - цифровой символ
    }

    public static Boolean ifCorrectTransportPlaneString(String value){
        String regex = "^\\\\d{1,}\\\\s{0,}\\w{1,}[,]{1}\\s{0,}\\D{1,}[,]{1}\\s{0,}\\d{1,}[,]{1}\\s{0,}\\D{1,}[,]{1}\\s{0,}\\D{1,}[,]{1}" +
                "\\s{0,}\\d{1,}[,]{1}\\s{0,}\\d{1,}[,]{1}\\s{0,}\\d{1,}[,]{1}\\s{0,}\\d{1,}[,]{1}\\s{0,}\\d{1,}[,]{1}" +
                "\\s{0,}\\d{1,}[,]{1}\\s{0,}\\d{1,}\\s{0,}$";
//        String regex = "^\\w{1,}[,]{1}\\s{0,}\\D{1,}[,]{1}\\s{0,}\\d{1,}[,]{1}\\s{0,}\\D{1,}[,]{1}\\s{0,}\\D{1,}[,]{1}" +
//                "\\s{0,}\\d{1,}[,]{1}\\s{0,}\\d{1,}[,]{1}\\s{0,}\\d{1,}[,]{1}\\s{0,}\\d{1,}[,]{1}\\s{0,}\\d{1,}[,]{1}" +
//                "\\s{0,}\\d{1,}[,]{1}\\s{0,}\\d{1,}\\s{0,}$";
        Boolean result = value.matches (regex);
        return result;
    }

    public static Boolean ifPresentString (Optional <String> obj) {
        Boolean ifPresentParameter = false;
        try {
            ifPresentParameter = obj.isPresent();
            if (!ifPresentParameter) {
                throw new ValidationException("Warning: not a valid value (null)!" +
                        obj.toString() + "parameter must be filled!");
            }
        } catch (ValidationException ex) {
            PrintToConsole.println(ex.getMessage());
        }
        return ifPresentParameter;
    }

    public static Boolean ifPresentInteger (Optional <Integer> obj) {
        Boolean ifPresentParameter = false;
        try {
            ifPresentParameter = obj.isPresent();
            if (!ifPresentParameter) {
                throw new ValidationException("Warning: not a valid value (null)!" +
                        obj.toString() + "parameter must be filled!");
            }
        } catch (ValidationException ex) {
            PrintToConsole.println(ex.getMessage());
        }
        return ifPresentParameter;
    }


}
