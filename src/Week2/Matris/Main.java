package Week2.Matris;

public class Main {
    public static void main(String[] args) {
        int matrix[][]=new int[3][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j]=i+j*2;
            }

        }
        printArray(matrix);


    }

    public static void printArray(int[][] arr){
        for (int[] a:arr){
            for (int b:a){
                System.out.print(b+" ");
            }
            System.out.println();
        }
    }
}
