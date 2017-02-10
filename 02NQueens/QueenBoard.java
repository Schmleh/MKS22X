public class QueenBoard{
    private int[][]board;
    private int solutionCount;
    
    public QueenBoard(int size){
	board = new int[size][size];
	solutionCount = -1;
    }

    /**
     *precondition: board is filled with 0's only.
     *@return false when the board is not solveable. true otherwise.
     *postcondition: 
     *if false: board is still filled with 0's
     *if true: board is filled with the 
     *final configuration of the board after adding 
     *all n queens. Uses solveH
     */
    public boolean solve()
    {
	return solveH(0);
    }

    private boolean solveH(int col){
	return false;
    }

    public void countSolutions(){
	solutionCount = 0;
	for (int r = 0; r < board.length; r++){
	    countHelp(0,r);
	}
    }

    public void countHelp(int col, int row){
	for (int r = 0; r < board.length; r++){
	    board[r][col] += 1;
	}
	for (int c = 0; c < board.length; c++){
	    board[row][c] += 1;
	}
	//diagonals
	board[row][col] = -1;
	if (col + 1 == board.length){
	    solutions += 1;
	} else {
	    if findZeroes
    }

    public int[] findZeroes(int col){
	int[] column = new int[board.length];
	for (int r = 0; r < board.length; r++){
	    zeroes[r] = board[r][col];
	}
	return column;
    }

    /**
     *@return the number of solutions found, or -1 if the board was never solved.
     *The board should be reset after this is run.    
     */
    public int getSolutionCount(){
	return solutionCount;
    }
    /**toString
     *and all nunbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     */
    public String toString(){
    	return "";
    }
}
