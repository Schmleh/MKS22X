public class KnightBoard{
    public int[][] Board;
    public static int[] rChanges = {2,1,-2,-1,2,1,-2,-1};
    public static int[] cChanges = {-1,-2,-1,-2,1,2,1,2};
    public int[] xvals = {0,0,0,0,0,0,0,0};
    public int[] yvals = {0,0,0,0,0,0,0,0};
    public int[] from = {0,0,0,0,0,0,0,0};

    public KnightBoard(int startingRows, int startingCols){
	Board = new int[startingRows][startingCols];
    }

    public String toString(){
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
	System.out.println(meh);
	return meh;
    }
    
    public void solveFast() {
	int solved = 0;
	for (int r = 0; r < Board.length; r ++){
	    for (int c = 0; c < Board[0].length; c ++){
		if (solveH(r, c, 1)) {
		    solved = 1;
		    break;
		}
	    }
	    if (solved == 1){
		break;
	    }
	}
    }
    
    private boolean solveH(int r ,int c, int level){
	Board[r][c] = level;
	toString();
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
		from[w] = fpos(r + rChanges[w], c + cChanges[w]); 
		xvals[w] = c + cChanges[w];
		yvals[w] = r + rChanges[w];
	    }catch (ArrayIndexOutOfBoundsException e){
		from[w] = 0;
		xvals[w] = c + cChanges[w];
		yvals[w] = r + rChanges[w];
	    }
	}
	optimize(from, xvals, yvals);
	for (int w = 0; w < 8; w++){
	    if (from[w] != 0){
		if (solveH(xvals[w], yvals[w], level + 1)){
		    return true;
		}
	    }
	}
	return false;
    }

    private int fpos(int r, int c){
	if (Board[r][c] != 0){
	    return 0;
	}
	int count = 0;
	for (int w = 0; w < 8; w ++){
	    try{
		if (Board[r + rChanges[w]][c + cChanges[w]] == 0){
		    count ++;
		}
	    }catch (ArrayIndexOutOfBoundsException e){}
	}
	return count;
    }
    
    private void optimize(int[] vals, int[] xs, int[] ys){
        for (int location = 0; location < vals.length; location ++){
	    int lookat = location;
	    int current = location;
	    int tempspot =  vals[location];
	    int temx = xs[location];
	    int temy = ys[location];
	    lookat ++;
	    while (lookat < 8){
		if (vals[lookat] < tempspot){
		    tempspot = vals[lookat];
		    temx = xs[lookat];
		    temy = ys[lookat];
		    current = lookat;
		}
		lookat ++;
	    }
	    vals[current] = vals[location];
	    vals[location] = tempspot;
	    xs[current] = xs[location];
	    xs[location] = temx;
	    ys[current] = ys[location];
	    ys[location] = temy;
	}
    }
    
    public static void main(String[] args){
	KnightBoard two = new KnightBoard(2,2);
        two.solveFast();
        System.out.println(two.toString());
	KnightBoard five = new KnightBoard(5,5);
	five.solveFast();
        System.out.println(five.toString());
	KnightBoard six = new KnightBoard(6,6);
	six.solveFast();
        System.out.println(six.toString());
	KnightBoard seven = new KnightBoard(7,7);
	seven.solveFast();
        System.out.println(seven.toString());
	KnightBoard nine = new KnightBoard(10,10);
        nine.solveFast();
        System.out.println(nine.toString());
    }
}
