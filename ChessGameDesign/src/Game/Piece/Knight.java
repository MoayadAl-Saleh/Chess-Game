package Game.Piece;

import Game.Board.IBoard;
import Game.ChessGame.Color;
import Game.ChessGame.Rules;
import Game.ChessGame.Type;
import Game.ChessGame.Spot;

public class Knight extends Piece
    {

    public Knight(Color color)
        {
        super(color);
        this.type = Type.KNIGHT ;
        }

    @Override
    public boolean canMove(IBoard board, Spot start, Spot end)
        {
        return Rules.isKnightMove(start,end);
        }
    }