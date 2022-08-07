package Week2.ExceptionExample;
class ArrayOperations{
    public void putValue(int[] arr,int index,int value){
        System.out.println("method started");
        arr[index]=value;
        System.out.println("method end");
    }
}
public class Example1 {
    public static void main(String[] args) {
        ArrayOperations arrayOperations=new ArrayOperations();
        int[] numbers=new int[7];
        try{
            System.out.println("try started");
            arrayOperations.putValue(numbers,6,9);
            System.out.println("try ended");
        }catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Exception catch "+ex.toString());
        }
        System.out.println("Program ends");
    }
}
