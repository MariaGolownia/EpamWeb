package by.javatr.multithreading.util;
import java.util.List;

/**
 * Creator is designed to create a matrix from an array of strings read from a file
 * **/


public class Creator {
    private static final int NUMBER_TO_INITIALIZE_MAIN_DIAGONAL = 0;

    public static int[][] createArray (List<String> lines) {
        int countOfRows = lines.size();
        int[][] array = new int[countOfRows][countOfRows];
        int i = 0;
        for (String line : lines) {
            String[] strRowArray = line.split("\\s+");
            int countOfColumn = strRowArray.length;
            for (int j = 0; j < countOfColumn; j++) {
                array[i][j] = Integer.valueOf(strRowArray[j]);
            }
            i++;
        }
        return array;
    }
}
