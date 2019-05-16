package by.javatr.runner;
import by.javatr.entity.*;
import by.javatr.print.PrintToConsole;
import by.javatr.reader.ReaderAirlineFromFile;
import by.javatr.util.ComparatorPlaneForSort;
import by.javatr.util.Sort;
import by.javatr.util.TagForSearch;
import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        // Создание Plane без параметров(через Factory)
        PrintToConsole.println("\n--------------------------------------------------------------------------------");
        PrintToConsole.println("Создание Plane без параметров(через factory)");
        PrintToConsole.println("--------------------------------------------------------------------------------");
        Plane plane1 = PlaneCreator.createPlane(Plane.factory);
        System.out.println(plane1.toString());

        // Создание Plane с параметрами(через Factory)
        PrintToConsole.println("\n--------------------------------------------------------------------------------");
        PrintToConsole.print("Создание Plane с параметрами(через factory)");
        PrintToConsole.println("--------------------------------------------------------------------------------");
        Plane plane2 = Plane.factory.getPlane(0, "B737-300", "not defined", 2019, "USA",
                "BOEING", 250, 20000,2600, 32820, 1000);
        System.out.println(plane2.toString());

        // Создание PassengerPlane с параметрами(через Factory)
        PrintToConsole.println("\n--------------------------------------------------------------------------------");
        PrintToConsole.print("Создание PassengerPlane с параметрами(через factory)");
        PrintToConsole.println("--------------------------------------------------------------------------------");
        PassengerPlane plane3 = PassengerPlane.factory.getPassengerPlane(1,  "B737_300","passenger", 2019, "USA",
                "BOEING", 250, 20000, 2600, 32820, 1000, 150, true, 20);
        System.out.println(plane3.toString());

        // Создание TransportPlane с параметрами(через Factory)
        PrintToConsole.println("\n--------------------------------------------------------------------------------");
        PrintToConsole.print("Создание TransportPlane с параметрами(через factory)");
        PrintToConsole.println("--------------------------------------------------------------------------------");
        TransportPlane plane4 = TransportPlane.factory.getTransportPlane(2, "E195AR", "transport",1998, "BRAZIL",
                "EMBRAER", 200, 38000,3300, 37000, 30200, 170, 1200);
        System.out.println(plane4.toString());

        // Создание авиакомпании и осуществление добавления в нее самолетов
        PrintToConsole.println("\n--------------------------------------------------------------------------------");
        PrintToConsole.println("Создание авиакомпании и осуществление добавления в нее самолетов. Вывод на консоль всех самолетов созданной авиакомпании");
        PrintToConsole.println("--------------------------------------------------------------------------------");
        Airline airline1 = Airline.getInstance();
        airline1.addPlane(plane1);
        airline1.addPlane(plane2);
        airline1.addPlane(plane3);
        airline1.addPlane(plane4);
        PrintToConsole.print(airline1.toString());

        // Поиск по тегу
        PrintToConsole.println("\n--------------------------------------------------------------------------------");
        PrintToConsole.println("Поиск по модели (B737_300)");
        PrintToConsole.println("--------------------------------------------------------------------------------");
        List<Plane> rezListSearchByModel = new ArrayList<>();
        rezListSearchByModel = airline1.searchByTag(new TagForSearch.ModelTagForSearch(), "B737_300");
        PrintToConsole.print(rezListSearchByModel);

        // Поиск по тегу
        PrintToConsole.println("--------------------------------------------------------------------------------");
        PrintToConsole.println("\n Поиск по году (1998)");
        PrintToConsole.println("--------------------------------------------------------------------------------");
        List<Plane> rezListSearchByYear = new ArrayList<>();
        rezListSearchByYear = airline1.searchByTag(new TagForSearch.YearTagForSearch(), "1998");
        PrintToConsole.println(rezListSearchByYear);

        // Проверка чтения из файла
        PrintToConsole.println("\n--------------------------------------------------------------------------------");
        PrintToConsole.println("Проверка чтения из файла");
        PrintToConsole.println("--------------------------------------------------------------------------------");
        // Так как использовали SingleTone - не смотря на изменение переменной авиакомпании, компания продолжает работать
        // с одной компанией
        Airline airline2 = Airline.getInstance();
        airline2 = ReaderAirlineFromFile.readPlanesFromFile("data.txt");
        PrintToConsole.println(airline2.toString());

        // Проверка Сортировки из файла
        PrintToConsole.println("\n--------------------------------------------------------------------------------");
        PrintToConsole.println("Проверка сортировки из файла по модели");
        PrintToConsole.println("--------------------------------------------------------------------------------");
        List<Plane> rezListSort = Sort.sort(airline2, new ComparatorPlaneForSort.byModelComparator());
        PrintToConsole.print(rezListSort.toString());

    }
}
