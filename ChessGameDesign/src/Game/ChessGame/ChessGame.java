package Game.ChessGame;

import Game.Board.IBoard;
import Game.Board.IrregularBoard;
import Game.Board.RegularBoard;

public class ChessGame implements IChessGame
    {
    private Spot start;
    private Spot end;
    private Spot kingW = null;
    private Spot kingB = null;
    private final IBoard board;
    private String Winner = null;
    private final String whitePlayer;
    private final String blackPlayer;
    private boolean formatCorrect;
    private int order = 0;

    public ChessGame(String W, String B, int x, int y)
        {
        this.whitePlayer = W;
        this.blackPlayer = B;
        this.board = new IrregularBoard(x, y);
        }

    public ChessGame(String W, String B) throws Exception
        {
        this.whitePlayer = W;
        this.blackPlayer = B;
        this.board = new RegularBoard();
        // save location king .
        kingW = board.getBox(0, 4);
        kingB = board.getBox(7, 4);
        }

    @Override
    public boolean isDone()
        {
        return Winner != null;
        }

    @Override
    public boolean isWhiteTurn()
        {
        return order % 2 == 0;
        }

    @Override
    public boolean isBlackTurn()
        {
        return order % 2 == 1;
        }

    @Override
    public void playWhite(String move) throws Exception
        {
        setTheFormat(move);
        if (formatCorrect && isMoveCorrect(Color.WHITE))
            {
            order++;
            if (isCheckmateB())
                {
                System.out.println("Black king's is checkmate !!");
                }
            }
        else
            {
            System.out.println("Please enter a valid move ");
            }
        }

    private boolean isCheckmateW()
        {
        return false;
        }

    @Override
    public void playBlack(String move) throws Exception
        {
        setTheFormat(move);
        if (formatCorrect && isMoveCorrect(Color.BLACK))
            {
            order++;
            if (isCheckmateW())
                {
                System.out.println("White king's is checkmate !!");
                }
            }
        else
            {
            System.out.println("Please enter a valid move ");
            }
        }

    private boolean isCheckmateB()
        {
        return false;
        }

    private void setTheFormat(String move) throws Exception
        {
        String[] s = move.split(" ");
        formatCorrect = isFormatValid(s);
        if (formatCorrect)
            {
            start = board.getBox(s[1].charAt(1) - '1', s[1].charAt(0) - 65);
            end = board.getBox(s[2].charAt(1) - '1', s[2].charAt(0) - 65);
            }
        }

    private boolean isFormatValid(String[] s)
        {
        return s.length == 3 && s[1].charAt(0) >= 'A' && s[1].charAt(0) <= 'H' && s[2].charAt(0) >= 'A' && s[2].charAt(0) <= 'H' && s[1].charAt(1) >= '1' && s[1].charAt(1) <= '8' && s[2].charAt(1) >= '1' && s[2].charAt(1) <= '8';
        }

    private boolean isMoveCorrect(Color color) throws Exception
        {
        if (start.getPiece() == null)//is the start spot empty
            {
            System.out.println("There is no piece in the start position ( please try again !! ) ");
            return false;
            }
        if (start.getPiece().getColor() != color)
            {
            System.out.println("This piece isn't yours ( please try again !! )");
            return false;
            }
        if (end.getPiece() != null && end.getPiece().getColor() == start.getPiece().getColor())
            {
            System.out.println("Can't kill your friend !!");
            return false;
            }
        if (!start.getPiece().canMove(board, start, end))
            {
            System.out.println("The move is invalid  ( please try again !! )");
            return false;
            }
        Move.domove(board, start, end);
        printBoard(board);
        checkWinner(color);
        return true;
        }

    private void printBoard(IBoard board) throws Exception
        {
        String type  ;
        for (int i = 7; i >= 0; i--)
            {
            System.out.print(i + 1 + " ");
            for (int j = 0; j <= 7; j++)
                {
                if (board.getBox(i, j).getPiece() != null)
                    {
                    type = board.getBox(i, j).getPiece().getType().name();
                    System.out.print(type.charAt(0)+""+type.charAt(1)+ "  ");
                    }
                else
                    {
                    System.out.print("##  ");
                    }
                }
            System.out.println();
            }
        System.out.print("  ");
        for (int i = 0; i < 8; i++)
            {
            int a = 'A' + i;
            System.out.print((char) a + "   ");
            }
        System.out.println();
        }

    private void checkWinner(Color color)
        {
        if (end.equals(kingW) || end.equals(kingB))
            {
            if (color == Color.WHITE)
                {
                Winner = whitePlayer;
                }
            else
                {
                Winner = blackPlayer;
                }
            }
        }

    @Override
    public void printWinnerName()
        {
        System.out.println("The winner is = " + Winner);
        }

    }
