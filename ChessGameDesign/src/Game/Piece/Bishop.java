package Game.Piece;

import Game.Board.IBoard;
import Game.ChessGame.Color;
import Game.ChessGame.Rules;
import Game.ChessGame.Type;
import Game.ChessGame.Spot;



public class Bishop extends Piece
    {
    public Bishop(Color color)
        {
        super(color);
        this.type= Type.BISHOP;
        }

    @Override
    public boolean canMove(IBoard board, Spot start, Spot end)
        {
        return Rules.isBishopMove(start,end);
        }



    }