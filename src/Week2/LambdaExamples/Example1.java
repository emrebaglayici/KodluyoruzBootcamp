package Week2.LambdaExamples;

import java.util.concurrent.atomic.AtomicReference;

interface NumericTest {
    boolean test(int a, int b);
}

interface NumericFunc {
    int func(int a);
}

interface StringFunc {
    String func(String str);
}

interface NumericTestGeneric<T> {
    boolean test(T a, T b);
}

public class Example1 {

    public static void main(String[] args) {
        final int[] value = {10};
        AtomicReference<String> strr = new AtomicReference<>("sa");
        NumericFunc func = (a) -> {
            value[0] = 20;
            strr.set("");
            return value[0] * a;
        };
        NumericTest isFactor = (m, n) -> m % n == 0;
        NumericTest lessThan = (m, n) -> m < n;
        NumericTest absEqual = (m, n) -> (m < 0 ? -m : m) == (n < 0 ? -n : n);

        NumericFunc biggestFactor = (x) -> {
            int result = 1;
            x = x < 0 ? -x : x;
            for (int i = 2; i <= x / 2; i++) {
                if (x % i == 0)
                    result += i;
            }
            return result;
        };

        StringFunc reverse = (str -> {
            String result = "";
            for (int i = str.length() - 1; i >= 0; i--) {
                result += str.charAt(i);
            }
            return result;
        });

        NumericTestGeneric<Integer> numericTestGeneric = (x, y) -> x < y;

        System.out.println(numericTestGeneric.test(2, 3));
        System.out.println(changeStr(reverse, "madam"));
        System.out.println(biggestFactor.func(6));


    }

    static String changeStr(StringFunc stringChanger, String value) {
        return stringChanger.func(value);
    }
}
