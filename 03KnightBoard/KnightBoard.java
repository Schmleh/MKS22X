public class KnightBoard{
    public int[][] Board;

    public KnightBoard(int startingRows, int startingCols){
	Board = new int[startingRows][startingCols];
    }

    public String toString(){
    }
    //blank if you never called solve or when there is no solution

    public void solve() {
	for (int r = 0; r < Board.length; r ++){
	    for (int c = 0; c < Board[0].length; c ++){
		if (solveH(r, c, 1)) {
		    break;
		}
	    }
	}
    }

    private boolean solveH(int row ,int col, int level){
	if (Board[r][c] == 0){
	    Board[r][c] = level;
	    try{
		if (solveH(r + 1, c + 2, level + 1)){
		    return true;
		}
	    } catch (ArrayIndexOutOfBoundsException e) {}
	    try{
		if (solveH(r + 1, c - 2, level + 1)){
		    return true;
		}
	    } catch (ArrayIndexOutOfBoundsException e) {}
	    try{
		if (solveH(r + 2, c + 1, level + 1)){
		    return true;
		}
	    } catch (ArrayIndexOutOfBoundsException e) {}
	    try{
		if (solveH(r + 2, c - 1, level + 1)){
		    return true;
		}
	    } catch (ArrayIndexOutOfBoundsException e) {}
	    try{
		if (solveH(r - 1, c + 2, level + 1)){
		    return true;
		}
	    } catch (ArrayIndexOutOfBoundsException e) {}
	    try{
		if (solveH(r - 1, c - 2, level + 1)){
		    return true;
		}
	    } catch (ArrayIndexOutOfBoundsException e) {}
	    try{
		if (solveH(r - 2, c + 1, level + 1)){
		    return true;
		}
	    } catch (ArrayIndexOutOfBoundsException e) {}
	    try{
		if (solveH(r - 2, c - 1, level + 1)){
		    return true;
		}
	    } catch (ArrayIndexOutOfBoundsException e) {}
	}
    }
    // level is the # of the knight

    // public int[] findZeroes(int row, int col){
    // 	int[] spots = new int[8];
    // 	try{
    // 	    spots[0] =  Board[row + 1][col + 2];
    // 	} catch (ArrayIndexOutOfBoundsException e) {
    // 	    spots[0] = null;
    // 	}
    // 	try{
    // 	    spots[1] =  Board[row + 2][col + 1];
    // 	} catch (ArrayIndexOutOfBoundsException e) {
    // 	    spots[1] = null;
    // 	}
    // 	try{
    // 	    spots[2] =  Board[row + 2][col - 1];
    // 	} catch (ArrayIndexOutOfBoundsException e) {
    // 	    spots[2] = null;
    // 	}
    // 	try{
    // 	    spots[3] =  Board[row + 1][col - 2];
    // 	} catch (ArrayIndexOutOfBoundsException e) {
    // 	    spots[3] = null;
    // 	}
    // 	try{
    // 	    spots[4] =  Board[row - 1][col - 2];
    // 	} catch (ArrayIndexOutOfBoundsException e) {
    // 	    spots[4] = null;
    // 	}
    // 	try{
    // 	    spots[5] =  Board[row - 2][col + 1];
    // 	} catch (ArrayIndexOutOfBoundsException e) {
    // 	    spots[5] = null;
    // 	}
    // 	try{
    // 	    spots[6] =  Board[row - 2][col - 1];
    // 	} catch (ArrayIndexOutOfBoundsException e) {
    // 	    spots[6] = null;
    // 	}
    // 	try{
    // 	    spots[7] =  Board[row - 1][col + 2];
    // 	} catch (ArrayIndexOutOfBoundsException e) {
    // 	    spots[7] = null;
    // 	}
    // 	return spots;
    // }   
}
