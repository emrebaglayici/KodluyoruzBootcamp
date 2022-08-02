package Week2.BubbleSort;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers ={10, 23, -98, 76, 9, -123, -28, 0, 35};
        sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
    public static void sort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
}
