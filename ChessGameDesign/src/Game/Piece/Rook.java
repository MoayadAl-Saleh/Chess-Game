package Game.Piece;

import Game.Board.IBoard;
import Game.ChessGame.Color;
import Game.ChessGame.Rules;
import Game.ChessGame.Type;
import Game.ChessGame.Spot;


public class Rook extends Piece
    {
    public Rook(Color color)
        {
        super(color);
        this.type = Type.ROOK;
        }

    @Override
    public boolean canMove(IBoard board, Spot start, Spot end)
        {
        return Rules.isRookMove(start,end);
        }
    }