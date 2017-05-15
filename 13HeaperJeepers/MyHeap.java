import java.util.*;

public class MyHeap{

    private boolean max;
    private ArrayList<String> heep;
    private int woahdude;

     public MyHeap(){
	max = true;
	woahdude = 1;
	heep = new ArrayList<String>(1);
	heep.add(null);
    }

    public MyHeap(boolean dank){
	max = dank;
	if (max){
	    woahdude = 1;
	}else {
	    woahdude = -1;
	}
	heep = new ArrayList<String>(1);
	heep.add(null);
    }

    public void add(String s){
	heep.add(s);
	pushUp(heep.size() - 1);
    }

    public String remove(){
	if (heep.size() > 1){
	    String val =  heep.remove(1);
	    heep.add(1,heep.remove(heep.size() - 1));
	    pushDown(1);
	    return val;
	} else {
	    throw new NoSuchElementException();
	}
    }
    
    public String peek(){
	return heep.get(1);
    }

    public void pushUp(int place){
	if (place != 1){
	    if ((place / 2) * 2 + 1 < heep.size()){
		int left = (place / 2) * 2;
		int right = (place / 2) * 2 + 1;
		if (heep.get(left).compareTo(heep.get(right)) > 0){
		    if (heep.get(left).compareTo(heep.get(place / 2)) * woahdude > 0){
			String temmp = heep.get(left);
			heep.set(left, heep.get(place / 2));
			heep.set(place / 2, temmp);
			pushUp(place / 2);
		    }
		} else if (heep.get(right).compareTo(heep.get(place / 2)) * woahdude > 0){
		    String temmp = heep.get(right);
		    heep.set(right, heep.get(place / 2));
		    heep.set(place / 2, temmp);
		    pushUp(place / 2);
		}
	    } else {
		if (heep.get(place).compareTo(heep.get(place / 2)) * woahdude > 0){
		    String temmp = heep.get(place);
		    heep.set(place, heep.get(place / 2));
		    heep.set(place / 2, temmp);
		    pushUp(place / 2);
		}
	    }
	}
    }

    public void pushDown(int place){
        if (place * 2 + 1 < heep.size()){
	    if (heep.get(place).compareTo(heep.get(place * 2 + 1)) * woahdude < 0){
	        String temmp = heep.get(place);
		int question = 1;
		if ((heep.get(place * 2)).compareTo(heep.get(place * 2 + 1)) > 0){
		    question = 0;
		}
		heep.set(place, heep.get(place * 2 + question));
		heep.set(place * 2 + question, temmp);
		pushDown(place * 2 + question);
	    } else if (heep.get(place).compareTo(heep.get(place * 2)) * woahdude  < 0){
		String temmp = heep.get(place);
		heep.set(place, heep.get(place * 2));
		heep.set(place * 2, temmp);
		pushDown(place * 2);
	    }
	} else if (place * 2 < heep.size()){
	    if (heep.get(place).compareTo(heep.get(place * 2)) * woahdude  < 0){
	        String temmp = heep.get(place);
		heep.set(place, heep.get(place * 2));
		heep.set(place * 2, temmp);
		pushDown(place * 2);
	    }
	}
    }

    public String toString(){
	String ret = "[ ";
	for (int i = 1; i < heep.size(); i ++){
	    if (i == heep.size() - 1){
		ret += heep.get(i) + "]";
	    } else {
		ret += heep.get(i) + ", ";
	    }
	}
	return ret;
    }

    // public static void main(String[] args){
    // 	MyHeap hey = new MyHeap();
    // 	hey.add("");
    // 	hey.add("yaaaas");
    // 	hey.add("noooo.");
    // 	hey.add("heyyyy");
    // 	hey.add("wazzup");
    // 	hey.add("IMHIGH");
    // 	System.out.println(hey.toString());
    // 	System.out.println(hey.remove());
    // 	System.out.println(hey.toString());
	
    // }
}
