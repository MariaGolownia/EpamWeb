package by.javatr.multithreading.entity;
import by.javatr.multithreading.util.Calculation;

public class Matrix {
    private static final int MAX_NUMBER_OF_ROWS_OR_COLUMNS = 12;
    private static final int MIN_NUMBER_OF_ROWS_OR_COLUMNS = 8;
    private static final int NUMBER_TO_INITIALIZE_EXCEPT_MAIN_DIAGONAL = 1;
    private static final int NUMBER_TO_INITIALIZE_MAIN_DIAGONAL = 0;
    private static final int MIN_NUMBER_FOR_RANDOM_INITIALIZATION_BY_DEFAULT = 0;
    private static final int MAX_NUMBER_FOR_RANDOM_INITIALIZATION_BY_DEFAULT = Integer.MAX_VALUE;
    private int[][] array;
    private int n;
    private int m;
    private boolean ifRandomInitialization;

// Конструктор: создание и заполнение матрицы
// Матрица инициализируется единицами, главная диагональ - нулями
    public Matrix(int n) {
        try {
            if (n < MIN_NUMBER_OF_ROWS_OR_COLUMNS || n > MAX_NUMBER_OF_ROWS_OR_COLUMNS) {
                throw new MatrixException("\nAn integer matrix cannot be initialized with values less "
                        + MIN_NUMBER_OF_ROWS_OR_COLUMNS + " or more than " + MAX_NUMBER_OF_ROWS_OR_COLUMNS + "!\n"
                + "Trying to create a matrix " + n + " x " + n + " is not successful!");
            }
            else {
                array = new int[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        array[i][j] = (i == j) ? NUMBER_TO_INITIALIZE_MAIN_DIAGONAL : NUMBER_TO_INITIALIZE_EXCEPT_MAIN_DIAGONAL;
                    }
                }
            }
        }
        catch (MatrixException ex) {
            System.out.println(ex.getMessage());
        }
    }

// Конструктор: создание и заполнение матрицы
// Матрица инициализируется единицами, главная диагональ - нулями
    public Matrix(int n, int m) {
        try {
            if (n < MIN_NUMBER_OF_ROWS_OR_COLUMNS || n > MAX_NUMBER_OF_ROWS_OR_COLUMNS) {
                throw new MatrixException("\nAn integer matrix cannot be initialized with values less "
                        + MIN_NUMBER_OF_ROWS_OR_COLUMNS + " or more than " + MAX_NUMBER_OF_ROWS_OR_COLUMNS + "!\n"
                        + "Trying to create a matrix " + n + " x " + m + " is not successful!");
            }
            else if (n != m) {
                throw new MatrixException("\nThe number of rows in an integer matrix must be equal to the number of columns!" + "\n"
                        + "Trying to create a matrix " + n + " x " + n + " is not successful!");
            }
            else {
                array = new int[n][m];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        array[i][j] = (i == j) ? NUMBER_TO_INITIALIZE_MAIN_DIAGONAL : NUMBER_TO_INITIALIZE_EXCEPT_MAIN_DIAGONAL;
                    }
                }
            }
        }
        catch (MatrixException ex) {
            System.out.println(ex.getMessage());
        }
    }

// Конструктор: создание и заполнение матрицы
// Матрица инициализируется аданным числом numberToInitialize, главная диагональ - нулями
    public Matrix(int nn, int mm, int numberToInitialize) {
        try {
            if (n < MIN_NUMBER_OF_ROWS_OR_COLUMNS || n > MAX_NUMBER_OF_ROWS_OR_COLUMNS) {
                throw new MatrixException("\nAn integer matrix cannot be initialized with values less "
                        + MIN_NUMBER_OF_ROWS_OR_COLUMNS + " or more than " + MAX_NUMBER_OF_ROWS_OR_COLUMNS + "!\n"
                        + "Trying to create a matrix " + n + " x " + m + " is not successful!");
            }
            else if (n != m) {
                throw new MatrixException("\nThe number of rows in an integer matrix must be equal to the number of columns!"+ "\n"
                        + "Trying to create a matrix " + n + " x " + n + " is not successful!");
            }
            else {
                n = nn;
                m = mm;
                array = new int[n][m];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        array[i][j] = (i == j) ? NUMBER_TO_INITIALIZE_MAIN_DIAGONAL : numberToInitialize;
                    }
                }
            }
        }
        catch (MatrixException ex) {
            System.out.println(ex.getMessage());
        }
    }
