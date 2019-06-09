package by.javatr.multithreading.view;
import by.javatr.multithreading.controller.Controller;
import by.javatr.multithreading.service.entity.Matrix;
import by.javatr.multithreading.service.entity.ThreadStream;
import by.javatr.multithreading.service.print.Printer;
import by.javatr.multithreading.dal.reader.ReaderFromFile;
import by.javatr.multithreading.dal.creator.Creator;
import org.apache.log4j.Logger;
import java.util.List;

/**
 * Dialog is designed to communicate with the user
 * **/

public class Dialog {
    private static Logger LOGGER = Logger.getLogger(Dialog.class);
    private String nameOfUser;
    private String password;
    private Matrix matrix;
    private List<Integer> streams;

    public Dialog(String nameOfUser, String password) {
        Controller controller = new Controller();
        Boolean ifLoginIsAllowed = controller.checkUserCredentials(nameOfUser, password);
        if (ifLoginIsAllowed) {
        this.nameOfUser = nameOfUser;
        this.password = password; }
    }

    public void readMatrixFromFile (String nameOfFile) {
        LOGGER.debug("Start readMatrixFromFile");
        List<String> resultMatrixFromFile = ReaderFromFile.readFromFile(nameOfFile);
        int[][] array;
        array = Creator.createArray(resultMatrixFromFile);
        this.matrix = Matrix.getInstance();
        matrix.initializeMatrix(array);
    }

    public void showMatrix () {
        LOGGER.debug("Start showMatrix");
        this.matrix.show();
    }

    public void  readAndShowMatrixFromFile (String nameOfFile) {
        LOGGER.debug("Start readAndShowMatrixFromFile");
        readMatrixFromFile(nameOfFile);
        this.matrix.show();
    }

    public void readStreamsFromFile (String nameOfFile) {
        LOGGER.debug("Start readStreamsFromFile");
        List<String> resultStreamsFromFile = ReaderFromFile.readFromFile("stream.txt");
        this.streams = Creator.createFlow(resultStreamsFromFile);
    }

    public void readAndShowStreamsFromFile (String nameOfFile) {
        LOGGER.debug("Start readAndShowStreamsFromFile");
        readStreamsFromFile(nameOfFile);
        Printer.printStream(this.streams);
    }

    public Matrix getMatrix() {
        LOGGER.debug("Start getMatrix");
        return matrix;
    }

    public List<Integer> getStreamsFromFile() {
        LOGGER.debug("Start getStreamsFromFile");
        return streams;
    }

    public void startStreamsAction () {
        LOGGER.debug("Start startStreamsAction");
        ThreadStream threadStream = new ThreadStream(this.matrix, this.streams);
        threadStream.threadStart();
        threadStream.threadJoin();
    }
}
