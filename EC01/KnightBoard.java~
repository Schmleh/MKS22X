<<<<<<< HEAD:KnightBoard.java
public class KnightBoard{
    public int[][] Board;
    public static int[] rChanges = {1,1,2,2,-1,-1,-2,-2};
    public static int[] cChanges = {2,-2,1,-1,2,-2,1,-1};
    

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
    
    public void solve() {
	for (int r = 0; r < Board.length; r ++){
	    for (int c = 0; c < Board[0].length; c ++){
		Board[r][c] = 1;
		if (solveH(r, c, 1)) {
		    break;
		}
		Board[r][c] = 0;
	    }
	}
    }
    
    private boolean solveH(int r ,int c, int level){
	int count = 0;
	for (int row = 0; row < Board.length; row ++){
	    for (int col = 0; col < Board[0].length && (Board[row][col] != 0); col ++){
		count ++;
	    }
	}
	if (count == (Board.length * Board[0].length)){
	    return true;
	}
	for (int w = 0; w < 8; w ++){
	    try{
		if (Board[r + rChanges[w]][c + cChanges[w]] == 0){
		    Board[r + rChanges[w]][c + cChanges[w]] = level + 1;
		    if (solveH(r + rChanges[w], c + cChanges[w], level + 1)){
			return true;
		    }
		    Board[r + rChanges[w]][c + cChanges[w]] = 0;
		}
	    }catch (ArrayIndexOutOfBoundsException e){}
	}
	return false;
    }
    
    public static void main(String[] args){
	KnightBoard two = new KnightBoard(2,2);
        two.solve();
        System.out.println(two.toString());
	KnightBoard five = new KnightBoard(4,5);
	five.solve();
        System.out.println(five.toString());
	KnightBoard six = new KnightBoard(6,6);
	six.solve();
        System.out.println(six.toString());
	KnightBoard seven = new KnightBoard(7,7);
	seven.solve();
        System.out.println(seven.toString());
	KnightBoard nine = new KnightBoard(10,10);
        nine.solve();
        System.out.println(nine.toString());
    }
}
=======
public class KnightBoard{
    public int[][] Board;
    public static int[] rChanges = {2,1,-2,-1,2,1,-2,-1};
    public static int[] cChanges = {-1,-2,-1,-2,1,2,1,2};

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
    
    public void solve() {
	for (int r = 0; r < Board.length; r ++){
	    for (int c = 0; c < Board[0].length; c ++){
		Board[r][c] = 1;
		if (solveH(r, c, 1)) {
		    break;
		}
		Board[r][r] = 0;
	    }
	}
    }
    
    private boolean solveH(int r ,int c, int level){
	int count = 0;
	for (int row = 0; row < Board.length; row ++){
	    for (int col = 0; col < Board[0].length && (Board[row][col] != 0); col ++){
		count ++;
	    }
	}
	if (count == (Board.length * Board[0].length)){
	    return true;
	}
	for (int w = 0; w < 8; w ++){
	    try{
		if (Board[r + rChanges[w]][c + cChanges[w]] == 0){
		    Board[r + rChanges[w]][c + cChanges[w]] = level + 1;
		    if (solveH(r + rChanges[w], c + cChanges[w], level + 1)){
			return true;
		    }
		    Board[r + rChanges[w]][c + cChanges[w]] = 0;
		}
	    }catch (ArrayIndexOutOfBoundsException e){}
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
	KnightBoard nine = new KnightBoard(10,10);
        nine.solve();
        System.out.println(nine.toString());
    }
}
>>>>>>> 38707c1bf357aedca154e586a866e17f5996a71e:EC01/KnightBoard.java
