package by.javatr.multithreading.controller;

/**
 * AuthenticationException includes exceptions and errors of users authentication
 **/

public class AuthenticationException extends Exception {

    public AuthenticationException(){
        super();
    };

    public AuthenticationException(String str){
        super(str);
    };

    public AuthenticationException(String str, Exception ex){
        super(str, ex);
    };

    public AuthenticationException(Exception ex){
        super(ex);
    };
}
