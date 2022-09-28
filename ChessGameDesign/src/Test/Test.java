package Test;

import Game.ChessGame.ChessGame;

import java.util.Scanner;

public class Test
    {
    public static void main(String[] args) throws Exception
        {
        ChessGame game = new ChessGame("moayad", "ali");
        String move;
        Scanner sc = new Scanner(System.in);
        while (!game.isDone())
            {
            if (game.isWhiteTurn())
                {
                System.out.println("The White player's turn!");
                move = sc.nextLine();
                game.playWhite(move);
                }
            else
                {
                System.out.println("The Black player's turn!");
                move = sc.nextLine();
                game.playBlack(move);
                }
            }
        game.printWinnerName();
        }

    }
