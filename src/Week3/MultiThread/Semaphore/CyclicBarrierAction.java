package Week3.MultiThread.Semaphore;

public class CyclicBarrierAction implements Runnable{
    private int counter=1;

    @Override
    public void run() {
        System.out.println(counter++ +" Barrier achieved");
    }
}
