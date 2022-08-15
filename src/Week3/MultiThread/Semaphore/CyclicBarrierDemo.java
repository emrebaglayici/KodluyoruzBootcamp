package Week3.MultiThread.Semaphore;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo implements Runnable {
    private String name;
    private CyclicBarrier barrier;

    public CyclicBarrierDemo(String name, CyclicBarrier barrier) {
        this.name = name;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        System.out.println(name+" is starting");
        for (int i = 0; i <=15 ; i++) {
            if (i%5==0){
                try{
                    System.out.println(name+" is reached to "+i);
                    barrier.await();
                }catch (InterruptedException | BrokenBarrierException e){
                    e.printStackTrace();
                }
            }
        }
        System.out.println(name+" is finishing");
    }
}
