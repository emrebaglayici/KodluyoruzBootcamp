package Week3.MultiThread.ThreadContact;

public class MessageGenerator {
    String state;

    synchronized void tick(boolean running) {
        if (!running) {
            state = "ticked";
            notify();
            return;
        }

        System.out.print("tick");
        state = "ticked";


        notify();

        try {
            while (!state.equals("tocked")) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void tock(boolean running) {

        if (!running) {
            state = "tocked";
            notify();
            return;
        }

        if (state!=null) {
            System.out.println(" tock");
            state = "tocked";
        }
        notify();

        try {
            while (!"ticked".equals(state)) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
