package Week2.LambdaExamples;

import java.io.IOException;
import java.io.InputStreamReader;

interface NumericTest3<T extends Number>{
    boolean test(T a,T b);
}
interface StringFunc3{
    String func() throws IOException;
}
public class Example3 {
    public static void main(String[] args) throws IOException {
        StringFunc3 strReader=()->{
            String result="";
            InputStreamReader reader=new InputStreamReader(System.in);
            result= String.valueOf(reader.read());
            return result;
        };

        strReader.func();

        NumericTest3<Integer> isFactor=(a,b)->{
            if (b==0)
                throw new IllegalArgumentException("Divider cannot be zero");
            return a%b==0;
        };

        System.out.println(isFactor.test(2,1));
        isFactor.test(2,1);

    }
}
