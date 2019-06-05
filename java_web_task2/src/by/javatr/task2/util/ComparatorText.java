package by.javatr.task2.util;

import by.javatr.entity.*;
import org.apache.log4j.Logger;

import java.util.Comparator;

public class ComparatorText {
    private static Logger LOGGER = Logger.getLogger(ComparatorText.class);

    public class ParagraphsBySentenceNumber implements Comparator<String> {

        @Override
        public int compare(String paragraph1, String paragraph2) {
            return paragraph1.length() - paragraph2.length();
        }

//        @Override
//        public int compare(Paragraph paragraph1, Paragraph paragraph2) {
//            return paragraph1.getList().size() - paragraph2.getList().size();
//        }
    }

    public class WordsByLength implements Comparator<String> {

        @Override
        public int compare(String word1, String word2) {
            return word1.length() - word2.length();
        }

//        @Override
//        public int compare(Lexeme lexeme1, Lexeme lexeme2) {
//            return lexeme1.getList().size() - lexeme2.getList().size();
//        }
    }


    public class SentencesBySymbolOccurrences implements  Comparator<String>{
        private Character ch;

        public SentencesBySymbolOccurrences (Character ch) {
            this.ch = ch;
        }

        public int compare(String sentence1, String sentence2) {
            int count1 = 0; // количество вхождений в первое предложение
            int count2 = 0; // количество вхождений во второе предложение
            char[] charArraysentence1 =sentence1.toCharArray();
            char[] charArraysentence2 =sentence2.toCharArray();

            for (int i = 0; i < charArraysentence1.length; i++) {
                if (charArraysentence1[i] == this.ch) {
                        count1++;
                }
                for (int j = 0; j < charArraysentence2.length; j++) {
                    if (charArraysentence2[j] == this.ch) {
                        count2++;
                    }
                }
            }
            return count2 - count1;
        }
    }
}
