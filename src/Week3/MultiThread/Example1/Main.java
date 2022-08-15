package Week3.MultiThread.Example1;

public class Main {
    public static void main(String[] args) {
        MyThread myThread=new MyThread();
        MyTask task=new MyTask();
        Thread realThread=new Thread(task);
    }
}
