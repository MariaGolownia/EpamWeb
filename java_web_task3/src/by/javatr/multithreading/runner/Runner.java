package by.javatr.multithreading.runner;
import by.javatr.multithreading.entity.Matrix;

public class Runner {

    public static void main(String[] args) {
        //Incorrect initialization in accordance with the conditions of the task
        Matrix matrix0 = new Matrix(22);
        matrix0.show();

        //Correct initialization in accordance with the conditions of the task
        Matrix matrix01 = new Matrix(9);
        matrix01.show();

        //Incorrect initialization in accordance with the conditions of the task
        Matrix matrix1 = new Matrix(9, 10);
        matrix1.show();

        //Correct initialization in accordance with the conditions of the task
        Matrix matrix11 = new Matrix(10, 10);
        matrix11.show();

        //Incorrect initialization in accordance with the conditions of the task
        Matrix matrix2 = new Matrix(6, 6, false);
        matrix2.show();

        //Correct initialization in accordance with the conditions of the task
        Matrix matrix21 = new Matrix(11, 11, false);
        matrix21.show();

        //Incorrect initialization in accordance with the conditions of the task
        Matrix matrix3 = new Matrix(7, 7, true);
        matrix3.show();

        //Correct initialization in accordance with the conditions of the task
        Matrix matrix31 = new Matrix(12, 12, true);
        matrix31.show();

        //Correct initialization in accordance with the conditions of the task
        Matrix matrix4 = new Matrix(8, 8, true,1,100);
        matrix4.show();
    }
}
