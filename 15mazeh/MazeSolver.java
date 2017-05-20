import java.io.*;

public class MazeSolver{
    
    public Maze maze;
    public boolean alive;
			      
    public MazeSolver(String filename) {
	this(filename,false);
    }
    
    public MazeSolver(String filename, boolean animate){
	maze = new Maze(filename);
	alive = animate;
    }
	
    public void solve(){
	solve(1);
    }

    public void solve(int style){
	Frontier struct;
	boolean huh = false;
	switch(style){
	case 0: struct = new FrontierStack();
	    break;
	case 1: struct = new FrontierQueue();
	    break;
	case 2: struct = new FrontierPriorityQueue();
	    break;
	case 3: struct = new FrontierPriorityQueue();
	    huh = true;
	    break;
	default: struct = new FrontierPriorityQueue();
	    huh = true;
	    break;
	}
	struct.add(maze.getStart());
	while (!(struct.next().equals(null))){
	    Location now = struct.next();
	    System.out.println(now.getr());
	    System.out.println(maze.getEnd().getr());
	    System.out.println(now.getc());
	    System.out.println(maze.getEnd().getc());
	    if ((now.getr() == maze.getEnd().getr()) && (now.getc() == maze.getEnd().getc())){
		System.out.println(this.toString());
		System.exit(0);
	    }
	    int times = 0;
	    try {
		if (maze.get(now.getr() + 1,now.getc()+0) == ' '){
		    struct.add(new Location( now.getr()+1, now.getc()+0, now, Math.abs(now.getr()+1 - maze.getStart().getr()) + Math.abs(now.getc()+0 - maze.getStart().getc()), Math.abs(now.getr()+1 - maze.getEnd().getr()) + Math.abs(now.getc()+0 - maze.getEnd().getc()),huh));
		    maze.set(now.getr() + 1, now.getc()+0, '?');
		    times ++;
		}
	    } catch (IndexOutOfBoundsException e){}
	    try {
		if (maze.get(now.getr() - 1, now.getc()+0) == ' '){
		    struct.add(new Location( now.getr()-1, now.getc()+0, now, Math.abs(now.getr()-1 - maze.getStart().getr()) + Math.abs(now.getc()+0 - maze.getStart().getc()), Math.abs(now.getr()-1 - maze.getEnd().getr()) + Math.abs(now.getc()+0 - maze.getEnd().getc()),huh));
		    maze.set(now.getr() - 1, now.getc()+0, '?');
		    times ++;
		}
	    } catch (IndexOutOfBoundsException e){}
	    try {
		if (maze.get(now.getr() + 0, now.getc()+1) == ' '){
		    struct.add(new Location( now.getr()+0, now.getc()+1, now, Math.abs(now.getr()+0 - maze.getStart().getr()) + Math.abs(now.getc()+1 - maze.getStart().getc()), Math.abs(now.getr()+0 - maze.getEnd().getr()) + Math.abs(now.getc()+1 - maze.getEnd().getc()),huh));
		    maze.set(now.getr() + 0, now.getc()+1, '?');
		    times ++;
		}
	    } catch (IndexOutOfBoundsException e){}
	    try {
		if (maze.get(now.getr() + 0, now.getc()-1) == ' '){
		    struct.add(new Location( now.getr()+0, now.getc()-1, now, Math.abs(now.getr()+0 - maze.getStart().getr()) + Math.abs(now.getc()-1 - maze.getStart().getc()), Math.abs(now.getr()+0 - maze.getEnd().getr()) + Math.abs(now.getc()-1 - maze.getEnd().getc()),huh));
		    maze.set(now.getr() + 0, now.getc()-1, '?');
		    times ++;
		}
	    } catch (IndexOutOfBoundsException e){}
	    if (times == 0){
		maze.set(now.getr(), now.getc(), '.');
	    } else {
		maze.set(now.getr(), now.getc(), '@');
	    }
	    System.out.println(this.toString());
	}
	System.out.println("No solution.");
    }
    
    public String toString(){
	if (alive){
	    return Maze.colorize(maze.toString());
	}else {
	    return maze.toString();
	}
    }


    public static void main(String[] args){
	MazeSolver ayo = new MazeSolver("one.txt");
        ayo.solve(0);
	ayo.solve(1);
	ayo.solve(2);
	ayo.solve(3);
	MazeSolver yoa = new MazeSolver("two.txt");
	//yoa.solve();
    }
    
}
