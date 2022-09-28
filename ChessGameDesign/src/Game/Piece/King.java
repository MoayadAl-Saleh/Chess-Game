package Game.Piece;

import Game.Board.IBoard;
import Game.ChessGame.Color;
import Game.ChessGame.Rules;
import Game.ChessGame.Type;
import Game.ChessGame.Spot;
import Game.ChessGame.Move;

public class King extends Piece
    {
    public King(Color color)
        {
        super(color);
        this.type = Type.KING ;
        }

    @Override
    public boolean canMove(IBoard board, Spot start, Spot end) throws Exception
        {
        if (Rules.isCastling(board ,start, end))
            {
            Move.doCastling(board,start,end ,this.color);
            return true ;
            }
        return Rules.isKingMove(start, end) ;
        }


    }