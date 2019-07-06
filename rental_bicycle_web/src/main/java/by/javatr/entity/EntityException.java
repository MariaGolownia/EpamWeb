package by.javatr.entity;

public class EntityException extends Exception {

    public EntityException(){
        super();
    };

    public EntityException(String str){
        super(str);
    };

    public EntityException(String str, Exception ex){
        super(str, ex);
    };

    public EntityException(Exception ex){
        super(ex);
    };
}
