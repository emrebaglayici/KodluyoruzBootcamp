package Week2.GenericsExample;

public class GenericType <T>{

    T obj;
    public GenericType(T obj){
        this.obj=obj;
    }
    public T getObj(){
        return obj;
    }
    void showType(){
        System.out.println(
                "Type of class is"+obj.getClass().getName()
        );
    }
}
