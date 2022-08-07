package Week2.GenericsExample;

public class NumericOperation<T extends Number> {
    private T obj;

    public NumericOperation(T obj) {
        this.obj = obj;
    }
    public T getObj(){
        return obj;
    }
    boolean isDividableByTen(){
        return obj.doubleValue()-obj.intValue()==0 && obj.intValue()%10==0;
    }
    boolean absEqual(NumericOperation<?> another){
        return Math.abs(this.obj.doubleValue())==Math.abs(another.obj.doubleValue());
    }

    public static void main(String[] args) {
        NumericOperation<Integer> numericOperation=new NumericOperation(30);
        System.out.println(
                "Is "+numericOperation.getObj()+" dividable by ten : "+numericOperation.isDividableByTen()
        );

        NumericOperation<Double> doubleNumericOperation=new NumericOperation<>(2.5);
        NumericOperation<Float> floatNumericOperation=new NumericOperation<>(-2.5f);
        System.out.println("Is equal ? "+doubleNumericOperation.absEqual(floatNumericOperation));
    }
}
