package by.javatr.task6;

public class CommonResource {
    int x = 0;
}

class CountThread implements Runnable{
    CommonResource res;
    CountThread(CommonResource res){
        this.res=res;
    }
    public void run(){
        res.x = 1;
        for (int i = 1; i< 5; i++){
            System.out.printf("%s %d \n", Thread.currentThread().getName(), res.x);
            res.x++;
            try{
                Thread.sleep(100);
            }
            catch(InterruptedException e){}
        }
    }
}
