package by.javatr.runner;
import by.javatr.entity.Text;
import by.javatr.print.PrintToConsole;
import by.javatr.reader.Reader;
import by.javatr.util.ComparatorText;
import by.javatr.util.ParserText;
import by.javatr.util.Sort;

import java.util.*;

public class Runner {

    public static void main(String[] args) {
        System.out.println("--------------------------------------------------------");
        System.out.println("Reading a text from file: ");
        System.out.println("--------------------------------------------------------");
        Text text = Reader.readTextFromFile("data.txt");
        System.out.println(text.toText());

        System.out.println("--------------------------------------------------------");
        System.out.println("Check text reading 1: ");
        System.out.println("--------------------------------------------------------");
        ParserText parserText = new ParserText();
        List <String> listOfParagraphs = new ArrayList<>();
        listOfParagraphs = parserText.parseToParagraphs(text.toText());
        PrintToConsole.println(listOfParagraphs);

        System.out.println("--------------------------------------------------------");
        System.out.println("Sorting a text (String) from file by count of sentences in paragraphs: ");
        System.out.println("--------------------------------------------------------");
        Sort sort1 = new Sort();
        //Text textSort = new Text();
        List<String> paragraphListSort1 = new ArrayList<>();
        ComparatorText.ParagraphsBySentenceNumber comparatorText1 = new ComparatorText().new ParagraphsBySentenceNumber();
        paragraphListSort1 = sort1.sortParagraphsBySentences(text.toText(), comparatorText1);
        PrintToConsole.println(paragraphListSort1);

        System.out.println("--------------------------------------------------------");
        System.out.println("Sorting a text (Text) from file by count of sentences in paragraphs: ");
        System.out.println("--------------------------------------------------------");
        Sort sort2 = new Sort();
        List<String> paragraphListSort2 = new ArrayList<>();
        ComparatorText.ParagraphsBySentenceNumber comparatorText2 = new ComparatorText().new ParagraphsBySentenceNumber();
        paragraphListSort2 = sort2.sortParagraphsBySentences(text.toText(), comparatorText2);
        PrintToConsole.println(paragraphListSort2);

        System.out.println("--------------------------------------------------------");
        System.out.println("Sorting a text (Text) from file by words: ");
        System.out.println("--------------------------------------------------------");
        Sort sort3 = new Sort();
        List<String> wordsListSort = new ArrayList<>();
        ComparatorText.WordsByLength comparatorText3 = new ComparatorText().new WordsByLength();
        wordsListSort = sort3.sortWordsByLength(text, comparatorText3);
        PrintToConsole.println(wordsListSort);
    }
}
