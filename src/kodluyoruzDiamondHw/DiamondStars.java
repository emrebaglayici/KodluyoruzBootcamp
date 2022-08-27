package kodluyoruzDiamondHw;

import java.util.Scanner;

public class DiamondStars {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter the height of the pyramid :");
        int height=scanner.nextInt();
        // After we get the height of the pyramid
        // There should be a loop and runs as much as te height
        for (int i = 1; i <=height ; i++) {
            // Inside the loop first we need to give spaces
            for (int j = 1; j <=(height-i) ; j++) {
                System.out.print(" ");
            }
            // After spaces , we put stars and increase by outer loop
            for (int j = 1; j <=(i*2)-1 ; j++) {
                System.out.print("*");
            }
            // After every line we need to pass another row
            System.out.println();
        }



        int heightMinusOne=height-1;
        //Same loop but reverse to print stars
        for (int i = heightMinusOne; i >=1 ; i--) {
            for (int j = 1; j <=(height-i) ; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <=(i*2)-1 ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

}
