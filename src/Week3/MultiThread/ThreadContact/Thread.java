package Week3.MultiThread.ThreadContact;

public class Thread  extends java.lang.Thread {
    MessageGenerator generator;
    public Thread(String name,MessageGenerator generator){
        super(name);
        this.generator=generator;
    }

    @Override
    public void run() {
        System.out.println(this.getName()+" is starting");
        if (this.getName().equals("Tick")){
            for (int i = 0; i < 5; i++) {
                generator.tick(true);
            }
            generator.tick(false);
        }else{
            for (int i = 0; i < 5; i++) {
                generator.tock(true);
            }
            generator.tock(false);
        }
        System.out.println(this.getName()+" is finishing");
    }
}
