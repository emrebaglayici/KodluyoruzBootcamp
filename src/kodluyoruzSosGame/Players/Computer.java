package kodluyoruzSosGame.Players;


import kodluyoruzSosGame.Board.Board;

import java.util.Random;

public class Computer extends User implements IComputer{
    //Computer extends the user class and Implements the interface for behaviours.

    public Computer(String name, int point, Board board) {
        super(name, point,board);
    }

    public int[] generateRowAndColumn(){
        //I generate rows and columns randomly and check if they are unique.
        int[] randoms=new int[2];
        Random random=new Random();
        int randomRow,randomColumn;
        int upperBoundForRow=getBoard().getRow()+1;
        int upperBoundForColumn=getBoard().getColumn()+1;
        int lowerBound=1;
        boolean checker=false;
        while (!checker){
            randomRow=random.nextInt(upperBoundForRow-lowerBound)+lowerBound;
            randomColumn=random.nextInt(upperBoundForColumn-lowerBound)+lowerBound;
            if ((randomRow <= getBoard().getRow() && randomColumn <= getBoard().getColumn())) {
                if (getBoard().getBoard()[randomRow-1][randomColumn-1].equals("-")){
                    randoms[0]=randomRow;
                    randoms[1]=randomColumn;
                    checker=true;
                }
            }
        }

        return randoms;
    }

    @Override
    public String randomLetter() {
        //Generate random letter
        //Random value generates -1 sometimes so I increment it 0 manually.
        Random random=new Random();
        int randomValue = random.nextInt() % 2;
        if (randomValue == -1)
            randomValue++;

        return randomValue==0 ? "S":"O";
    }

    @Override
    public void userStart(int row, int column, String letter) {
        //same as player userStart
        getBoard().getBoard()[row-1][column-1]=letter;
    }
    public void computerTurn() {
        // It is computer moves
        // randomly generated values are assign to board via userStart method.
        System.out.println("It is "+getName()+" turn.");
        int[] randoms=generateRowAndColumn();
        int randomRow=randoms[0],randomColumn=randoms[1];
        String randomLetter = randomLetter();
        userStart(randomRow, randomColumn, randomLetter);
    }


}
