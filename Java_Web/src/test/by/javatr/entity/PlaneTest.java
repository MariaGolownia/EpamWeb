package test.by.javatr.entity;

import by.javatr.entity.Plane;
import by.javatr.entity.PlaneCreator;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PlaneTest {
    private static Logger LOGGER = Logger.getLogger(PlaneTest.class);

    @Test
    public void testCompareTo() {
        LOGGER.debug("hi");
        LOGGER.info("hi-info");
        Plane plane1 = PlaneCreator.createPlane(Plane.factory, "B737-300", "passenger", 2019, "USA",
                "BOEING", 250, 20000, 2600, 32820, 1000);
        Plane plane2 = PlaneCreator.createPlane(Plane.factory, "B737-300", "passenger", 2019, "USA",
                "BOEING", 250, 20000, 2600, 32820, 1000);
        int expected = 0;
        int actual = plane1.compareTo(plane2);
        assertEquals(expected, actual);

    }
}