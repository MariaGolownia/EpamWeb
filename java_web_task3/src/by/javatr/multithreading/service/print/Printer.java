package by.javatr.multithreading.service.print;

import org.apache.log4j.Logger;

import java.util.List;

public class Printer {
    private static Logger LOGGER = Logger.getLogger(Printer.class);

    public static <E> void printStream (List<E> array) {
        LOGGER.debug("Start printStream");
        System.out.println("\nStreams: ");
        for (E element : array) {
            System.out.print(element.toString() + " ");
        }
    }
}
