package by.javatr.runner;
import by.javatr.entity.*;
import by.javatr.print.PrintToConsole;
import by.javatr.util.TagForSearch;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        // Создание Plane без параметров(через Factory)
        PrintToConsole.print("Создание Plane без параметров(через Factory)");
        Plane plane1 = PlaneCreator.createPlane(Plane.factory);
        System.out.println(plane1.toString());

        // Создание Plane с параметрами(через Factory)
        PrintToConsole.print("Создание Plane с параметрами(через Factory)");
        Plane plane2 = PlaneCreator.createPlane(Plane.factory, "B737-300", "not defined", 2019, "USA",
               "BOEING", 250, 20000,2600, 32820, 1000);
        System.out.println(plane2.toString());

        // Создание PassengerPlane с параметрами(через Factory)
        PrintToConsole.print("Создание PassengerPlane с параметрами(через Factory)");
        PassengerPlane plane3 = PlaneCreator.createPlane(PassengerPlane.factory,  "B737_300","passenger", 2019, "USA",
                "BOEING", 250, 20000, 2600, 32820, 1000, 150, true, 20);
        System.out.println(plane3.toString());

        // Создание TransportPlane с параметрами(через Factory)
        TransportPlane plane4 = PlaneCreator.createPlane(TransportPlane.factory, "E195AR", "transport",1998, "BRAZIL",
                "EMBRAER", 200, 38000,3300, 37000, 30200, 170, 1200);
        System.out.println(plane4.toString());

        // Создание авиакомпании и осуществление добавления в нее самолетов
        PrintToConsole.print("Создание авиакомпании и осуществление добавления в нее самолетов. Вывод на консоль всех самолетов созданной авиакомпании");
        Airline airline1 = new Airline();
        airline1.addPlane(plane1);
        airline1.addPlane(plane2);
        airline1.addPlane(plane3);
        airline1.addPlane(plane4);
        PrintToConsole.print(airline1.toString());

        // Поиск по тегу
        PrintToConsole.print("Поиск по модели (B737_300)");
        List<Plane> rezListSearchByModel = new ArrayList<>();
        rezListSearchByModel = airline1.searchByTag(new TagForSearch.ModelTagForSearch(), "B737_300");
        PrintToConsole.print(rezListSearchByModel);

        // Поиск по тегу
        PrintToConsole.print("Поиск по году (1998)");
        List<Plane> rezListSearchByYear = new ArrayList<>();
        rezListSearchByYear = airline1.searchByTag(new TagForSearch.YearTagForSearch(), "1998");
        PrintToConsole.print(rezListSearchByYear);


    }
}
