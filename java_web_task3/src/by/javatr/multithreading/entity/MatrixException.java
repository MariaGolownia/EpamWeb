package by.javatr.multithreading.entity;

/**
 * MatrixException includes exceptions and errors when working with the matrix
 **/

public class MatrixException extends Exception {

    public MatrixException(){
        super();
    };

    public MatrixException(String str){
        super(str);
    };

    public MatrixException(String str, Exception ex){
        super(str, ex);
    };

    public MatrixException(Exception ex){
        super(ex);
    };
}
