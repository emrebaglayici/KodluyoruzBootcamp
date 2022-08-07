package Week2.ExceptionExample;

public class Example2 {
    public static void main(String[] args) {
        int[] numbers={1,34,56,23,78};
        int[] dividers={5,0,12,0,34};

        for (int i = 0; i < numbers.length; i++) {
            try {
                System.out.println(
                        numbers[i]+" / "+dividers[i] +" = "+numbers[i]/dividers[i]
                );
            }catch (ArithmeticException ex){
                System.out.println("Divison by 0, "+numbers[i]+ "/"+dividers[i]);
            }
        }
        System.out.println("end");
    }
}
