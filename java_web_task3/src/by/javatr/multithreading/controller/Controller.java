package by.javatr.multithreading.controller;

import org.apache.log4j.Logger;

public class Controller {
    private static Logger LOGGER = Logger.getLogger(Controller.class);

    public Boolean checkUserCredentials (String name, String password) {
        LOGGER.debug("Start checkUserCredentials");
        Boolean result = name.equals("Correct") && password.equals("Correct") ? true : false;
        try {
            if (!result) {
                throw new AuthenticationException ("Check that the name and password you entered are correct!");
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        return result;
    }
}
