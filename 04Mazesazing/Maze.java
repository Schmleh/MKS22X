import java.util.*;
import java.io.*;

public class Maze{

    private char[][]maze;
    private boolean animate;
    private int lineNumber;
    private int lineLength;
    private File text;

    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR there is no E or S then: print an error and exit the program.
    */
    public Maze(String filename) {
	try{
	    text = new File(filename);// can be a path"/full/path/to/file.txt"
	    Scanner maz = new Scanner(text);
	    while(maz.hasNextLine()){
		String line = maz.nextLine();
		lineLength = line.length();
		lineNumber++;
	    }
	    lineNumber++;
	    maze = new char[lineNumber][lineLength];
	    maz = new Scanner(text);
	    for (int r = 0; r < lineNumber - 1; r ++){
		String line = maz.nextLine();
		for (int c = 0; c < lineLength; c ++){
		    maze[r][c] = line.charAt(c);
		}
	    }
	} catch (FileNotFoundException n) {
	    System.out.println("File not found.");
	}
	setAnimate(false);
    }
    
    private void wait(int millis){ //ADDED SORRY!
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }

    public String toString(){
	String meh = "";
	for (int r = 0; r < lineNumber; r ++){
	    for (int c = 0; c < lineLength; c ++){
		meh += maze[r][c];
	    }
	    meh += "\n";
	}
	System.out.println(meh);
	return meh;
    }

    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        System.out.println("\033[2J\033[1;1H");
    }

    /*for (int r = 0; r < maze.length; r ++){
	for (int c = 0; c < maze[0].length; c ++){

	}
    }*/

    public boolean solve(){
            int startr=-1,startc=-1;
	    for (int r = 0; r < maze.length; r ++){
		for (int c = 0; c < maze[0].length; c ++){
		    if (maze[r][c] == 'S'){
			startr = r;
			startc = c;
			break;
		    }
		}
	    }
            //Initialize starting row and startint col with the location of the S. 
	    //maze[startr][startc] = 'S';//erase the S, and start solving!
	    return solve(startr,startc);
    }

/*A solved maze has a path marked with '@' from S to E.

      Returns true when the maze is solved,
      Returns false when the maze has no solution.

      Postcondition:
        The S is replaced with '@' but the 'E' is not.
        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'*/

    private boolean solve(int r, int c){
        if(animate){
            System.out.println("\033[2J\033[1;1H"+this);
            wait(20);
        }
	if (maze[r][c] == 'E'){
	    return true;
	}
	maze[r][c] = '@';
	if (works(r+1, c)){
	    if(solve(r+1, c)){
		return true;
	    }
	}
	if (works(r, c+1)){
	    if(solve(r, c+1)){
		return true;
	    }
	}
	if (works(r-1, c)){
	    if(solve(r-1, c)){
		return true;
	    }
	}
	if (works(r, c-1)){
	    if(solve(r, c-1)){
		return true;
	    }
	}
	maze[r][c] = '.';
	return false;
    }
    
    private boolean works(int r, int c){
	return maze[r][c] == ' ' || maze[r][c] == 'E';
    }

    // public static void main(String[] args){
    // 	Maze one = new Maze("data3.dat");
    // 	one.setAnimate(true);
    // 	one.solve();
    // 	one.toString();
    // 	one = new Maze("data2.dat");
    // 	one.setAnimate(true);
    // 	one.solve();
    // 	one.toString();
    // 	one = new Maze("data1.dat");
    // 	one.setAnimate(true);
    // 	one.solve();
    // 	one.toString();
    // }

}
