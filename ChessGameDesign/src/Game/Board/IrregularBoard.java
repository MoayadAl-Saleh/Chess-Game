package Game.Board;

import Game.Piece.Piece;
import Game.ChessGame.Spot;

public class IrregularBoard implements IBoard
    {
    private Spot[][] boxes;
    private final int x;
    private final int y;

    public IrregularBoard(int x, int y)
        {
        this.x = x;
        this.y = y;
        }

    @Override
    public Spot getBox(int x, int y) throws Exception
        {
        return null;
        }

    @Override
    public void setBox(int x, int y, Piece piece) throws Exception
        {

        }

    @Override
    public void setBoard()
        {
        boxes = new Spot[x][y];
        //add Private Structure for IrregularBoard
        }
    }
