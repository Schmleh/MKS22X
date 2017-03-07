import java.util.*;
import java.io.*;

public class USACO{

    private int[][] lake;
    private int elevation;
    private int[][] directions;
    
    public USACO(String lak){
	try{
	    File direction = new File(lak);
	    Scanner dir = new Scanner(direction);
	    lake = new int[dir.nextInt()][dir.nextInt()];
	    elevation = dir.nextInt();
	    directions = new int[dir.nextInt()][3];
	    for (int r = 0; r < lake.length; r++){
		for (int c = 0; c < lake[0].length; c++){
		    lake[r][c] = dir.nextInt();
		}
	    }
	    for (int r = 0; r < directions.length; r++){
		for (int c = 0; c < 3; c++){
		    directions[r][c] = dir.nextInt();
		}
	    }
	}catch (FileNotFoundException e){
	    System.out.println("File not found");
	}
    }

    public String toString(){
	String meh = "";
	for (int r = 0; r < lake.length; r++){
	    for (int c = 0; c < lake[0].length; c++){
		meh += lake[r][c];
		meh += " ";
	    }
	    meh += "\n";
	}
	return meh;
    }

    public static void main(String[] args){
	for(int i = 1; i < 11; i++){
	    USACO one = new USACO("makelake." + i + ".in");
	    System.out.println(one.toString());
	}
    }
}
