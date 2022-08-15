package Week3.MultiThread.Example2;

class MultiThreadDemo1 implements Runnable {

    private String threadName;

    public MultiThreadDemo1(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println(threadName+" is starting");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(400);
                System.out.println("In " + threadName + " count is " + i);
            } catch (InterruptedException e) {
                System.out.println(threadName + " is interrupted.");
            }
        }
        System.out.println(threadName+ " is terminating");
    }
}

public class MultiThreadDemoMain {
    public static void main(String[] args) {
        System.out.println("Main thread is starting ");
        MultiThreadDemo1 task=new MultiThreadDemo1("child1");
        Thread thread=new Thread(task);
        thread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println(".");
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                System.out.println("Main thread is interrupted");
            }
        }
        System.out.println("Main thread is terminating");
    }
}
