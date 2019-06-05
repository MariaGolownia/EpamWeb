package by.javatr.task2.util;
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
                if (strList.get(i).trim()!="")
                    result += strList.get(i).trim() + " ";
            }
        }
        return result;
    }



    public static String convertArrayParToString (List<String> strList) {
        String result = "";
        for (int i = 0; i < strList.size(); i++) {
            if (strList.get(i).isEmpty() || strList.get(i).equals("")) {
                continue;
            }
            else {
                        result += "\t" + strList.get(i);
                        if (i!=strList.size()-1)
                            result+="\n";
            }
        }
        return result;
    }
}

