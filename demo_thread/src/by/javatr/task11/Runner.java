package by.javatr.task11;
import java.util.concurrent.locks.ReentrantLock;

import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte0.newThread;

public class Runner {

    public static void main(String[] args) {

        CommonResource commonResource = new CommonResource();
        ReentrantLock locker = new ReentrantLock(); // создаемзаглушку
        for (int i = 1; i < 6; i++) {

            Thread t = new Thread(new CountThread(commonResource, locker));
            t.setName("Поток " + i);
            t.start();
        }
    }

}
