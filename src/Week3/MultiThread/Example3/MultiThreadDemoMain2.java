package Week3.MultiThread.Example3;


class MultiThreadDemo2 extends Thread{

    public MultiThreadDemo2(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(getName()+" is starting");
        for (int i = 0; i < 10; i++) {
            try{
                Thread.sleep(400);
                System.out.println("In "+getName()+" count is "+i);
            }catch (InterruptedException e){
                System.out.println(getName()+" is interrupted");
            }
        }
        System.out.println(getName()+" is terminating");
    }
}



public class MultiThreadDemoMain2 {
    public static void main(String[] args) {
        MultiThreadDemo2 myThread1=new MultiThreadDemo2("child1");
        MultiThreadDemo2 myThread2=new MultiThreadDemo2("child2");
        MultiThreadDemo2 myThread3=new MultiThreadDemo2("child3");

        myThread1.start();
        myThread2.start();
        myThread3.start();

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
