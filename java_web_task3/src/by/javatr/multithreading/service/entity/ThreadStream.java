package by.javatr.multithreading.service.entity;
import by.javatr.multithreading.service.entity.Matrix;
import by.javatr.multithreading.service.util.ThreadDiagonal;
import by.javatr.multithreading.service.valid.Validation;

import java.util.ArrayList;
import java.util.List;

public class ThreadStream {
    List<ThreadDiagonal> threadDiagonalArray;

    public ThreadStream(Matrix matrix, List<Integer>uniqueSreamNumbers) {
        Validation validation = new Validation();
        validation.validateUniqueNumberOfStreams(uniqueSreamNumbers);
        threadDiagonalArray = new ArrayList<>();
        for (Integer number : uniqueSreamNumbers) {
            threadDiagonalArray.add(new ThreadDiagonal(matrix, number));
        }
    }

    public void threadStart () {
        for (ThreadDiagonal thread : threadDiagonalArray) {
            thread.start();
        }
    }

    public void threadJoin () {
            try{
                for (ThreadDiagonal thread : threadDiagonalArray) {
                    thread.join();
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
}
