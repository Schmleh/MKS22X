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

    private int highest(int row, int col){
	int current = 0;
	for(int r = 0; r < 3; r++){
	    for(int c = 0; c < 3; c++){
		if (lake[row + r][col + c] > current){
		    current = lake[row + r][col + c];
		}
	    }
	}
	return current;
    }
    
    private int bronze(){
	for(int n = 0; n < directions.length; n++){
	    for(int t = 0; t < directions[n][2]; t++){
		int highest = highest(directions[n][0] - 1, directions[n][1] - 1);
		for(int r = 0; r < 3; r++){
		    for(int c = 0; c < 3; c++){
			if (lake[directions[n][0] - 1 + r][directions[n][1] - 1 + c] == highest){
			    if (lake[directions[n][0] - 1 + r][directions[n][1] - 1 + c] > 0){
				lake[directions[n][0] - 1 + r][directions[n][1] - 1 + c] -= 1;
			    }
			}
		    }
		}
	    }
	}
	int vol = 0;
	for (int r = 0; r < lake.length; r ++){
	    for (int c = 0; c < lake[0].length; c ++){
		if (lake[r][c] < elevation){
		    vol += (elevation - lake[r][c]);
		}
	    }
	}
	return vol * 5184;
    }

    public static void main(String[] args){
	for(int i = 1; i < 11; i++){
	    USACO one = new USACO("makelake." + i + ".in");
	    System.out.println(one.bronze());
	}
    }
}
