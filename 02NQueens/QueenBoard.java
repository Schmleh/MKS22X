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
    public boolean solve(){
	for (int r = 0; r < board.length; r++){
	    if (solveH(0,r)){
		return true;
	    }
	}
	return false;
    }

    private boolean solveH(int col, int row){
	for (int r = 0; r < board.length; r++){
	    board[r][col] += 1;
	}
	for (int c = 0; c < board.length; c++){
	    board[row][c] += 1;
	}
	for (int c = col, r = row; c < board.length && r < board.length; c++, r++){
	    board[r][c] += 1;
	}
	for (int c = col, r = row; c < board.length && r >= 0; c++, r--){
	    board[r][c] += 1;
	}
	for (int c = col, r = row; c >= 0 && r < board.length; c--, r++){
	    board[r][c] += 1;
	}
	for (int c = col, r = row; c >= 0 && r >= 0; c--, r--){
	    board[r][c] += 1;
	}
	board[row][col] = -1;
	if (col + 1 == board.length){
	    return true;
	} else {
	    int[] column = findZeroes(col + 1);
	    for (int r = 0; r < board.length; r ++){
		if (column[r] == 0){
		    if (solveH(col + 1, r)){
			return true;
		    }
		}
	    }
	}
	for (int r = 0; r < board.length; r++){
	    board[r][col] -= 1;
	}
	for (int c = 0; c < board.length; c++){
	    board[row][c] -= 1;
	}
	for (int c = col, r = row; c < board.length && r < board.length; c++, r++){
	    board[r][c] -= 1;
	}
	for (int c = col, r = row; c < board.length && r >= 0; c++, r--){
	    board[r][c] -= 1;
	}
	for (int c = col, r = row; c >= 0 && r < board.length; c--, r++){
	    board[r][c] -= 1;
	}
	for (int c = col, r = row; c >= 0 && r >= 0; c--, r--){
	    board[r][c] -= 1;
	}
	board[row][col] = 0;
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
	for (int c = col, r = row; c < board.length && r < board.length; c++, r++){
	    board[r][c] += 1;
	}
	for (int c = col, r = row; c < board.length && r >= 0; c++, r--){
	    board[r][c] += 1;
	}
	for (int c = col, r = row; c >= 0 && r < board.length; c--, r++){
	    board[r][c] += 1;
	}
	for (int c = col, r = row; c >= 0 && r >= 0; c--, r--){
	    board[r][c] += 1;
	}
	board[row][col] = -1;
	if (col + 1 == board.length){
	    solutionCount += 1;
	} else {
	    int[] column = findZeroes(col + 1);
	    for (int r = 0; r < board.length; r ++){
		if (column[r] == 0){
		    countHelp(col + 1, r);
		}
	    }
	}
	for (int r = 0; r < board.length; r++){
	    board[r][col] -= 1;
	}
	for (int c = 0; c < board.length; c++){
	    board[row][c] -= 1;
	}
	for (int c = col, r = row; c < board.length && r < board.length; c++, r++){
	    board[r][c] -= 1;
	}
	for (int c = col, r = row; c < board.length && r >= 0; c++, r--){
	    board[r][c] -= 1;
	}
	for (int c = col, r = row; c >= 0 && r < board.length; c--, r++){
	    board[r][c] -= 1;
	}
	for (int c = col, r = row; c >= 0 && r >= 0; c--, r--){
	    board[r][c] -= 1;
	}
	board[row][col] = 0;
    }

    public int[] findZeroes(int col){
	int[] column = new int[board.length];
	for (int r = 0; r < board.length; r++){
	    column[r] = board[r][col];
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
	String chessBoard = "";
	for (int r = 0; r < board.length; r ++){
	    for (int c = 0; c < board.length; c ++){
		if (board[r][c] == -1){
		    chessBoard += "Q ";
		} else {
		    chessBoard += "_ ";
		}
	    }
	    chessBoard += "\n";
	}
    	return chessBoard;
    }

    // public static void main(String[] args){
    // 	QueenBoard one = new QueenBoard(1);
    // 	QueenBoard two = new QueenBoard(2);
    // 	QueenBoard three = new QueenBoard(3);
    // 	QueenBoard four = new QueenBoard(4);
    // 	QueenBoard five = new QueenBoard(5);
    // 	QueenBoard six = new QueenBoard(6);
    // 	QueenBoard seven = new QueenBoard(7);
    // 	QueenBoard eight = new QueenBoard(8);
    // 	one.countSolutions();
    // 	two.countSolutions();
    // 	three.countSolutions();
    // 	four.countSolutions();
    // 	five.countSolutions();
    // 	six.countSolutions();
    // 	seven.countSolutions();
    // 	eight.countSolutions();
    // 	System.out.println(one.getSolutionCount());
    // 	System.out.println(two.getSolutionCount());
    // 	System.out.println(three.getSolutionCount());
    // 	System.out.println(four.getSolutionCount());
    // 	System.out.println(five.getSolutionCount());
    // 	System.out.println(six.getSolutionCount());
    // 	System.out.println(seven.getSolutionCount());
    // 	System.out.println(eight.getSolutionCount());
    // 	System.out.println(one.solve());
    // 	System.out.println(two.solve());
    // 	System.out.println(three.solve());
    // 	System.out.println(four.solve());
    // 	System.out.println(five.solve());
    // 	System.out.println(six.solve());
    // 	System.out.println(seven.solve());
    // 	System.out.println(eight.solve());
    // 	System.out.println(one.toString());
    // 	System.out.println(two.toString());
    // 	System.out.println(three.toString());
    // 	System.out.println(four.toString());
    // 	System.out.println(five.toString());
    // 	System.out.println(six.toString());
    // 	System.out.println(seven.toString());
    // 	System.out.println(eight.toString());
    // }
    
}
