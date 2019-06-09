package by.javatr.multithreading.service.entity;
import by.javatr.multithreading.service.util.Calculation;
import org.apache.log4j.Logger;

/**
 * A matrix is a mathematical object written in the form of a rectangular table of elements
 * of a ring or field, which is a set of rows and columns,
 * at the intersection of which its elements are located.
 **/

public class Matrix {
    private static Logger LOGGER = Logger.getLogger(Matrix.class);

    private static final int MAX_NUMBER_OF_ROWS_OR_COLUMNS = 12;
    private static final int MIN_NUMBER_OF_ROWS_OR_COLUMNS = 8;
    private static final int NUMBER_TO_INITIALIZE_EXCEPT_MAIN_DIAGONAL = 1;
    private static final int NUMBER_TO_INITIALIZE_MAIN_DIAGONAL = 0;
    private static final int MIN_NUMBER_FOR_RANDOM_INITIALIZATION_BY_DEFAULT = 0;
    private static final int MAX_NUMBER_FOR_RANDOM_INITIALIZATION_BY_DEFAULT = Integer.MAX_VALUE;
    private int[][] array;
    private int n;
    private int m;

    private Matrix () {}
    private static class MatrixHolder {
        private final static Matrix instance = new Matrix ();
    }

    public static Matrix getInstance () {
        LOGGER.debug("Start getInstance");
        return MatrixHolder.instance;
    }
    //--------------------------------------------------------------------------
    public void initializeMatrix(int[][] arr) {
        LOGGER.debug("Start initializeMatrix");
        try {
            n = arr.length;
            m = arr[0].length;
            if (n != m) {
                throw new MatrixException("\n" + "The number of rows of the matrix should be wounded by the number of columns!");
            }
            else if (n < MIN_NUMBER_OF_ROWS_OR_COLUMNS || n > MAX_NUMBER_OF_ROWS_OR_COLUMNS) {
                throw new MatrixException("\nAn integer matrix cannot be initialized with values less "
                        + MIN_NUMBER_OF_ROWS_OR_COLUMNS + " or more than " + MAX_NUMBER_OF_ROWS_OR_COLUMNS + "!\n"
                        + "Trying to create a matrix " + n + " x " + n + " is not successful!");
            }
            else {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (i == j && arr[i][j]!=NUMBER_TO_INITIALIZE_MAIN_DIAGONAL) {
                            throw new MatrixException("\nThe main diagonal of the matrix must be initialized with zeros!");
                        }
                    }
                }
            }
            this.array = arr;
        }
        catch (MatrixException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Матрица инициализируется единицами, главная диагональ - нулями
    public void initializeMatrix(int n) {
        LOGGER.debug("Start initializeMatrix");
        try {
            if (n < MIN_NUMBER_OF_ROWS_OR_COLUMNS || n > MAX_NUMBER_OF_ROWS_OR_COLUMNS) {
                throw new MatrixException("\nAn integer matrix cannot be initialized with values less "
                        + MIN_NUMBER_OF_ROWS_OR_COLUMNS + " or more than " + MAX_NUMBER_OF_ROWS_OR_COLUMNS + "!\n"
                        + "Trying to create a matrix " + n + " x " + n + " is not successful!");
            }
            else {
                this.array = new int[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        this.array[i][j] = (i == j) ? NUMBER_TO_INITIALIZE_MAIN_DIAGONAL : NUMBER_TO_INITIALIZE_EXCEPT_MAIN_DIAGONAL;
                    }
                }
            }
        }
        catch (MatrixException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Матрица инициализируется единицами, главная диагональ - нулями
    public void  initializeMatrix(int n, int m) {
        LOGGER.debug("Start initializeMatrix");
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

    // Матрица инициализируется заданным числом numberToInitialize, главная диагональ - нулями
    public void initializeMatrix(int n, int m, int numberToInitialize) {
        LOGGER.debug("Start initializeMatrix");
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

    // Если ifRandomInitialization == false:
// матрица инициализируется единицами, главная диагональ - нулями.
// Если ifRandomInitialization == true:
// матрица инициализируется рандомными значениями в пределах диапазона int, главная диагональ - нулями.
    public void initializeMatrix(int n, int m, boolean ifRandomInitialization) {
        LOGGER.debug("Start initializeMatrix");
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

    // Если ifRandomInitialization == false:
// матрица инициализируется единицами, главная диагональ - нулями.
// Если ifRandomInitialization == true:
// матрица инициализируется рандомными значениями в пределах заданного пользователем диапазона, главная диагональ - нулями.
    public void initializeMatrix(int n, int m, boolean ifRandomInitialization, int minR, int maxR) {
        LOGGER.debug("Start initializeMatrix");
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
                            array[i][j] = (i == j) ? NUMBER_TO_INITIALIZE_MAIN_DIAGONAL :
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

    public Matrix(int[][] array) {
        this.array = array;
    }



    public void show() {
        LOGGER.debug("Start show");
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

    public  int[][] getArray () {
        return this.array.clone();
    }


}
