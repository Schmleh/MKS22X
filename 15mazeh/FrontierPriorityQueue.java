import java.util.*;

public class FrontierPriorityQueue implements Frontier{

    private ArrayList<Location> heep;
    private int size;
    
    public int size(){
	return size;
    }

    public FrontierPriorityQueue(){
	size = 0;
	heep = new ArrayList<Location>(1);
	heep.add(null);
    }

    public void add(Location s){
	heep.add(s);
	pushUp(heep.size() - 1);
	size += 1;
    }

    public Location next(){
	if (heep.size() > 1){
	    Location val =  heep.get(1);
	    heep.set(1,heep.get(heep.size() - 1));
	    heep.remove(heep.size() - 1);
	    pushDown(1);
	    size -= 1;
	    return val;
	} else {
	    return null;
	}
    }

    public Location peek(){
	if (heep.size() > 1){
	    return heep.get(1);
	} else {
	    return null;
	}
    }
    
    public void pushUp(int place){
	if (place != 1){
	    if ((place / 2) * 2 + 1 < heep.size()){
	        int left = (place / 2) * 2;
		int right = (place / 2) * 2 + 1;
		if (heep.get(left).compareTo(heep.get(right)) > 0){
		    if (heep.get(left).compareTo(heep.get(place / 2)) > 0){
			Location temmp = heep.get(left);
			heep.set(left, heep.get(place / 2));
			heep.set(place / 2, temmp);
			pushUp(place / 2);
		    }
		} else if (heep.get(right).compareTo(heep.get(place / 2)) > 0){
		    Location temmp = heep.get(right);
		    heep.set(right, heep.get(place / 2));
		    heep.set(place / 2, temmp);
		    pushUp(place / 2);
		}
	    } else {
		if (heep.get(place).compareTo(heep.get(place / 2)) > 0){
		    Location temmp = heep.get(place);
		    heep.set(place, heep.get(place / 2));
		    heep.set(place / 2, temmp);
		    pushUp(place / 2);
		}
	    }
	}
    }

    public void pushDown(int place){
        if (place * 2 + 1 < heep.size()){
	    if (heep.get(place).compareTo(heep.get(place * 2 + 1)) < 0){
	        Location temmp = heep.get(place);
		int question = 1;
		if ((heep.get(place * 2)).compareTo(heep.get(place * 2 + 1)) > 0){
		    question = 0;
		}
		heep.set(place, heep.get(place * 2 + question));
		heep.set(place * 2 + question, temmp);
		pushDown(place * 2 + question);
	    } else if (heep.get(place).compareTo(heep.get(place * 2))  < 0){
	        Location temmp = heep.get(place);
		heep.set(place, heep.get(place * 2));
		heep.set(place * 2, temmp);
		pushDown(place * 2);
	    }
	} else if (place * 2 < heep.size()){
	    if (heep.get(place).compareTo(heep.get(place * 2))  < 0){
	        Location temmp = heep.get(place);
		heep.set(place, heep.get(place * 2));
		heep.set(place * 2, temmp);
		pushDown(place * 2);
	    }
	}
    }

    public String toString(){
	String ret = "";
	for (int i = 1; i < heep.size(); i ++){
	    ret += heep.get(i) + " ";
	}
	return ret;
    }
}
