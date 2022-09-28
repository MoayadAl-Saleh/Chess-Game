package Game.Board;

import Game.ChessGame.Color;
import Game.Piece.Piece;
import Game.ChessGame.Spot;
import Game.Piece.*;

public class RegularBoard implements IBoard
    {
    private Spot[][] boxes;

    public RegularBoard()
        {
        this.setBoard();
        }

    @Override
    public Spot getBox(int x, int y) throws Exception
        {

        if (x < 0 || x > 7 || y < 0 || y > 7)
            {
            throw new Exception("Index out of bound");
            }

        return boxes[x][y];
        }

    @Override
    public void setBox(int x, int y, Piece piece)
        {
        boxes[x][y] = new Spot(x, y, piece);
        }

    @Override
    public void setBoard()
        {
        boxes = new Spot[8][8];
        // initialize white pieces
        boxes[0][0] = new Spot(0, 0, new Rook(Color.WHITE));
        boxes[0][1] = new Spot(0, 1, new Knight(Color.WHITE));
        boxes[0][2] = new Spot(0, 2, new Bishop(Color.WHITE ));
        boxes[0][3] = new Spot(0, 3, new Queen(Color.WHITE));
        boxes[0][4] = new Spot(0, 4, new King(Color.WHITE));
        boxes[0][5] = new Spot(0, 5, new Bishop(Color.WHITE ));
        boxes[0][6] = new Spot(0, 6, new Knight(Color.WHITE));
        boxes[0][7] = new Spot(0, 7, new Rook(Color.WHITE));
        //...
        for (int i = 0; i < 8; i++)
            {
            boxes[1][i] = new Spot(1, i, new Pawn(Color.WHITE));
            }
        //...

        // initialize black pieces
        boxes[7][0] = new Spot(7, 0, new Rook(Color.BLACK));
        boxes[7][1] = new Spot(7, 1, new Knight(Color.BLACK));
        boxes[7][2] = new Spot(7, 2, new Bishop(Color.BLACK));
        boxes[7][3] = new Spot(7, 3, new Queen(Color.BLACK));
        boxes[7][4] = new Spot(7, 4, new King(Color.BLACK));
        boxes[7][5] = new Spot(7, 5, new Bishop(Color.BLACK));
        boxes[7][6] = new Spot(7, 6, new Knight(Color.BLACK));
        boxes[7][7] = new Spot(7, 7, new Rook(Color.BLACK));
        //...
        for (int i = 0; i < 8; i++)
            {
            boxes[6][i] = new Spot(6, i, new Pawn(Color.BLACK));
            }
        //...

        // initialize remaining boxes without any Game.piece
        for (int i = 2; i < 6; i++)
            {
            for (int j = 0; j < 8; j++)
                {
                boxes[i][j] = new Spot(i, j, null);
                }
            }
        }

    }