package by.javatr.multithreading.service.util;

/**
 * Calculation is designed to work out certain calculations on the matrix
 * **/

public class Calculation {

    // Определение максимального разряда в матрица
    // Метод используется для эргономичного вывода матрицы на экран

    public static int determineMaxDischarge(int[][] array) {
        int maxDischarge = 0;
        String maxValueStr = "";
        String minValueStr = "";
        maxValueStr = String.valueOf(determineMaxValue(array));
        minValueStr = String.valueOf(determineMinValue (array));
        maxDischarge = (maxValueStr.length() > minValueStr.length()) ? maxValueStr.length() : minValueStr.length();
        return  maxDischarge;

    }

    public static int determineMaxValue(int[][] array) {
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array [i][j] > maxValue) {
                    maxValue = array [i][j];
                }
            }
        }
        return maxValue;
    }


    public static int determineMinValue(int[][] array) {
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array [i][j] < minValue) {
                    minValue = array [i][j];
                }
            }
        }
        return minValue;
    }
}
