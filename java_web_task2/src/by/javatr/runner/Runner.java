package by.javatr.runner;
import by.javatr.entity.Text;
import by.javatr.print.PrintToConsole;
import by.javatr.reader.Reader;
import by.javatr.util.ComparatorText;
import by.javatr.util.Converter;
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
        PrintToConsole.println(Converter.convertArrayParToString(listOfParagraphs));

        System.out.println("--------------------------------------------------------");
        System.out.println("Sorting a text (String) by count of sentences in paragraphs: ");
        System.out.println("--------------------------------------------------------");
        Sort sort1 = new Sort();
        //Text textSort = new Text();
        List<String> paragraphListSort1 = new ArrayList<>();
        ComparatorText.ParagraphsBySentenceNumber comparatorText1 = new ComparatorText().new ParagraphsBySentenceNumber();
        paragraphListSort1 = sort1.sortParagraphsBySentences(text.toText(), comparatorText1);
        PrintToConsole.println(Converter.convertArrayParToString(paragraphListSort1));

        System.out.println("--------------------------------------------------------");
        System.out.println("Sorting a text (Text) by count of sentences in paragraphs: ");
        System.out.println("--------------------------------------------------------");
        Sort sort2 = new Sort();
        List<String> paragraphListSort2 = new ArrayList<>();
        ComparatorText.ParagraphsBySentenceNumber comparatorText2 = new ComparatorText().new ParagraphsBySentenceNumber();
        paragraphListSort2 = sort2.sortParagraphsBySentences(text.toText(), comparatorText2);
        PrintToConsole.println(Converter.convertArrayParToString(paragraphListSort2));

        System.out.println("--------------------------------------------------------");
        System.out.println("Sorting a text (Text) by words: ");
        System.out.println("--------------------------------------------------------");
        Sort sort3 = new Sort();
        String wordsListSort1 = "";
        ComparatorText.WordsByLength comparatorText3 = new ComparatorText().new WordsByLength();
        wordsListSort1 = sort3.sortWordsByLength(text, comparatorText3);
        PrintToConsole.println(wordsListSort1);


        System.out.println("--------------------------------------------------------");
        System.out.println("Sorting a text (String) by words: ");
        System.out.println("--------------------------------------------------------");
        Sort sort4 = new Sort();
        String wordsListSort2 = "";
        ComparatorText.WordsByLength comparatorText4 = new ComparatorText().new WordsByLength();
        wordsListSort2 = sort3.sortWordsByLength(text.toText(), comparatorText4);
        PrintToConsole.println(wordsListSort2);

        System.out.println("--------------------------------------------------------");
        System.out.println("Sorting sentences in paragraps by symbol occurrences: ");
        System.out.println("--------------------------------------------------------");
        Sort sort5 = new Sort();
        String sentenceInParagrapsListSort = "";
        Character markCharacter = 'a';
        ComparatorText.SentencesBySymbolOccurrences comparatorText5 = new ComparatorText().new SentencesBySymbolOccurrences(markCharacter);
        sentenceInParagrapsListSort = sort5.sortSentencesBySymbolOccurrences(text.toText(), comparatorText5);
        PrintToConsole.println(sentenceInParagrapsListSort);

    }
}
