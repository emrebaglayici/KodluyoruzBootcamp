package Week1.Week1Homework;

import java.util.Scanner;

public class Hw {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter the height of the pyramid :");
        int n=scanner.nextInt();
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=(n-i) ; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <=(i*2)-1 ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        int newNumber=n-1;
        for (int i = newNumber; i >=1 ; i--) {
            for (int j = 1; j <=(n-i) ; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <=(i*2)-1 ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

}
