package Week1.Reviews;

import java.util.Scanner;

public class Loop {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the height of pyramid : ");
        int height = sc.nextInt();

        int stars = 1;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j <  (height * 2 - stars) / 2; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < stars ; j++) {
                System.out.print("*");
            }

            stars += 2;
            System.out.println();
        }

        stars -= 4;
        for (int i = height - 1; i > 0 ; i--) {

            for (int j = 0; j < (height * 2 - stars) / 2; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < stars; j++) {
                System.out.print("*");
            }

            stars -= 2;
            System.out.println();
        }
    }
}
