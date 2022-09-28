package Game.ChessGame;

import Game.Board.IBoard;
import Game.Piece.Piece;

import java.util.Objects;

public class Rules
    {

    // basics move
    public static boolean isKingMove(Spot start, Spot end)
        {
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        return ((x * y == 0) || (x / y == 1)) && (x == 1 || y == 1);
        }

    public static boolean isKnightMove(Spot start, Spot end)
        {
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        return x * y == 2;
        }

    public static boolean isRookMove(Spot start, Spot end)
        {
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        return x * y == 0;
        }

    public static boolean isQueenMove(Spot start, Spot end)
        {
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        return (x * y == 0) || (x / y == 1);
        }

    public static boolean isPawnMove(Spot start, Spot end)
        {
        int x = start.getX() - end.getX();
        int y = start.getY() - end.getY();
        if (start.getPiece().getColor() == Color.WHITE)
            {
            return (x == -1 && y == 0) || (start.getX() == 1 && x == -2 && y == 0) || (x == -1 && y == 1);
            }
        else
            {
            return (x == 1 && y == 0) || (start.getX() == 6 && x == 2 && y == 0) || (x == 1 && y == -1);
            }
        }

    public static boolean isBishopMove(Spot start, Spot end)
        {
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        return (x / y) == 1;
        }

    // special move
    public static boolean isPromoting(Spot start, Spot end)
        {
        if (start.getPiece().getColor() == Color.WHITE)
            {
            return end.getX() == 7;
            }
        else
            {
            return end.getX() == 0;
            }
        }

    public static boolean isCastling(IBoard board, Spot start, Spot end) throws Exception
        {
        if (start.getPiece().getColor() == Color.WHITE)
            {
            if (board.getBox(0, 7).getPiece().getType() == Type.ROOK || board.getBox(0, 6).getPiece() == null || board.getBox(0, 5).getPiece() == null)
                {
                return true;
                }
            else
                return board.getBox(0, 0).getPiece().getType() == Type.ROOK || board.getBox(0, 1).getPiece() == null || board.getBox(0, 2).getPiece() == null || board.getBox(0, 3).getPiece() == null;
            }
        else
            {
            if (board.getBox(7, 7).getPiece().getType() == Type.ROOK || board.getBox(7, 6).getPiece() == null || board.getBox(7, 5).getPiece() == null)
                {
                return true;
                }
            else
                return board.getBox(7, 0).getPiece().getType() == Type.ROOK || board.getBox(7, 1).getPiece() == null || board.getBox(7, 2).getPiece() == null || board.getBox(7, 3).getPiece() == null;
            }
        }

    public static boolean isEnPassant(IBoard board, Spot start, Spot end) throws Exception
        {
        Type type = start.getPiece().getType();
        Piece piece = null;
        Piece piece2 = null;
        if (0 <= start.getY() - 1)
            {
            piece = board.getBox(start.getX(), start.getY() - 1).getPiece();
            }
        if (start.getY() + 1 <= 7)
            {
            piece2 = board.getBox(start.getX(), start.getY() + 1).getPiece();
            }

        if (piece != null)
            {
            if (start.getPiece().getColor() != piece.getColor())
                {
                if (Objects.equals(type, piece.getType()))
                    {
                    return true;
                    }
                }
            }

        if (piece2 != null)
            {
            if (start.getPiece().getColor() != piece2.getColor())
                {
                return Objects.equals(type, piece2.getType());
                }
            }

        return false;
        }

    // add any rules you want


    }
