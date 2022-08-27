package kodluyoruzSosGame.Game;

import kodluyoruzSosGame.Board.Board;
import kodluyoruzSosGame.Players.Computer;
import kodluyoruzSosGame.Players.IComputer;
import kodluyoruzSosGame.Players.Player;

import java.util.Random;

public class SosGame {
    static Random random = new Random();
    private Board board;
    private Player player;
    private Computer computer;
    private IComputer computerImpl;

    public IComputer getComputerImpl() {
        return computerImpl;
    }

    public Board getBoard() {
        return board;
    }

    public void play() {
        // Board creation and initialization.
        //Created two player with default values.
        board = new Board();
        board.createBoard();
        this.computer = new Computer("Computer", 0, board);
        this.player = new Player("Emre", 0, board);
        int randomValue = chooseStarter();
        //Choosing whose is going to start.
        while (getBoard().boardIsEmpty()) {
            //I wrote a lot of boardIsEmpty check and looks ugly but when I try to edit them game does not stop.
            boolean order=true;
            if (randomValue == 0) {
                if (getBoard().boardIsEmpty()){
                    //Until Order true and board is empty runs
                    while (order && getBoard().boardIsEmpty()){
                        player.playerTurn();
                        board.showBoard(board.getBoard());
                        if (!board.allCheck(player))
                            order=false;
                        else
                            System.out.println(player.getName()+" : has "+player.getPoint()+" point");
                    }
                    order=true;


                }else{
                    System.out.println("Game over");
                }
                if (getBoard().boardIsEmpty()){
                    while (order&& getBoard().boardIsEmpty()){
                        computer.computerTurn();
                        board.showBoard(board.getBoard());
                        if (!board.allCheck(computer))
                            order=false;
                        else
                            System.out.println(computer.getName()+" : has "+computer.getPoint()+" point");
                    }
                    order=true;

                }else{
                    System.out.println("Game over");
                }
            } else {
                if (getBoard().boardIsEmpty()){
                    while(order&& getBoard().boardIsEmpty()){
                        computer.computerTurn();
                        board.showBoard(board.getBoard());
                        if (!board.allCheck(computer))
                            order=false;
                        else
                            System.out.println(computer.getName()+" : has "+computer.getPoint()+" point");
                    }
                    order=true;
                }else{
                    System.out.println("Game over");
                }
                if (getBoard().boardIsEmpty()){
                    while (order&& getBoard().boardIsEmpty()){
                        player.playerTurn();
                        board.showBoard(board.getBoard());
                        if (!board.allCheck(player))
                            order=false;
                        else
                            System.out.println(player.getName()+" : has "+player.getPoint()+" point");
                    }
                    order=true;
                }else{
                    System.out.println("Game over");

                }
            }
        }
        // Showing the winner
        final String msg = player.getPoint() > computer.getPoint()
                ? player.getName()+" won."
                : computer.getName()+" won.";
        System.out.println(msg);

    }

    //Randomly choosing who is going to start.
    public int chooseStarter(){
        int randomValue = random.nextInt() % 2;
        if (randomValue == -1)
            randomValue++;

        return randomValue;
    }
}