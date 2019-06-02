package by.javatr.exc;

public class ReaderException extends Exception {

    public ReaderException(){
        super();
    };

    public ReaderException(String str){
        super(str);
    };

    public ReaderException(String str, Exception ex){
        super(str, ex);
    };

    public ReaderException(Exception ex){
        super(ex);
    };
}
