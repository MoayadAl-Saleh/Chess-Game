package Game.Piece;

import Game.Board.IBoard;
import Game.ChessGame.Color;
import Game.ChessGame.Rules;
import Game.ChessGame.Type;
import Game.ChessGame.Spot;

public class Queen extends Piece
    {
    public Queen(Color color)
        {
        super(color);
        this.type = Type.QUEEN ;
        }

    @Override
    public boolean canMove(IBoard board, Spot start, Spot end)
        {
        return Rules.isQueenMove(start,end) ;// Add any rules you want
        }

    }
