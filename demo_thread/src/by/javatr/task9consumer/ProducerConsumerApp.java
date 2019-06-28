package by.javatr.task9consumer;

public class ProducerConsumerApp {
    public static void main(String[] args) {

        Store store = new Store();
        new Producer(store).start();
        new Consumer(store).start();
    }
}

//создаемобъектсклада,скоторогобудутбратьтоварыпокупатели
//икудабудутвноситьтоварыпроизводители
class Store {
    int counter = 0; // счетчиктоваров
    final int N=5;//максимальнодопустимоечисло

    //синхронизированныйметоддляпроизводителей
    synchronized int put(){
        if(counter<=N)//еслитоваровменьше
        {
            counter++;//кладемтовар
            System.out.println ("склад имеет "+counter+" товар(ов)");
            return 1;//вслучаеудачноговыполнениявозвращаем1
        }
        return 0;//вслучаенеудачноговыполнениявозвращаем0
    }

    //методдляпокупателей
    synchronized int get(){
        if(counter>0)//еслихотьодинтоварприсутствует
        {
            counter--;//беремтовар
            System.out.println ("склад имеет "+counter+" товар(ов)");
            return 1;//вслучаеудачноговыполнениявозвращаем1
        }
        return 0;//вслучаенеудачноговыполнениявозвращаем0
    }
}

//потокпроизводителя
class Producer extends Thread {
    Store store;//объектсклада,кудакладемтовар
    int product=5;//количествотоваров,которыенадодобавить

    Producer(Store store) {
        this.store = store;
    }

    public void run() {
        try {
            while (product> 0) { // покаупроизводителяимеютсятовары
                product=product-store.put();//кладемодинтоварнасклад
                System.out.println("производителю осталось произвести "+product+" товар(ов)");
                sleep(100); // времяпростоя
            }
        } catch (InterruptedException e) {
            System.out.println(" поток производителя прерван");
        }
    }
}

//потокпокупателя
class Consumer extends Thread {
    Store store;//объектсклада,скоторогопокупательбудетбратьтовар
    int product=0;//текущееколичествотоваровсосклада

    Consumer(Store store) {
        this.store = store;
    }

    public void run(){
        try{
            while(product<5){//покаколичествотоваровнебудетравно5

                product=product+store.get();//беремпоодномутоварусосклада
                System.out.println("Потребитель купил "+product+" товар(ов)");
                sleep(100);
            }
        }catch(InterruptedException e){
            System.out.println("поток потребителя прерван");
        }
    }

}
