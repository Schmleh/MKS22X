public class Location{
    private Integer row, col, distanceToStart, distanceToEnd, priority;
    Location previous;
    private boolean aStar;

    public Location(Integer r, Integer c, Location yes,  Integer distToStart, Integer distToGoal, boolean aStarr){
	row = r;
	col = c;
	distanceToStart = distToStart;
	distanceToEnd = distToGoal;
	previous = yes;
	aStar = aStarr;
	if (aStarr){
	    priority = distToStart + distToGoal;
	} else {
	    priority = distToStart;
	}
    }
    
    public void setPriority(int newPriority){
	priority = newPriority;
    }

    public Integer getPriority(){
	return priority;
    }
    
    public Integer compareTo(Location other){
	return priority - other.getPriority();
    }
}
