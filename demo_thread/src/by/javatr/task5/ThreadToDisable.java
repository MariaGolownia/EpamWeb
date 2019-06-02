package by.javatr.task5;

import java.util.concurrent.TimeUnit;

public class ThreadToDisable implements Runnable {

        private boolean isActive;

        void disable(){
            isActive=false;
        }

        ThreadToDisable (){
            isActive = true;
        }

        public void run(){

            System.out.printf("Поток %s началработу... \n", Thread.currentThread().getName());
            int counter=1; // счетчикциклов
            while(isActive){
                System.out.println("Цикл " + counter++);
                try{
                    //Thread.sleep(500);
                    TimeUnit.MILLISECONDS.sleep(10);
                }
                catch(InterruptedException e){
                    System.out.println("Потокпрерван");
                }
            }
            System.out.printf("Поток %s завершилработу... \n", Thread.currentThread().getName());

    }

}
