package edu.jsu.mcis;

import java.util.Scanner;

public class TicTacToeView {
    
    private final Scanner keyboard;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView() {
        
        /* Initialize scanner (for console keyboard) */
        
        keyboard = new Scanner(System.in);
        
    }
	
    public TicTacToeMove getNextMove(boolean isXTurn) {
        
        /* Prompt the player to enter the row and the column of their next move.
           Return as a TicTacToeMove object. */
        System.out.println("Enter the row of your next move");
        // INSERT YOUR CODE HERE

        int row = keyboard.nextInt();
        System.out.println("Enter the column of your next move");
        int col = keyboard.nextInt();
        
        if ((row >= 0 && col >= 0) && (row <= 2 && col <= 2)){
            TicTacToeMove mover = new TicTacToeMove(row, col);

            return mover;
        }
        else {
            showInputError();
            return getNextMove(isXTurn);
        }

        

    }

    public void showInputError() {

        System.out.println("Entered location is invalid, already marked, or out of bounds.");

    }

    public void showResult(String r) {

        System.out.println(r + "!");

    }
    
    public void showBoard(String board) {
        
        System.out.println("\n\n" + board);
        
    }
	
}
