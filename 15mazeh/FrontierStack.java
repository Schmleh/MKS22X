import java.util.*;

public class FrontierStack implements Frontier{

    public ArrayDeque<Location> stack;

    public FrontierStack(){
	stack = new ArrayDeque<Location>();
    }

    public Location next(){
	return stack.pollLast();
    }

    public void add(Location to){
        stack.addLast(to);
    }

    public int size(){
	return stack.size();
    }

    public Location peek(){
	if (stack.size() > 0){
	    return stack.peekLast();
	} else {
	    return null;
	}
    }
}
