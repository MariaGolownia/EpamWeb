package by.javatr.multithreading.dal.creator;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

/**
 * Creator is designed to create a matrix or flows from an array of strings read from a file
 * **/

public class Creator {
    private static Logger LOGGER = Logger.getLogger(Creator.class);
    private static final int NUMBER_TO_INITIALIZE_MAIN_DIAGONAL = 0;

    public static int[][] createArray (List<String> lines) {
        LOGGER.debug("Start createArray");
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

    public static List<Integer> createFlow (List<String> lines) {
        LOGGER.debug("Start createFlow");
        int countOfRows = lines.size();
        List<Integer> uniqueSreamNumbers = new ArrayList<>();
        int i = 0;
        for (String line : lines) {
            String[] strRowArray = line.split("\\s+");
            for (int j = 0; j < strRowArray.length; j++) {
                uniqueSreamNumbers.add(Integer.valueOf(strRowArray[j]));
            }
            }
        return uniqueSreamNumbers;
        }

}
