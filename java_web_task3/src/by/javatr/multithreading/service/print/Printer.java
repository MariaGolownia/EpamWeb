package by.javatr.multithreading.service.print;

import java.util.List;

public class Printer {

    public static <E> void printStream (List<E> array) {
        System.out.println("\nStreams: ");
        for (E element : array) {
            System.out.print(element.toString() + " ");
        }
    }
}
