package by.javatr.task12;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Store {
    private int product = 0;
    ReentrantLock locker;
    Condition condition;

    Store() {
        locker = new ReentrantLock(); // создаемблокировку
        condition = locker.newCondition(); // получаемусловие, связанное с блокировкой
    }

    public void get() {

        locker.lock();
        try {
            // поканетдоступныхтоваровнаскладе, ожидаем
            while (product< 1)
                condition.await();

            product--;
            System.out.println("Покупатель купил 1 товар");
            System.out.println("Товаров на складе: " + product);

            // сигнализируем
            condition.signalAll(); // будет потоки в режиме ожидания
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            locker.unlock();
        }
    }

    public void put() {

        locker.lock();
        try {
            // поканаскладе 3 товара, ждемосвобожденияместа
            while (product>= 3)
                condition.await();

            product++;
            System.out.println("Производитель добавил 1 товар");
            System.out.println("Товаров на складе: " + product);
            // сигнализируем
            condition.signalAll();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            locker.unlock();
        }
    }

}
