package Week3.MultiThread.ThreadContact;

public class Main {
    public static void main(String[] args) {
        MessageGenerator messageGenerator=new MessageGenerator();
        Thread thread1=new Thread("Tick",messageGenerator);
        Thread thread2=new Thread("Tock",messageGenerator);



        try{
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
        }catch (InterruptedException e){
            System.out.println("Main thread is interrupted");
        }

        System.out.println("Main thread is finishing");
    }
}
