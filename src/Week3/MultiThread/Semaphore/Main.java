package Week3.MultiThread.Semaphore;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore=new Semaphore(1,true);
        CountDownLatch countDownLatch=new CountDownLatch(5);
        CountDownLatchDemo task1=new CountDownLatchDemo(true,"Incrementer",countDownLatch);
        CountDownLatchDemo task2=new CountDownLatchDemo(false,"Decrementer",countDownLatch);

//        SemaphoreDemo task1=new SemaphoreDemo(true,"Incrementer",semaphore);
//        SemaphoreDemo task2=new SemaphoreDemo(false,"Decrementer",semaphore);

        Thread thread1=new Thread(task1);
        Thread thread2=new Thread(task2);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}
