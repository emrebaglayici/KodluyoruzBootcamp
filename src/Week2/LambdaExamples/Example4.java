package Week2.LambdaExamples;

import java.time.LocalDateTime;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

interface IntPredicate{
    boolean test(int a);
}
interface MyStringFunc{
    String build(char[] chars);
}
interface PredicateInt{
    Integer test(int value);
}

class MyIntPredicates{
    static boolean isPrime(int value){
        if (value<2)
            return false;
        for (int i = 2; i <value/i ; i++) {
            if (value%i==0)
                return false;
        }
        return true;
    }
    static boolean isOdd(int value){
        return value%2!=0;
    }
    boolean isNegative(int value){
        return value<0;
    }
}
public class Example4 {
    static boolean numberTest(IntPredicate predicate,int value){
        return predicate.test(value);
    }
    public static void main(String[] args) {
        Supplier<LocalDateTime> supplier = ()->LocalDateTime.now();
        LocalDateTime time=supplier.get();
        System.out.println(time);

        Function<String,Integer> function=Integer::getInteger;
        System.out.println(
                function.apply("emre")
        );


        Predicate<Integer> isEven=n->n%2==0;
        System.out.println(isEven.test(3));
        MyStringFunc stringFunc=String::new;
        PredicateInt predicateInt=Integer::bitCount;

        char[] chars=new char[]{'a','s'};
        String newStr=stringFunc.build(chars);
        System.out.println(newStr);
        System.out.println(predicateInt.test(232125673));

        boolean result=numberTest(MyIntPredicates::isPrime,17);
        boolean result2=numberTest(MyIntPredicates::isOdd,5);
        MyIntPredicates myIntPredicates=new MyIntPredicates();
        IntPredicate intPredicate=myIntPredicates::isNegative;
        System.out.println(intPredicate.test(0));
        System.out.println(result+" "+result2);
    }
}
