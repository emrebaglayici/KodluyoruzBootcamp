package Week3.MultiThread.Example6;

class MultiThreadDemo extends Thread{
    private int count=0;
    public static boolean counting =true;
    private static final int maxCount=100_000_000;

    @Override
    public void run() {
        System.out.println(this.getName()+" is starting");
        do{
            this.count++;
            if (this.count==maxCount)
                counting=false;
        }while (counting&&this.count<maxCount);
        System.out.println("In "+this.getName()+" count : "+count);
    }
}
public class MultiThreadDemoMain6 {
    public static void main(String[] args) {
        System.out.println("Number of processors : "+Runtime.getRuntime().availableProcessors());
        MultiThreadDemo[] threads=new MultiThreadDemo[30];
        for (int i = 0; i < threads.length; i++) {
            threads[i]=new MultiThreadDemo();
        }
        threads[0].setPriority(Thread.MAX_PRIORITY);
        threads[1].setPriority(Thread.MAX_PRIORITY);
        threads[2].setPriority(Thread.MAX_PRIORITY);
        threads[3].setPriority(Thread.MIN_PRIORITY);
        threads[4].setPriority(Thread.MIN_PRIORITY);
        threads[5].setPriority(Thread.MIN_PRIORITY);

        for (MultiThreadDemo thread : threads) {
            thread.start();
        }
        try{
            for (MultiThreadDemo thread:threads){
                thread.join();
            }
        }catch (InterruptedException e){
            System.out.println("Main thread interrupted");
        }

    }
}
