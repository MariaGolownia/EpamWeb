package by.javatr.service;

public class ServiceException  extends Exception{

    public ServiceException(){
        super();
    };

    public ServiceException(String str){
        super(str);
    };

    public ServiceException(String str, Exception ex){
        super(str, ex);
    };

    public ServiceException(Exception ex){
        super(ex);
    };

}
