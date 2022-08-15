package Week3.MultiThread.Semaphore;

import java.util.concurrent.Phaser;

public class PhaserDemo implements Runnable{
    private String name;
    private Phaser phaser;

    public PhaserDemo(String name, Phaser phaser) {
        this.name = name;
        this.phaser = phaser;
        phaser.register();
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println(name+" is starting phase 1");
        phaser.arriveAndAwaitAdvance();

        sleepThread(10);

        System.out.println(name+" is starting phase 2");
        phaser.arriveAndAwaitAdvance();

        sleepThread(10);

        System.out.println(name+" is starting phase 3");
        phaser.arriveAndDeregister();
    }

    private void sleepThread(int i) {
        try{
            Thread.sleep(i);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
