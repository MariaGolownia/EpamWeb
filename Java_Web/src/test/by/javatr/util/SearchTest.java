package test.by.javatr.util;
import by.javatr.entity.Airline;
import by.javatr.entity.PassengerPlane;
import by.javatr.entity.Plane;
import by.javatr.entity.TransportPlane;
import by.javatr.util.Search;
import by.javatr.util.TagForSearch;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import static org.testng.Assert.*;

public class SearchTest {

    @Test
    public void testSearchByModelTag() {
        Airline airlineTest = Airline.getInstance();
        Plane planeTest1 = Plane.factory.getPlane(0, "B737-500", "not defined", 2019, "USA",
                "BOEING", 250, 20000,2600, 32820, 1000);
        PassengerPlane planeTest2 = PassengerPlane.factory.getPassengerPlane(1,  "B737_300","passenger", 2019, "USA",
                "BOEING", 150, 20000, 2600, 32820, 1000, 150, true, 20);
        TransportPlane planeTest3 = TransportPlane.factory.getTransportPlane(2, "E195AR", "transport",1998, "BRAZIL",
                "EMBRAER", 200, 38000,3300, 37000, 30200, 170, 1200);
        airlineTest.addPlane(planeTest1);
        airlineTest.addPlane(planeTest2);
        airlineTest.addPlane(planeTest3);
        List<Plane> rezListSearchByModel = new ArrayList<>();
        rezListSearchByModel = Search.searchByTag(airlineTest, new TagForSearch.ModelTagForSearch(), "B737_300");
        PassengerPlane planeTestResult = PassengerPlane.factory.getPassengerPlane(1,  "B737_300","passenger", 2019, "USA",
                "BOEING", 250, 20000, 2600, 32820, 1000, 150, true, 20);
        int expected = 0;
        int actual = rezListSearchByModel.get(0).compareTo(planeTestResult);
        assertEquals(expected, actual);
    }

    @Test
    public void testSearchByTagInRange() {
        Airline airlineTest = Airline.getInstance();
        Plane planeTest1 = Plane.factory.getPlane(0, "B737-500", "not defined", 2019, "USA",
                "BOEING", 250, 20000,2600, 32820, 1000);
        PassengerPlane planeTest2 = PassengerPlane.factory.getPassengerPlane(1,  "B737_300","passenger", 2019, "USA",
                "BOEING", 150, 20000, 2600, 32820, 1000, 150, true, 20);
        TransportPlane planeTest3 = TransportPlane.factory.getTransportPlane(2, "E195AR", "transport",1998, "BRAZIL",
                "EMBRAER", 200, 38000,3300, 37000, 30200, 170, 1200);
        airlineTest.addPlane(planeTest1);
        airlineTest.addPlane(planeTest2);
        airlineTest.addPlane(planeTest3);
        List<Plane> rezListSearchActual = new ArrayList<>();
        rezListSearchActual = Search.searchByTagInRange(airlineTest, new TagForSearch.SeatingCapacityTagForSearch(), "100", "230");
        List<Plane> rezListSearchExpected = new ArrayList<>();
        rezListSearchExpected.add(planeTest2);
        rezListSearchExpected.add(planeTest3);
        assertEquals(rezListSearchActual, rezListSearchExpected);
    }
}