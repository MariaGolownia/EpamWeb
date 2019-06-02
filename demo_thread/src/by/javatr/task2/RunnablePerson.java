package by.javatr.task2;

public class RunnablePerson extends Person implements Runnable {

    public RunnablePerson (String name) {
        super(name);
    }

    public void run() {
        Thread t = Thread.currentThread(); // получаем главный поток
        t.setName(getName());
        System.out.println(t.getName()); // main
        System.out.println(t); // Thread[main,5,main]
        for (int i = 0; i < 10; i++){
            System.out.println(getName() + ": Hello World!");
        }
    }

    public static void main(String[] args) {
        RunnablePerson p1 = new RunnablePerson("Alice");
        Thread t1 = new Thread(p1);
        t1.start();
        RunnablePerson p2 = new RunnablePerson("Bob");
        Thread t2 = new Thread(p2);
        t2.start();
        try {
            t1.join(); // Ждет выполнения указанного потока
        }
        catch (InterruptedException ex)
        {
            ex.printStackTrace();
        }
        System.out.println("stop");

    }
}
