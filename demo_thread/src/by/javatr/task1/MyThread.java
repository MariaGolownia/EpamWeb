package by.javatr.task1;

public class MyThread extends Thread {

    public void  run() {
        System.out.println("Hello World!");

    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }

}
