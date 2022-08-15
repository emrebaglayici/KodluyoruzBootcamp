package Week3.MultiThread.Example5;

class MultiThreadDemo5 extends Thread{
    public MultiThreadDemo5(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(getName() + " is starting.");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(400);
                System.out.println("In " + getName() + " count is " + i);
            } catch (InterruptedException e) {
                System.out.println(getName() + " is interrupted");
            }
        }

        System.out.println(getName() + " is terminating");
    }
}
public class MultiThreadDemoMain5 {
    public static void main(String[] args) {
        MultiThreadDemo5 thread1=new MultiThreadDemo5("child1");
        MultiThreadDemo5 thread2=new MultiThreadDemo5("child2");
        MultiThreadDemo5 thread3=new MultiThreadDemo5("child3");

        thread1.start();
        thread2.start();
        thread3.start();

        try{
            thread1.join();
            //threadlerin işlerini bitirip main threade katılmalarını söyler.
            thread2.join();
            thread3.join();
        }catch (InterruptedException e){
            System.out.println("Main is interrupted");
        }

        System.out.println("Main thread is terminating");
    }
}
