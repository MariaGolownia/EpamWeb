package by.javatr.util;
import by.javatr.entity.Paragraph;
import org.apache.log4j.Logger;

import java.util.List;

public class Converter {
    private static Logger LOGGER = Logger.getLogger(Converter.class);

        public static String convertArrayStrToString (List<String> strList) {
            String result = "";
            for (int i = 0; i < strList.size(); i++) {
                if (strList.get(i).isEmpty() || strList.get(i).equals("")) {
                    continue;
                }
                else {
                    result += strList.get(i).trim() + " ";
                }
            }
            return result;
        }
    }

