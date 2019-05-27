package by.javatr.valid;

import org.apache.log4j.Logger;

public class ValidationStr {

    private static Logger LOGGER = Logger.getLogger(ValidationStr.class);

    public static Boolean ifExist (String str) {
        Boolean ifExist = (str != null) && (!str.isEmpty());
        return ifExist;
    }
}
