public class KnightBoard{
    public int[][] Board;
    public static final int[] rows = 

    public KnightBoard(int startingRows, int startingCols){
	Board = new int[startingRows][startingCols];
    }

    public String toString(){
	int count = 0;
	for (int row = 0; row < Board.length; row ++){
	    for (int col = 0; col < Board[0].length && (Board[row][col] != 0); col ++){
		count ++;
	    }
	}
	if (count == (Board.length * Board[0].length)){
	    String meh = "";
	    if (Board.length * Board[0].length < 10){
		for (int r = 0; r < Board.length; r ++){
		    for (int c = 0; c < Board[0].length; c++){
			meh += Board[r][c];
			meh += " ";
		    }
		    meh += "\n";
		}
	    }else {
		for (int r = 0; r < Board.length; r ++){
		    for (int c = 0; c < Board[0].length; c++){
			if (Board[r][c] < 10){
			    meh += " ";
			}
			meh += Board[r][c];
			meh += " ";
		    }
		    meh += "\n";
		}
	    }
	    return meh;
	}else {
	    return "";
	}
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

    private boolean solveH(int r ,int c, int level){
	if (Board[r][c] == 0){
	    Board[r][c] = level;
	    int count = 0;
	    for (int row = 0; row < Board.length; row ++){
		for (int col = 0; col < Board[0].length && (Board[row][col] != 0); col ++){
		    count ++;
		}
	    }
	    if (count == (Board.length * Board[0].length)){
		return true;
	    }
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
	    Board[r][c] = 0;
	    return false;
	}
	return false;
    }

    private boolean solveH(int r ,int c, int level){
	if (Board[r][c] == 0){
	    Board[r][c] = level;
	    int count = 0;
	    for (int row = 0; row < Board.length; row ++){
		for (int col = 0; col < Board[0].length && (Board[row][col] != 0); col ++){
		    count ++;
		}
	    }
	    if (count == (Board.length * Board[0].length)){
		return true;
	    }
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
	    Board[r][c] = 0;
	    return false;
	}
	return false;
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
    //  }

    public static void main(String[] args){
	KnightBoard two = new KnightBoard(2,2);
        two.solve();
        System.out.println(two.toString());
	KnightBoard five = new KnightBoard(5,5);
	five.solve();
        System.out.println(five.toString());
	KnightBoard six = new KnightBoard(6,6);
	six.solve();
        System.out.println(six.toString());
	KnightBoard seven = new KnightBoard(7,7);
	seven.solve();
        System.out.println(seven.toString());
	KnightBoard eight = new KnightBoard(8,8);
        eight.solve();
        System.out.println(eight.toString());
    }
}
