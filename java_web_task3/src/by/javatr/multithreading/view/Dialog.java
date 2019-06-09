package by.javatr.multithreading.view;
import by.javatr.multithreading.controller.Controller;
import by.javatr.multithreading.service.entity.Matrix;
import by.javatr.multithreading.service.print.Printer;
import by.javatr.multithreading.dal.reader.ReaderFromFile;
import by.javatr.multithreading.dal.creator.Creator;
import java.util.List;

/**
 * Dialog is designed to communicate with the user
 * **/

public class Dialog {
    private String nameOfUser;
    private String password;
    private Matrix matrix;
    private List<Integer> streamsFromFile;

    public Dialog(String nameOfUser, String password) {
        Controller controller = new Controller();
        Boolean ifLoginIsAllowed = controller.checkUserCredentials(nameOfUser, password);
        if (ifLoginIsAllowed) {
        this.nameOfUser = nameOfUser;
        this.password = password; }
    }

    public void readMatrixFromFile (String nameOfFile) {
        List<String> resultMatrixFromFile = ReaderFromFile.readFromFile(nameOfFile);
        int[][] array;
        array = Creator.createArray(resultMatrixFromFile);
        this.matrix = Matrix.getInstance();
        matrix.initializeMatrix(array);

    }

    public void  readAndShowMatrixFromFile (String nameOfFile) {
        readMatrixFromFile(nameOfFile);
        this.matrix.show();
    }

    public void readStreamsFromFile (String nameOfFile) {
        List<String> resultStreamsFromFile = ReaderFromFile.readFromFile("stream.txt");
        this.streamsFromFile = Creator.createFlow(resultStreamsFromFile);
    }

    public void readAndShowStreamsFromFile (String nameOfFile) {
        readStreamsFromFile(nameOfFile);
        Printer.printStream(this.streamsFromFile);
    }
}
