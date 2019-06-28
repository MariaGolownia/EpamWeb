package by.javatr.multithreading.service.entity;
import by.javatr.multithreading.service.entity.Matrix;
import by.javatr.multithreading.service.util.ThreadDiagonal;
import by.javatr.multithreading.service.valid.Validation;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ThreadStream {
    private static Logger LOGGER = Logger.getLogger(ThreadStream.class);
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
        LOGGER.debug("Start threadStart");
        for (ThreadDiagonal thread : threadDiagonalArray) {
            thread.start();
        }
    }

    public void threadJoin () {
        LOGGER.debug("Start threadJoin");
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
