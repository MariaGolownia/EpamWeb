package by.javatr.multithreading.util;
import by.javatr.multithreading.entity.Matrix;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
/**
 * ThreadDiagonal is designed to work with multithreading and changing the main diagonal of the matrix
 * **/

public class ThreadDiagonal extends Thread {
    private static final Lock lock = new ReentrantLock();
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
            System.out.println("run: " + this.uniqueNumber);
            try {
                for (int i = 0; i < array.length; i++) {

                    for (int j = 0; j < array[0].length; j++) {
                            if (i == j && array[i][j] == 0 && lock.tryLock()) {
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
                System.err.print(e);
            }
    }

    public static int[][] getArray () {
        return array.clone();
    }


}
