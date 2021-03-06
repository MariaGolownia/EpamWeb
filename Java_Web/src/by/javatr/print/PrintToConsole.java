package by.javatr.print;

import by.javatr.entity.Plane;

import java.util.List;

public class PrintToConsole {

	public static void print (String str)  {
		System.out.print(" " + str);
	}
	
	public static void print (int numberInt)  {
		System.out.print(" " + numberInt);
	}
	
	public static void print (double numberDouble)  {
		System.out.print(" " + numberDouble);
	}
	
	public static void println (String str)  {
		System.out.println(" " + str);
	}
	
	public static void println (int numberInt)  {
		System.out.println(" " + numberInt);
	}
	
	public static void println (double numberDouble)  {
		System.out.println(" " + numberDouble);
	}
	
	public static void println (Object obj)  {
		System.out.println(" " + obj);
	}

	public static void print (List<Plane> rezListSearchByModel) {
		for (int i = 0; i < rezListSearchByModel.size(); i++) {
			System.out.println(rezListSearchByModel.get(i));
		}

	}

}