// Конструктор: создание и заполнение матрицы
// Если ifRandomInitialization == false:
// матрица инициализируется единицами, главная диагональ - нулями.
// Если ifRandomInitialization == true:
// матрица инициализируется рандомными значениями в пределах диапазона int, главная диагональ - нулями.
    public Matrix(int n, int m, boolean ifRandomInitialization) {
        try {
            if (n < MIN_NUMBER_OF_ROWS_OR_COLUMNS || n > MAX_NUMBER_OF_ROWS_OR_COLUMNS) {
                throw new MatrixException("\nAn integer matrix cannot be initialized with values less "
                        + MIN_NUMBER_OF_ROWS_OR_COLUMNS + " or more than " + MAX_NUMBER_OF_ROWS_OR_COLUMNS + "!\n"
                        + "Trying to create a matrix " + n + " x " + m + " is not successful!");
            }
            else if (n != m) {
                throw new MatrixException("\nThe number of rows in an integer matrix must be equal to the number of columns!" + "\n"
                        + "Trying to create a matrix " + n + " x " + n + " is not successful!");
            }
            else {
                array = new int[n][m];
                if (ifRandomInitialization==false) {
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            array[i][j] = (i == j) ? NUMBER_TO_INITIALIZE_MAIN_DIAGONAL : NUMBER_TO_INITIALIZE_EXCEPT_MAIN_DIAGONAL;
                        }
                    }
                }
                else {
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            array[i][j] = (i == j) ?
                                    NUMBER_TO_INITIALIZE_MAIN_DIAGONAL :
                                    (int)(Math.random()*(MAX_NUMBER_FOR_RANDOM_INITIALIZATION_BY_DEFAULT-MIN_NUMBER_FOR_RANDOM_INITIALIZATION_BY_DEFAULT))+MIN_NUMBER_FOR_RANDOM_INITIALIZATION_BY_DEFAULT + 1;
                        }
                    }
                }
            }
        }
        catch (MatrixException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Конструктор: создание и заполнение матрицы
// Если ifRandomInitialization == false:
// матрица инициализируется единицами, главная диагональ - нулями.
// Если ifRandomInitialization == true:
// матрица инициализируется рандомными значениями в пределах заданного пользователем диапазона, главная диагональ - нулями.
    public Matrix(int n, int m, boolean ifRandomInitialization, int minR, int maxR) {
        try {
            if (n < MIN_NUMBER_OF_ROWS_OR_COLUMNS || n > MAX_NUMBER_OF_ROWS_OR_COLUMNS) {
                throw new MatrixException("\nAn integer matrix cannot be initialized with values less "
                        + MIN_NUMBER_OF_ROWS_OR_COLUMNS + " or more than " + MAX_NUMBER_OF_ROWS_OR_COLUMNS + "!\n"
                        + "Trying to create a matrix " + n + " x " + m + " is not successful!");
            }
            else if (n != m) {
                throw new MatrixException("\nThe number of rows in an integer matrix must be equal to the number of columns!" + "\n"
                        + "Trying to create a matrix " + n + " x " + n + " is not successful!");
            }
            else {
                array = new int[n][m];
                if (ifRandomInitialization==false) {
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            array[i][j] = (i == j) ? NUMBER_TO_INITIALIZE_MAIN_DIAGONAL : NUMBER_TO_INITIALIZE_EXCEPT_MAIN_DIAGONAL;
                        }
                    }
                }
                else {
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            array[i][j] = (i == j) ? NUMBER_TO_INITIALIZE_EXCEPT_MAIN_DIAGONAL :
                                    (int)(Math.random()*(maxR - minR)+ minR + 1);
                        }
                    }
                }
            }
        }
        catch (MatrixException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void show() {
        try {
            if (array == null) {
                throw new MatrixException("The matrix is not correctly initialized!");
            }
            System.out.println("\nMatrix: " + array.length + " x " + array[0].length);
            int maxDischarge = Calculation.determineMaxDischarge(this.array);
            String strToPrintf = "%" + (maxDischarge + 1) + "d";
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                    System.out.printf(strToPrintf, array[i][j]);
                }
                System.out.println();

            }
        }
        catch (MatrixException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
