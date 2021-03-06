package by.javatr.multithreading.service.util;
import by.javatr.multithreading.service.entity.Matrix;
import org.apache.log4j.Logger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
/**
 * ThreadDiagonal is designed to work with multithreading and changing the main diagonal of the matrix
 * **/

public class ThreadDiagonal extends Thread {
    private static Logger LOGGER = Logger.getLogger(ThreadDiagonal.class);
    private static final Lock lock = new ReentrantLock();
    private static final int DEFAULT_NUMBER_OF_MAIN_DIAGONAL = 0;
    private int uniqueNumber;
    private static int[][] array;

    public ThreadDiagonal () {
        super();
    }

    public ThreadDiagonal (Matrix matrix, int uniqueNumber) {
      super();
      ThreadDiagonal.array = matrix.getArray();
      this.uniqueNumber = uniqueNumber;
    }

    public void run() {
            LOGGER.debug("Start run");
            try {
                for (int i = 0; i < array.length; ++i) {
                    for (int j = 0; j < array[0].length; ++j) {
                            if (i == j && array[i][j] == DEFAULT_NUMBER_OF_MAIN_DIAGONAL && lock.tryLock()) {
                                try {
                                    array[i][j] = this.uniqueNumber;
                                }
                                finally {
                                    lock.unlock();
                                    TimeUnit.MILLISECONDS.sleep(2);
                                }
                            }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                LOGGER.error("InterruptedException run");
            }
    }

    public static int[][] getArray () {
        return array.clone();
    }


}
