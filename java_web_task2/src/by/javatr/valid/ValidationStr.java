package by.javatr.valid;

public class ValidationStr {

    public static Boolean ifExist (String str) {
        Boolean ifExist = (str != null) && (!str.isEmpty());
        return ifExist;
    }
}
