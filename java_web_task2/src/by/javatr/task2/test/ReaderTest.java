package by.javatr.task2.test;
import by.javatr.task2.entity.Text;
import by.javatr.task2.reader.Reader;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

import static org.testng.Assert.*;

public class ReaderTest {
    private static Logger LOGGER = Logger.getLogger(ReaderTest.class);

    @Test
    public void testReadTextFromFile() {
        //String log4jConfPath = "log4j.properties";
        //PropertyConfigurator.configure(log4jConfPath);
        LOGGER.debug("Start testReadTextFromFile");
        String expected = "\t1 Two wrongs don't make a right. To check sorting: a aaa aaaaa aaaaaaa aaaaaaaaaaaa! Fortune favors the bold.\r\n" +
                "\t2 Birds of a feather flock together. Hope for the best, but prepare for the worst... A picture is worth a thousand words!\r\n" +
                "\t3 Discretion is the greater part of valour! Practice makes perfect! Necessity is the mother of invention.!\r\n" +
                "\t4 Actions speak louder than words! Good bye! Bye!";
        Text text = Reader.readTextFromFile("data.txt");
        String actual = text.toText();
        assertEquals(expected, actual);
    }
}