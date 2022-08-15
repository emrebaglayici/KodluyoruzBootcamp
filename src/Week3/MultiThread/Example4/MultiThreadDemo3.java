package Week3.MultiThread.Example4;

class MultiThreadDemo4 extends Thread{

    public MultiThreadDemo4(String name) {
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
        System.out.println(getName()+ "is terminating");
    }
}



public class MultiThreadDemo3 {
    public static void main(String[] args) {
        System.out.println("Main thread is starting");
        MultiThreadDemo4 myThread = new MultiThreadDemo4("child1");
        MultiThreadDemo4 myThread2 = new MultiThreadDemo4("child2");
        MultiThreadDemo4 myThread3 = new MultiThreadDemo4("child3");

        myThread.start();
        myThread2.start();
        myThread3.start();

        do {
            System.out.println(".");
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                System.out.println("Main thread is interrupted");
            }
        }while (myThread.isAlive() || myThread2.isAlive()|| myThread3.isAlive());

        System.out.println("Main thread is terminating");
    }
}
