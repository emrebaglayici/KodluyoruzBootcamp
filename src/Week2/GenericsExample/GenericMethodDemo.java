package Week2.GenericsExample;

public class GenericMethodDemo {

    public <T extends Comparable<T>,V extends T> boolean arraysEqual(T[] arr1,V[] arr2){
        if (arr1.length!= arr2.length)
            return false;
        for (int i = 0; i < arr1.length; i++) {
            if(!arr1[i].equals(arr2[i]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        GenericMethodDemo genericMethodDemo=new GenericMethodDemo();
        Integer[] integer1=new Integer[]{1,2,3,4,5};
        Integer[] integer2=new Integer[]{1,2,3,4,5};

        System.out.println(genericMethodDemo.arraysEqual(integer1,integer2));
    }
}
