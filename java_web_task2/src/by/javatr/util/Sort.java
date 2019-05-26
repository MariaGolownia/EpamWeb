package by.javatr.util;
import by.javatr.entity.*;
import by.javatr.entity.Component;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class Sort  {

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

    public List<String> sortWordsByLength (Text text, Comparator comparatorC){
        ParserText parserText = new ParserText();
        List<String> sentencesList = parserText.parseToSentences(text.toText());
        String sentence = "";
        List<String> result = new ArrayList<>();
        for (int i = 0; i < sentencesList.size(); i++) {
            List<String> wordsListSort = Arrays.asList(sentencesList.get(i).split(" "));
            wordsListSort.sort(comparatorC);
            for (int j = 0; j < sentencesList.size(); j++) {
                sentencesList.set(i, wordsListSort.toString());
            }
        }
        return sentencesList;
    }

}
