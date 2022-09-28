package Game.Piece;

import Game.Board.IBoard;
import Game.ChessGame.Color;
import Game.ChessGame.Rules;
import Game.ChessGame.Type;
import Game.ChessGame.Spot;
import Game.ChessGame.Move;

import java.util.Scanner;

public class Pawn extends Piece
    {
    Scanner sc = new Scanner(System.in);

    public Pawn(Color color)
        {
        super(color);
        this.type = Type.PAWN ;
        }

    public boolean canMove(IBoard board, Spot start, Spot end) throws Exception
        {
        if (Rules.isPromoting(start, end))
            {
            System.out.println("Pleas click to this later >>>  Q = Queen || R = Rook || B = Bishop || K = Knight ");
            String promoting = sc.next();
            Move.doPromoting(start,this.color,promoting);
            return true;
            }
        if (Rules.isEnPassant(board, start, end))
            {
            Move.doEnPassant(board, start, end);
            return true;
            }
        return Rules.isPawnMove(start, end);
        }

    }
