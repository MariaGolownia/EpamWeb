package by.javatr.util;

import by.javatr.entity.Plane;

public interface AbstractTagForSearch {

    public boolean ifContainsTag(Plane plane, String tag);
    public boolean ifContainsTag(Plane plane, String tag1, String tag2);

}
