package Week2.GenericsExample;

interface ContainChecker<T>{
    boolean contains(T obj);
}
public class GenericInterfaceDemo<T> implements ContainChecker<T> {
    T[] values;

    public GenericInterfaceDemo(T[] values) {
        this.values = values;
    }

    @Override
    public boolean contains(Object obj) {
        for (T a:values){
            if (a==obj)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Integer[] integers=new Integer[]{1,2,3,4,5};
        GenericInterfaceDemo<Integer> genericInterfaceDemo=new GenericInterfaceDemo<>(integers);
        System.out.println(genericInterfaceDemo.contains(5));
    }
}
