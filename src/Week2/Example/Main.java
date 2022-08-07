package Week2.Example;

public class Main {
    public static void main(String[] args) {
        /*
            Priority Queue
            Generic
            Add , pop and peek
         */

        PriorityQueue<String> priorityQueue=new PriorityQueue<>();
        priorityQueue.add("Kodluyoruz",Priority.MEDIUM);
        priorityQueue.add("Bootcamp",Priority.LOW);
        priorityQueue.add("Java",Priority.MEDIUM);

        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.pop());
        System.out.println(priorityQueue.pop());
        System.out.println(priorityQueue.pop());
    }
}
