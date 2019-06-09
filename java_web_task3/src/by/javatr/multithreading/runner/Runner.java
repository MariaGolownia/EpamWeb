package by.javatr.multithreading.runner;
import by.javatr.multithreading.entity.Matrix;
import by.javatr.multithreading.reader.ReaderFromFile;
import by.javatr.multithreading.util.Creator;
import by.javatr.multithreading.util.ThreadDiagonal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Runner {

    public static void main(String[] args) {
        List<String> resultFromFile = ReaderFromFile.readFromFile("data.txt");
        int[][] array;
        array = Creator.createArray(resultFromFile);
        Matrix matrix = Matrix.getInstance();
        matrix.initializeMatrix(array);
        matrix.show();

        /*
        //Correct initialization in accordance with the conditions of the task
        Matrix matrix01 = Matrix.getInstance();
        matrix01.initializeMatrix(9);
        matrix01.show();

        //Correct initialization in accordance with the conditions of the task
        Matrix matrix11 = Matrix.getInstance();
        matrix11.initializeMatrix(10, 10);
        matrix11.show();

        //Correct initialization in accordance with the conditions of the task
        matrix11.initializeMatrix(11,11,10);
        matrix11.show();


        //Correct initialization in accordance with the conditions of the task
        matrix11.initializeMatrix(12, 12, true);
        matrix11.show();

        //Correct initialization in accordance with the conditions of the task
        matrix11.initializeMatrix(8, 8, true,1,100);
        matrix11.show();


        ThreadDiagonal threadDiagonal1 = new ThreadDiagonal(matrix11, 1);
        ThreadDiagonal threadDiagonal2 = new ThreadDiagonal(matrix11, 2);
        ThreadDiagonal threadDiagonal3 = new ThreadDiagonal(matrix11, 3);
        ThreadDiagonal threadDiagonal4 = new ThreadDiagonal(matrix11, 4);
        threadDiagonal1.start();
        threadDiagonal2.start();
        threadDiagonal3.start();
        threadDiagonal4.start();

        try{
            threadDiagonal1.join();
            threadDiagonal2.join();
            threadDiagonal3.join();
            threadDiagonal4.join();
        }
         catch (InterruptedException e) {
            e.printStackTrace();
        }
        matrix11.show();
 */
    }

}
