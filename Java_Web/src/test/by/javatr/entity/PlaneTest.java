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
        LOGGER.info("Info:");
        LOGGER.debug("Start testCompareTo");
        Plane plane1 = Plane.factory.getPlane(0, "B737-300", "not defined", 2019, "USA",
                "BOEING", 250, 20000,2600, 32820, 1000);
        Plane plane2 = Plane.factory.getPlane(0, "B737-300", "not defined", 2019, "USA",
                "BOEING", 250, 20000,2600, 32820, 1000);
        int expected = 0;
        int actual = plane1.compareTo(plane2);
        assertEquals(expected, actual);
    }

    @Test
    // Сравнение самолетов без принятия участия ID в сравнении)
    public void getPlaneTest() {
        Plane plane1 = PlaneCreator.createPlane(Plane.factory);
        Plane plane2 = Plane.factory.getPlane(2, "No set", "not defined", 2019, "USA", "No set", 2, 100,100, 100, 1);
        int expected = 0;
        int actual = plane1.compareTo(plane2);
        assertEquals(expected, actual);
    }

    @Test
    // Создание Plane с параметрами(через Factory)
    public void getPlaneTestWithParametersAndWithout() {
        Plane plane1 = Plane.factory.getPlane(0, "B737-300", "passenger",
                2019, "USA", "BOEING", 250,
                20000,2600, 32820, 1000);
        Plane plane2 = PlaneCreator.createPlane(Plane.factory);
        plane2.setModelOfPlane("B737-300");
        plane2.setTypeOfPlane("passenger");
        plane2.setYearOfProduction(2019);
        plane2.setProducingCountry("USA");
        plane2.setManufacturingCompany("BOEING");
        plane2.setSeatingCapacityUnit(250);
        plane2.setCarryingCapacityKilo(20000);
        plane2.setFuelConsumptionKiloPerHour(2600);
        plane2.setEmptyWeightKilo(32820);
        plane2.setHoursOfFlightsHours(1000);
        int expected = 0;
        int actual = plane1.compareTo(plane2);
        assertEquals(expected, actual);
    }
}

