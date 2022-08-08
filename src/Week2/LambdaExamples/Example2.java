package Week2.LambdaExamples;

import java.io.IOException;
import java.io.InputStreamReader;

interface NumericTest2<T extends Number>{
    boolean test(T a,T b);
}

interface StringFunc2{
    String func() throws IOException;
}

public class Example2 {
    
    public static void main(String[] args) {
        StringFunc2 strReader=()->{
          String result="";
            InputStreamReader reader=new InputStreamReader(System.in);
            result=String.valueOf(reader.read());
            return result;
        };

        NumericTest2<Integer> isFactor=(a,b)->{
            if (b==0)
                throw new IllegalArgumentException("Divider cannot be zero");
            return a%b==0;
        };

        isFactor.test(5,1);
    }
}
