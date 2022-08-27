package kodluyoruzSosGame.Players;

import kodluyoruzSosGame.Board.Board;

import java.util.Scanner;

public class Player extends User {
    static Scanner scanner = new Scanner(System.in);

    public Player(String name, int point, Board board) {
        super(name, point, board);
    }

    @Override
    public void userStart(int row, int column, String letter) {
        //To make user-friendly , I change row and column 0 to 1.
        //And Assign the letter exact row and column.
        if (row == 0)
            row = 1;
        if (column == 0)
            column = 1;
        getBoard().getBoard()[row - 1][column - 1] = letter;
    }

    public void playerTurn() {
        //In here , take user outputs and handle these.
        //If everything fine than calls userStart method.

        System.out.println("It is " + getName() + " turn.");
        int row, column;
        String letter;


        boolean checker = false;
        while (!checker) {
            try{
                System.out.print("Enter the row for adding : ");
                row = Integer.parseInt(scanner.next());
                System.out.print("Enter the column for adding : ");
                column = Integer.parseInt(scanner.next());
                if ((row <= getBoard().getRow() && column <= getBoard().getColumn())) {
                    if (getBoard().getBoard()[row - 1][column - 1].equals("-")) {
                        System.out.print("Enter the S or O : ");
                        letter = scanner.next().toUpperCase();
                        if (letter.length() == 1) {
                            if (letter.equals("S") || letter.equals("O")) {
                                userStart(row, column, letter);
                                checker = true;
                            } else {
                                System.out.println("Please type only S/O");
                            }
                        } else {
                            System.out.println("Type only one character hint S/O");
                        }

                    } else {
                        System.out.println("This slot is not empty , please try again");
                    }
                } else {
                    System.out.println("Invalid row or column index");
                }
            }catch (NumberFormatException exception){
                System.out.println("Invalid Input");
            }
        }
    }
}
