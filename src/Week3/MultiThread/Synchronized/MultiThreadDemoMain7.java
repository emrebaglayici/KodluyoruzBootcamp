package Week3.MultiThread.Synchronized;


class ArrayOperations {
    int sum = 0;

    //sync. yazmıştık methoda önceki örnekte
     int sum(int[] array) {
        for (int value : array) {
            sum += value;
            System.out.println("Sum : " + sum + " Thread name : " + Thread.currentThread().getName());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted");
            }
        }
        return sum;
    }
}

class MultiThreadDemo extends Thread {
    int[] array;
    static ArrayOperations operations = new ArrayOperations();

    public MultiThreadDemo(int[] array) {

        this.array = array;
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " is starting");
        synchronized (operations){
            System.out.println("Sum of the array is :" + operations.sum(this.array));
        }

        System.out.println(this.getName() + " is finishing");
    }
}


public class MultiThreadDemoMain7 {
    public static void main(String[] args) {
        int[] array = {1, 23, 45, 9, 52, 78};
        MultiThreadDemo thread1 = new MultiThreadDemo(array);
        MultiThreadDemo thread2 = new MultiThreadDemo(array);


        try {
            thread1.start();
            thread1.join();
            thread2.start();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread is interrupted");
        }

        System.out.println("Main thread is finishing");
    }
}
