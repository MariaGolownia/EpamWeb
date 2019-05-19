package by.javatr.runner;

import by.javatr.entity.Composite;
import by.javatr.entity.Text;
import by.javatr.exc.ReaderException;
import by.javatr.reader.Reader;

import java.io.IOException;

public class Runner {

    public static void main(String[] args) {
    System.out.println("--------------------------------------------------------");
    System.out.println("Reading a text from file: ");
    System.out.println("--------------------------------------------------------");
        try {
            Text text = Reader.readTextFromFile("data.txt");
            System.out.println(text.print());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ReaderException e) {
            e.printStackTrace();
        }

    }
}
