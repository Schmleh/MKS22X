public class Location implements Comparable<Location>{
    private Integer row, col, distanceToStart, distanceToEnd;
    Location previous;
    private boolean aStar;

    public Location(Integer r, Integer c, Location yes,  Integer distToStart, Integer distToGoal, boolean aStarr){
	row = r;
	col = c;
	distanceToStart = distToStart;
	distanceToEnd = distToGoal;
	previous = yes;
	aStar = aStarr;
    }

    public Integer getPriority(){
	Integer priority;
	if (aStar){
	    priority = distanceToStart + distanceToEnd;
	} else {
	    priority = distanceToStart;
	}
	return priority;
    }
    
    public int compareTo(Location other){
	return other.getPriority() - this.getPriority();
    }

    public int getr(){
	return row;
    }

    public int getc(){
	return col;
    }
    
}
