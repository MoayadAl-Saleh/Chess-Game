package Game.ChessGame;

public interface IChessGame
    {
    boolean isDone();

    boolean isWhiteTurn();

    boolean isBlackTurn();

    void playWhite(String move) throws Exception;

    void playBlack(String move) throws Exception;
    void printWinnerName();
    }
