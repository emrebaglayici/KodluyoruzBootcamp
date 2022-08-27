package kodluyoruzSosGame.Board;

import kodluyoruzSosGame.Players.User;

import java.util.*;

public class Board {
    List<String> rightPoints = new ArrayList<>();
    List<String> horizontalPoints = new ArrayList<>();
    List<String> verticalPoints = new ArrayList<>();

    List<String> leftPoints = new ArrayList<>();
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    String[][] board;

    private int row, column;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void createBoard() {
        boolean checker = false;
        //Creating the board by user inputs.
        while (!checker) {
            try {
                System.out.print("Please enter the board row : ");
                row = Integer.parseInt(scanner.nextLine());
                System.out.print("Please enter the board column : ");
                column = Integer.parseInt(scanner.nextLine());

                if ((row == 5 && column == 5) || (row == 10 && column == 10)) {
                    checker = true;
                    System.out.println("Board created");
                    showBoard(initBoard(row, column));
                } else {
                    System.out.println("Please enter minimum 5x5 or maximum 10x10");
                }

            } catch (NumberFormatException numberFormatException) {
                System.out.println("Please type a valid board size for each line");
                continue;
            }
        }
    }

    public String[][] initBoard(int n, int m) {
        //Initialize the board and assign - .
        board = new String[n][m];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = "-";
            }
        }

        return board;

    }

    public String[][] getBoard() {
        return board;
    }

    public void showBoard(String[][] board) {
        //Row numbers printed
        System.out.print(" ");
        for (int row = 1; row < board[0].length + 1; row++) {
            System.out.print("  " + row);
        }
        System.out.println();

        // Column numbers and row+column printed
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                if (column < 1) {
                    System.out.print(row + 1);
                    System.out.print("  " + board[row][column]);
                } else {
                    System.out.print("  " + board[row][column]);
                }
                if (column == board[row].length - 1)
                    System.out.println();
            }
        }
    }

    public boolean allCheck(User user) {
        //Check any check return true or not.
        return horizontalCheck(user) || verticalCheck(user) || rightDiagonal(user) || leftDiagonalCheck(user);
    }

    public boolean horizontalCheck(User user) {
        for (int i = 0; i < getBoard().length; i++) {
            for (int j = 0; j < getBoard()[i].length; j++) {
                if (getBoard()[i][j].equals("O")) {
                    //find the place of O letter
                    if (j > 0 && j < getBoard()[0].length - 1) {
                        // O must be grater than 0 row and last row
                        String temp = (i) + "" + (j + 1);
                        if ((getBoard()[i][j - 1].equals("S")) && (getBoard()[i][j + 1].equals("S") && !searchForHorizontal(temp))) {
                            // if the O letter middle of the somewhere at row than SOS.
                            horizontalPoints.add(temp);
                            user.setPoint(user.getPoint() + 1);

                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean leftDiagonalCheck(User user) {
        //Same logic with the other checks but the difference is previous and next letter checks.
        for (int i = 0; i < getBoard().length; i++) {
            for (int j = 0; j < getBoard()[i].length; j++) {
                if (getBoard()[i][j].equals("O") && i != 0 && i != getBoard().length - 1 && j != 0 && j != getBoard().length - 1) {
                    String temp = (i + 1) + "" + (j + 1);
                    if (getBoard()[i - 1][j - 1].equals("S") && getBoard()[i + 1][j + 1].equals("S") && !searchForLeftDiagonal(temp)) {
                        leftPoints.add(temp);
                        user.setPoint(user.getPoint() + 1);
                        return true;
                    }

                }
            }
        }


        return false;
    }

    //These search methods for SOS check
    //Check SOS is unique.
    //I know these method duplicates and look kinds of boilerplate :)
    //I will fix later.
    public boolean searchForRightDiagonal(String value) {
        for (String a : rightPoints) {
            if (Objects.equals(a, value))
                return true;
        }

        return false;
    }

    public boolean searchForLeftDiagonal(String value) {
        for (String a : leftPoints) {
            if (Objects.equals(a, value))
                return true;
        }

        return false;
    }

    public boolean searchForHorizontal(String value) {
        for (String a : horizontalPoints) {
            if (Objects.equals(a, value))
                return true;
        }
        return false;
    }

    public boolean searchForVertical(String value) {
        for (String a : verticalPoints) {
            if (Objects.equals(a, value))
                return true;
        }
        return false;
    }

    public boolean rightDiagonal(User user) {
        //Same logic with the other checks but the difference is previous and next letter checks.
        for (int i = 0; i < getBoard().length; i++) {
            for (int j = 0; j < getBoard()[i].length; j++) {
                if (getBoard()[i][j].equals("O")) {
                    if (i != 0 && i != getBoard().length - 1 && j != getBoard().length - 1 && j != 0) {
                        String temp = (i + 1) + "" + (j - 1);
                        if (getBoard()[i + 1][j - 1].equals("S") && getBoard()[i - 1][j + 1].equals("S") && !searchForRightDiagonal(temp)) {
                            rightPoints.add(temp);
                            user.setPoint(user.getPoint() + 1);
                            return true;
                        }

                    }
                }

            }
        }
        return false;
    }


    public boolean verticalCheck(User user) {
        for (int i = 0; i < getBoard().length; i++) {
            for (int j = 0; j < getBoard()[0].length; j++) {
                if (getBoard()[i][j].equals("O")) {
                    //find the place of O letter
                    if (i != 0 && i != getBoard().length - 1) {
                        //O cannot be 0 index and last index
                        String temp = (i - 1) + "" + (j);
                        if ((getBoard()[i - 1][j].equals("S")) && (getBoard()[i + 1][j].equals("S") && !searchForVertical(temp))) {
                            //In this case O letter somewhere in middle and
                            // we need to check previous and next letter
                            // if they are S letter so SOS.
                            verticalPoints.add(temp);
                            //If there is a sos point then add the list
                            // because it was returning true every time.
                            // Increment the user point.
                            user.setPoint(user.getPoint() + 1);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }


    public boolean boardIsEmpty() {
        //Check the board is empty or not.
        for (int i = 0; i < getBoard().length; i++) {
            for (int j = 0; j < getBoard()[i].length; j++) {
                if (getBoard()[i][j].equals("-"))
                    return true;
            }
        }
        return false;
    }
}
