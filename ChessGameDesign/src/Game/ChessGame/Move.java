package Game.ChessGame;

import Game.Board.IBoard;
import Game.Piece.*;

import java.util.Objects;


public class Move
    {
    public static void domove(IBoard board, Spot start, Spot end) throws Exception
        {
        board.setBox(end.getX(), end.getY(), start.getPiece());
        board.setBox(start.getX(), start.getY(), null);
        }

    public static void doCastling(IBoard board, Spot start, Spot end, Color color) throws Exception
        {
        if (end.getY() == 2 && color == Color.WHITE)//left white
            {
            board.setBox(0, 3, board.getBox(0, 0).getPiece());
            board.setBox(0, 0, null);
            }
        else if (end.getY() == 6 && color == Color.WHITE)//right white
            {
            board.setBox(0, 5, board.getBox(0, 7).getPiece());
            board.setBox(0, 7, null);
            }
        if (end.getY() == 6 && color == Color.BLACK)// right black
            {
            board.setBox(7, 5, board.getBox(7, 7).getPiece());
            board.setBox(7, 7, null);
            }
        else if (end.getY() == 2 && color == Color.BLACK)// left black
            {
            board.setBox(7, 3, board.getBox(7, 0).getPiece());
            board.setBox(7, 0, null);
            }
        }

    public static void doEnPassant(IBoard board, Spot start, Spot end) throws Exception
        {
        if (start.getPiece().getColor() == Color.WHITE)
            {
            board.setBox(end.getX() - 1, end.getY(), null);
            }
        else
            {
            board.setBox(end.getX() + 1, end.getY(), null);
            }
        }

    public static void doPromoting(Spot start , Color color , String promoting)
        {
        if (Objects.equals(promoting, "Q"))
            {
            start.setPiece(new Queen(color));
            }
        if (Objects.equals(promoting, "R"))
            {
            start.setPiece(new Rook(color));
            }
        if (Objects.equals(promoting, "B"))
            {
            start.setPiece(new Bishop(color));
            }
        if (Objects.equals(promoting, "K"))
            {
            start.setPiece(new Knight(color));
            }
        }

    }