package Game.Board;

import Game.Piece.Piece;
import Game.ChessGame.Spot;

public interface IBoard
    {
    Spot getBox(int x, int y) throws Exception;
    void setBox(int x , int y , Piece piece) throws Exception;
    void setBoard();

    }
