package by.javatr.runner;
import by.javatr.entity.Text;
import by.javatr.reader.Reader;

public class Runner {

    public static void main(String[] args) {
        System.out.println("--------------------------------------------------------");
        System.out.println("Reading a text from file: ");
        System.out.println("--------------------------------------------------------");

        Text text = Reader.readTextFromFile("data.txt");
        System.out.println(text.toText());
        

    }
}
