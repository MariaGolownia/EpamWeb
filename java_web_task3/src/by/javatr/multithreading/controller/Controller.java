package by.javatr.multithreading.controller;

public class Controller {

    public Boolean checkUserCredentials (String name, String password) {
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
