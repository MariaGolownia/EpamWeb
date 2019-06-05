package by.javatr.task2.test;

import by.javatr.task2.entity.Text;
import by.javatr.task2.reader.Reader;
import by.javatr.task2.util.Converter;
import by.javatr.task2.util.ComparatorText;
import by.javatr.task2.util.Sort;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class SortTest {
    private static Logger LOGGER = Logger.getLogger(ReaderTest.class);

    @Test
    public void testSortParagraphsBySentences() {
        LOGGER.debug("Start testSortParagraphsBySentences");
        String expected = "\t4 Actions speak louder than words!  Good bye!  Bye!\n" +
                "\t3 Discretion is the greater part of valour!  Practice makes perfect!  Necessity is the mother of invention!\n" +
                "\t1 Two wrongs don't make a right.  To check sorting: a aaa aaaaa aaaaaaa aaaaaaaaaaaa!  Fortune favors the bold.\n" +
                "\t2 Birds of a feather flock together.  Hope for the best, but prepare for the worst...  A picture is worth a thousand words!";
        Text text = Reader.readTextFromFile("data.txt");
        Sort sort = new Sort();
        List<String> paragraphListSort = new ArrayList<>();
        ComparatorText.ParagraphsBySentenceNumber comparatorText1 = new ComparatorText().new ParagraphsBySentenceNumber();
        paragraphListSort = sort.sortParagraphsBySentences(text.toText(), comparatorText1);
        String actual = Converter.convertArrayParToString(paragraphListSort);
        assertEquals(expected, actual);
    }

    @Test
    public void testSortWordsByLength() {
        LOGGER.debug("Start testSortWordsByLength");
        String expected = "\t1 a Two make don't wrongs right. a To aaa check aaaaa aaaaaaa sorting: aaaaaaaaaaaa! the bold. favors Fortune\n" +
                "\t2 a of Birds flock feather together. for the but for the Hope best, prepare worst... A a is worth words! picture thousand\n" +
                "\t3 is of the part greater valour! Discretion makes Practice perfect! is of the mother Necessity invention!\n" +
                "\t4 than speak louder words! Actions Good bye! Bye!";
        Text text = Reader.readTextFromFile("data.txt");
        Sort sort3 = new Sort();
        String actual = "";
        ComparatorText.WordsByLength comparatorText3 = new ComparatorText().new WordsByLength();
        actual = sort3.sortWordsByLength(text, comparatorText3);
        assertEquals(expected, actual);

    }

    @Test
    public void testSortSentencesBySymbolOccurrences() {
    }
}