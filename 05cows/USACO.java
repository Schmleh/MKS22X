import java.util.*;
import java.io.*;

public class USACO{

    public USACO(){}

    public static int bronze(String lak){
	try{
	    File direction = new File(lak);
	    Scanner dir = new Scanner(direction);
	    int[][] lake = new int[dir.nextInt()][dir.nextInt()];
	    int elevation = dir.nextInt();
	    int[][] directions = new int[dir.nextInt()][3];
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
	    return bronzeh(directions, elevation, lake);
	}catch (FileNotFoundException e){
	    System.out.println("File not found");
	    return -1;
	}
    }

    public static int highest(int row, int col, int[][] lake){
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
    
    public static int bronzeh(int[][] directions, int elevation, int[][] lake){
	for(int n = 0; n < directions.length; n++){
	    for(int t = 0; t < directions[n][2]; t++){
		int highest = highest(directions[n][0] - 1, directions[n][1] - 1, lake);
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

    public static void anf(int row, int col, int[][] now, int[][] soon){
	int nex = 0;
	if (row + 1 < now.length && (now[row + 1][col] != -1)){
	    nex += now[row + 1][col];
	}
	if (row - 1 >= 0 && (now[row - 1][col] != -1)){
	    nex += now[row - 1][col];
	}
	if (col + 1 < now[0].length && (now[row][col + 1] != -1)){
	    nex += now[row][col + 1];
	}
	if (col - 1 >= 0 && (now[row][col - 1] != -1)){
	    nex += now[row][col - 1];
	}
	soon[row][col] = nex;
    }
    
    public static int silver(String file){
	try{
	    File direction = new File(file);
	    Scanner dir = new Scanner(direction);
	    int[][] now = new int[dir.nextInt()][dir.nextInt()];
	    int time = dir.nextInt();
	    int[][] soon = new int[now.length][now[0].length];
	    String line = "";
	    for (int r = 0; r < now.length; r++){
		line = dir.next();
		for (int c = 0; c < now[0].length; c++){
		    if(line.charAt(c) == '*'){
			now[r][c] = -1;
			soon[r][c] = -1;
		    }
		}
	    }
	    now[dir.nextInt() - 1][dir.nextInt() - 1] = 1;
	    int gx = dir.nextInt() - 1;
	    int gy = dir.nextInt() - 1;
	    while (time > 0){
		for (int r = 0; r < now.length; r++){
		    for (int c = 0; c < now[0].length; c++){
			if (now[r][c] != -1){
			    anf(r, c, now, soon);
			}
		    }
		}
		for (int r = 0; r < now.length; r++){
		    for (int c = 0; c < now[0].length; c++){
			now[r][c] = soon[r][c];
		    }
		}
		time --;
	    }
	    return now[gx][gy];	    
	}catch (FileNotFoundException e){
	    System.out.println("File not found");
	    return -1;
	}
    }
    
    public static void main(String[] args){
	for(int i = 1; i < 11; i++){
	    System.out.println(USACO.silver("ctravel." + i + ".in"));
	}
    }
}
