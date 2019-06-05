package by.javatr.task2.util;
import by.javatr.entity.*;
import by.javatr.task2.entity.Text;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class Sort  {

    private static Logger LOGGER = Logger.getLogger(Sort.class);

     public List<String> sortParagraphsBySentences(Text text, Comparator comparatorC){
        ParserText parserText = new ParserText();
        List<String> paragraphList = parserText.parseToParagraphs(text.toText());
        List<String> paragraphListSort = new ArrayList<>();
        for (int i = 0; i < paragraphList.size(); i++) {
            paragraphListSort.add(paragraphList.get(i));
        }
        paragraphListSort.sort(comparatorC);
        return paragraphListSort;
    }

    // Перегрузка метода sortParagraphsBySentences
    public List<String> sortParagraphsBySentences(String text, Comparator comparatorC){
        ParserText parserText = new ParserText();
        List<String> paragraphList = parserText.parseToParagraphs(text);
        List<String> paragraphListSort = new ArrayList<>();
        for (int i = 0; i < paragraphList.size(); i++) {
            paragraphListSort.add(paragraphList.get(i));
        }
        paragraphListSort.sort(comparatorC);
        return paragraphListSort;
    }


    public String sortWordsByLength (Text text, Comparator comparatorC){
        ParserText parserText = new ParserText();
        String result = "\t";
        // работа с параграфами
        List<String> paragraphList = parserText.parseToParagraphs(text.toText());
        for (int i = 0; i < paragraphList.size(); i++) {
            List<String> wordsListSort = new ArrayList<>();
            List<String> sentencesList = parserText.parseToSentences(paragraphList.get(i));
            for (int j = 0; j < sentencesList.size(); j++) {
                wordsListSort = Arrays.asList(sentencesList.get(j).split(" "));
                wordsListSort.sort(comparatorC);
                result += Converter.convertArrayStrToString(wordsListSort);
            }
            result = result.substring(0, result.length()-1);
            if (i != paragraphList.size()-1)
                result += "\n\t";

        }
        return result;
    }

    // Перегрузка метода sortWordsByLength
    public String sortWordsByLength (String text, Comparator comparatorC){
        ParserText parserText = new ParserText();
        String result = "\t";
        // работа с параграфами
        List<String> paragraphList = parserText.parseToParagraphs(text);
        for (int i = 0; i < paragraphList.size(); i++) {
            List<String> wordsListSort = new ArrayList<>();
            List<String> sentencesList = parserText.parseToSentences(paragraphList.get(i));
            for (int j = 0; j < sentencesList.size(); j++) {
                wordsListSort = Arrays.asList(sentencesList.get(j).split(" "));
                wordsListSort.sort(comparatorC);
                result += Converter.convertArrayStrToString(wordsListSort);
            }
            result = result.substring(0, result.length()-1);
            if (i != paragraphList.size()-1)
                result += "\n\t";

        }
        return result;
    }


    public String sortSentencesBySymbolOccurrences  (Text text, Comparator comparatorC) {
        ParserText parserText = new ParserText();
        String result = "";
        // работа с параграфами
        List<String> paragraphList = parserText.parseToParagraphs(text.toString());
        for (int i = 0; i < paragraphList.size(); i++) {
            List<String> wordsListSort = new ArrayList<>();
            List<String> sentencesList = parserText.parseToSentences(paragraphList.get(i));
            sentencesList.sort(comparatorC);
            result +=  Converter.convertArrayStrToString(sentencesList) + "\n";
        }

        return result;
    }

    public String sortSentencesBySymbolOccurrences  (String text, Comparator comparatorC) {
        ParserText parserText = new ParserText();
        String result = "\t";
        // работа с параграфами
        List<String> paragraphList = parserText.parseToParagraphs(text);
        for (int i = 0; i < paragraphList.size(); i++) {
            List<String> wordsListSort = new ArrayList<>();
            List<String> sentencesList = parserText.parseToSentences(paragraphList.get(i));
            sentencesList.sort(comparatorC);
            result +=  Converter.convertArrayStrToString(sentencesList) + "\n\t";
        }
        return result;
    }

}
