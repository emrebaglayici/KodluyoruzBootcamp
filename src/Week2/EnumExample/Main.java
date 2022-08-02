package Week2.EnumExample;

public class Main {
    public static void main(String[] args) {
        Transport[] transports = Transport.values();
        for (Transport t : transports) {
            System.out.println(
                    t.name()+t.getMaxSpeed()
            );
        }
    }
}
