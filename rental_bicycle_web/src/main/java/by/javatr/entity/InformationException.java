package by.javatr.entity;

public class InformationException extends Exception {

    public InformationException(){
        super();
    };

    public InformationException(String str){
        super(str);
    };

    public InformationException(String str, Exception ex){
        super(str, ex);
    };

    public InformationException(Exception ex){
        super(ex);
    };
}
