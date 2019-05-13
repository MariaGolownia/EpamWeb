package by.javatr.valid;

public class ValidationIfNumber {

    public static final int MAX_VALUE_OF_INTEGER  = Integer.MAX_VALUE;        //2147483647
    public static final int MIN_VALUE_OF_INTEGER  = Integer.MAX_VALUE;        //-2147483648
    public static final int MAX_STRINGS_LENGTH_OF_INTEGER_WITH_MINUS = 11;

    public static final double MAX_VALUE= Double.MAX_VALUE;                   //1.7976931348623157E308;
    public static final double MIN_VALUE=Double.MIN_VALUE;                    //1.7e-308


    public static Boolean ifInteger (String valueString){
        String regex = "^[-+]?[0-9]+$";
        if (valueString.length()> MAX_STRINGS_LENGTH_OF_INTEGER_WITH_MINUS) {
            return false;
        }
        else if (!valueString.matches (regex)) {
            return false;
        }
        else if (Long.valueOf(valueString) < MIN_VALUE_OF_INTEGER || Long.valueOf(valueString) > MAX_VALUE_OF_INTEGER) {
            return false;
        }
        return true;
    }

        public static Boolean ifDouble (String valueString){
        String regex = "^[-+]?[0-9]*[.,]?[0-9]+$";
        Boolean result = valueString.matches (regex);
        return result;
    }
}
