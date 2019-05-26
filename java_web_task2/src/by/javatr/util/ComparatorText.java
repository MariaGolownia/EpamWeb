package by.javatr.util;

import by.javatr.entity.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorText {

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
}
