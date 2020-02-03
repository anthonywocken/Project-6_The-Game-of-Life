/**
 * Class Life is the model (data structure) that holds and updates the
 * status of our cellular automaton game.  It provides methods to initialize
 * the game (done automatically when the game is first created), update one generation
 * and access the game status, which can be used by client code to display
 * the game board and the state of the game
 * 
 * @author  Barbara Goldner, based on work by Hal Perkins.  

 */
public class LifeModel {
    // public constants

    /** Number of rows/columns in Life Grid  */
    public static final int NROWSCOLS = 23; 


    // private instance variables
    private LifeState[][] board;      // game board
    private LifeState[][] board2;      // next generation game board
    private int generations;   // how many generations have happened
    private int numAdjacentAlive;
    private int numAdjacentDead;


    /** Construct and initialize new game board
     */
    public LifeModel() {
        board = new LifeState[NROWSCOLS][NROWSCOLS];
        board2 = new LifeState[NROWSCOLS][NROWSCOLS];
        newGame();
    }

    /** initialize new game
     * */
    public void newGame() {
        
        for (int row = 0; row < LifeModel.NROWSCOLS; row++) {
            for (int col = 0; col < LifeModel.NROWSCOLS; col++) {
                if(row == 10 & col == 15 | row == 14 & col == 4 |
                    row == 6 & col == 9 | row == 18 & col == 5) {
                    board[row][col] = LifeState.ALIVE;
                } else {
                    board[row][col] = LifeState.DEAD;
                }
            }
        }
        /*****************************************************
        *  STUDENTS:  setup your initial Life environment here
        *****************************************************/
     
    }
    
    /** Returns the number of generations
     * @return The number of generations that have been run so far.
     */
    public int getGenerationCount() {
        return generations;
    }

    /** Return the current state of game board cell at given row/column
     *  (Squares numbered from 0 to NROWSCOLS-1). 
     *  @throws IllegalArgumentException for bad row/col 
     *  @param row The row of the deisred cell.
     *  @param col The column of the desired cell.
     */
    public LifeState getCell(int row, int col) {
        
        
        if(board[row][col] == LifeState.ALIVE) {
            return LifeState.ALIVE;
        } else if (board[row][col] == LifeState.DEAD){
            return LifeState.DEAD;
        }
       
        
        return LifeState.DEAD;  // stub value
       /***************************************
        *  STUDENTS: fix this 
        **************************************/
    }
    
    
    /** Process one life cycle of the cellular automaton
     * 
     */
    public void oneCycle() {
        for (int row = 1; row < NROWSCOLS - 1; row++) {
            for (int col = 1; col < NROWSCOLS - 1; col++) {
                numAdjacentAlive = 0;
                numAdjacentDead = 0;
                for (int rs = row - 1; rs <= row + 1; rs++) {
                    for (int cs = col - 1; cs <= col + 1; cs++) {
                        if (rs != row & cs != col) {
                            if (board[rs][cs] == LifeState.ALIVE) {
                                numAdjacentAlive += 1;
                            } else if (board[rs][cs] == LifeState.DEAD) {
                                numAdjacentDead += 1;
                            }
                        }
                    }
                }
                if (board[row][col] == LifeState.DEAD & numAdjacentAlive == 3) {
                    board2[row][col] = LifeState.ALIVE;
                } else if (board[row][col] == LifeState.DEAD & numAdjacentAlive != 3) {
                    board2[row][col] = LifeState.DEAD;
                } else if (board[row][col] == LifeState.ALIVE & numAdjacentAlive == 2) {
                    board2[row][col] = LifeState.ALIVE;
                } else if (board[row][col] == LifeState.ALIVE & numAdjacentAlive == 0
                                                || numAdjacentAlive == 1) {
                    board2[row][col] = LifeState.DEAD;
                } else if (board[row][col] == LifeState.ALIVE & numAdjacentAlive >= 4) {
                    board2[row][col] = LifeState.DEAD;
                }
            }
        }
        for (int col = 0; col < NROWSCOLS; col++) {
            board2[0][col] = LifeState.DEAD;
            board2[0][NROWSCOLS - 1] = LifeState.DEAD;
        }
        for (int row = 0; row < NROWSCOLS; row++) {
            board2[row][0] = LifeState.DEAD;
            board2[row][NROWSCOLS - 1] = LifeState.DEAD;
        }
        
        for (int row = 0; row < NROWSCOLS; row++) {
            for (int col = 0; col < NROWSCOLS; col++) {
                board[row][col] = board2[row][col];
            }
        }
        
        
        //board = board2;
        
        
        
        
        
       /***************************************
        *  STUDENTS: implement this 
        **************************************/
    }

}
