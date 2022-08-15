package Week3.MultiThread.Semaphore;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo implements Runnable{
    private boolean increment;
    private String name;
    private CountDownLatch countDownLatch;

    public CountDownLatchDemo(boolean increment, String name, CountDownLatch countDownLatch) {
        this.increment = increment;
        this.name = name;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            if (increment){
                for (int i = 0; i < 5; i++) {
                    System.out.println(name+" value : "+SharedObject.incrementAndGet());
                    Thread.sleep(10);
                    countDownLatch.countDown();
                }
            }else{
                countDownLatch.await();
                for (int i = 0; i < 5; i++) {
                    System.out.println(name+" value : "+SharedObject.decrementAndGet());
                    Thread.sleep(10);
                }
            }
        }catch (InterruptedException e){
             e.printStackTrace();
        }
    }
}
