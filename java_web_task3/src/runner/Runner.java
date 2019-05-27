package runner;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class Runner {

    public static void main(String[] args) {

            System.out.println("1 — английский /n 2 — белорусский \n любой — русский ");
            char i = 0;
            try {
                i = (char) System.in.read();

            } catch (IOException e) {
                e.printStackTrace();
            }
            String country = "";
            String language = "";
            switch (i) {
                case '1':
                    country = "En";
                    language = "en";
                    break;
                case '2':
                    country = "By";
                    language = "by";
                    break;
            }
            Locale current = new Locale(language, country);
            ResourceBundle rb = ResourceBundle.getBundle("Lang", current);
            String s1 = rb.getString("str");
            System.out.println(s1);
            //String s2 = rb.getString("str2");
            //System.out.println(s2);

    }

}
