package edu.jsu.mcis;

public class TicTacToeModel {
    
    private Mark[][] board; /* Game board */
    private boolean xTurn;  /* True if X is current player */
    private int width;      /* Size of game board */
    
    /* ENUM TYPE DEFINITIONS */
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY("-");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a TIE,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("TIE"), 
        NONE("NONE");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        this(TicTacToe.DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create board (width x width) as a 2D Mark array */
        
        board = new Mark[width][width];

        /* Initialize board by filling every square with empty marks */
        
        // INSERT YOUR CODE HERE
        for(int i = 0; i< width; i++){
            for(int x = 0; x< width; x++){
                board[i][x] = Mark.EMPTY;
            }

        }
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Use "isValidSquare()" to check if the specified location is in range,
           and use "isSquareMarked()" to see if the square is empty!  If the
           specified location is valid, make a mark for the current player, then
           toggle "xTurn" from true to false (or vice-versa) to switch to the
           other player before returning TRUE.  Otherwise, return FALSE. */
        
        // INSERT YOUR CODE HERE
        
        if(isValidSquare(row,col)){
            if(!isSquareMarked(row, col)){
                if(!xTurn){
                    board[row][col] = Mark.O;
                }
                if(xTurn){
                    board[row][col] = Mark.X;
                }  
                xTurn = !xTurn;
               
                return true;
            }
            else{
                return false;
            }
        }
    
        else{
            return false;
        }
        
    }
	
    private boolean isValidSquare(int row, int col) {
        
        /* Return TRUE if the specified location is within the bounds of the board */
        
        // INSERT YOUR CODE HERE
            if((row<0 || col < 0)||(row >= getWidth() || col >=getWidth())){
             return true; 
            }
            else{
                return false;
            }
        
    }
	
    private boolean isSquareMarked(int row, int col) {
        
        /* Return TRUE if the square at specified location is marked */
        
        // INSERT YOUR CODE HERE
        return(board[row][col] != Mark.EMPTY);
        
            
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return the mark from the square at the specified location */
        
        // INSERT YOUR CODE HERE
        return board[row][col];

        
            
    }
	
    public Result getResult() {
        
        /* Call "isMarkWin()" to see if X or O is the winner, if the game is a
           TIE, or if the game is not over.  Return the corresponding Result
           value */
        
        // INSERT YOUR CODE HERE
        if (isTie()){
            return Result.TIE;
        }
        else {
            if (xTurn) {
                if (isMarkWin(Mark.O)){
                    return Result.O;
                }
                else {
                    return Result.NONE;
                }
            }
            else {
                if (isMarkWin(Mark.X)){
                    return Result.X;
                }
                else {
                    return Result.NONE;
                }
            }
        }
        
    }
        
        
    
	
    private boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
        
        // INSERT YOUR CODE HERE
        boolean diagonalONE = true;
        boolean winnerRow = false;
        boolean diagonalTWO = true;
        boolean winnerCol = false;
        for (int i = 0; i < getWidth(); i++) {
            boolean winnerR = true;

            for (int a = 0; a < getWidth(); a++) {
                if (board[a][i] != mark){
                    winnerR = false;
                }
            }
            if (winnerR) {
                winnerRow = true;
            }
        }

        for (int b = 0; b < getWidth(); b++) {
            boolean winnerC = true;

            for (int c = 0; c < getWidth(); c++) {
                if (board[b][c] != mark) {
                    winnerC = false;
                }
            }
            if (winnerC) {
                winnerCol = true;
            }
        }

        for (int d = 0; d < getWidth(); d++){
            if (board[d][d] != mark) { 
                diagonalONE = false; 
            }
        }
        for(int e = 0; e< getWidth(); e++){
            if(board[(getWidth() - 1) - e][e] != mark){
                diagonalTWO = false;
            }
        }

        if(winnerCol|| winnerRow || diagonalONE || diagonalTWO){
            return true;
        }
        else{
            return false;
        }

    }
	
    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */
        boolean isMarked = false;

        for(int i=0; i<getWidth(); i++){
            for(int x=0; x<getWidth(); x++){
                if(board[i][x] == Mark.EMPTY ){
                    isMarked = true;
                }
            
            }
        }
        if(isMarked){
            return false;
        }
        else{
            return true;
        }
    
    }

    public boolean isGameover() {
        
        /* Return TRUE if the game is over */
        
        return (Result.NONE != getResult());
        
    }

    public boolean isXTurn() {
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth() {
        
        /* Getter for width */
        
        return width;
        
    }
    
    @Override
    public String toString() {
        
        StringBuilder output = new StringBuilder("  ");
        
        /* Output the board contents as a string (see examples) */
        int boardnum = 0;
        // INSERT YOUR CODE HERE
        output.append("\n");
        for (int x = 0; x< getWidth(); x++){
            output.append(boardnum + " ");
            for (int y = 0; y < getWidth(); y++){
                output.append(board[x][y]);
            }
            output.append("\n");
            boardnum++;
        }



        for(int i=0; i < width; ++i){
            output.append(i);
        }
        return output.toString();
        
    }
    
}
