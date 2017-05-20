import java.util.*;

public class FrontierQueue implements Frontier{

    public ArrayDeque<Location> queue;

    public FrontierQueue(){
	queue = new ArrayDeque<Location>();
    }

    public Location next(){
	return queue.pollFirst();
    }

    public void add(Location to){
	queue.addLast(to);
    }

    public int size(){
	return queue.size();
    }
}
