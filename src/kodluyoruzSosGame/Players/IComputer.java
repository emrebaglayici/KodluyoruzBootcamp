package kodluyoruzSosGame.Players;

public interface IComputer {
    //To implements the computer  class , I created an interface
    // In later, I will add new behaviour for AI.
    int[] generateRowAndColumn();
    String randomLetter();
}
