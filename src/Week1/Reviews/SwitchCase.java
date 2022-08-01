package Week1.Reviews;

import java.util.Scanner;

public class SwitchCase {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Year : ");
        int year=scanner.nextInt();
        System.out.print("Month : ");
        int month= scanner.nextInt();

        System.out.println("Number of Days = "+getNumberOfDays(year,month));

    }

    public static int getNumberOfDays(int year, int month) {
        int numDays=0;
        switch (month){
            case 1: case 3: case 5:
            case 7: case 8: case 10:
            case 12:
                numDays=31;
                break;
            case 4: case 6:
            case 9: case 11:
                numDays=30;
                break;
            case 2:
                if (((year%4==0) && !(year%100==0)) || (year%400==0))
                    numDays=29;
                else
                    numDays=28;
                break;
            default:
                System.out.println("Invalid month");
        }
        return numDays;
    }
}
