package kodluyoruzSosGame.Players;


import kodluyoruzSosGame.Board.Board;

public abstract class User {
    //Player and Computer have same fields
    //To not create directly user object I made it abstract

    private String name;
    private int point;

    private Board board;

    public User(String name, int point,Board board) {
        this.name = name;
        this.point = point;
        this.board=board;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public abstract void userStart(int row, int column, String letter) ;
}
