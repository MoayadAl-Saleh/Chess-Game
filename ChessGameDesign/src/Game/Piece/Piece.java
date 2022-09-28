package Game.Piece;


import Game.Board.IBoard;
import Game.ChessGame.Color;
import Game.ChessGame.Spot;
import Game.ChessGame.Type;

public abstract class Piece
    {

    protected Color color ;
    protected Type type ;

    public Piece(Color color )
        {
        this.color=color;
        }

    public Type getType()
        {
        return type;
        }

    public Color getColor()
        {
        return color;
        }

    public abstract boolean canMove(IBoard board, Spot start, Spot end) throws Exception;


    }