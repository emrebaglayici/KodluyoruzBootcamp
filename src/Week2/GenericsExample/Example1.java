package Week2.GenericsExample;

public class Example1 {
    public static void main(String[] args) {
        GenericType<Integer> genericType=new GenericType<>(4);
        genericType.showType();
        System.out.println("Value of generic obj "+genericType.getObj());
    }
}
