import java.util.ArrayList;

public class MyHeap{

    private boolean max;
    private ArrayList<String> heep;
    private int woahdude;

    public MyHeap(){
	max = true;
	woahdude = 1;
	heep = new ArrayList<String>(1);
	heep.add("");
    }

    public MyHeap(boolean dank){
	max = dank;
	if (max){
	    woahdude = 1;
	}else {
	    woahdude = -1;
	}
	heep = new ArrayList<String>(1);
	heep.add("");
    }

    public void add(String s){
	heep.add(s);
	pushUp(heep.size());
    }

    public String remove(){
	if (heep.size() > 1){
	    String val =  heep.remove(1);
	    heep.set(1,heep.remove(heep.size()));
	    pushDown(1);
	    return val;
	} else {
	    return "ddie";
	}
    }
    
    public String peek(){
	return heep.get(1);
    }

    public void pushUp(int place){
	if (place != 1){
	    if (heep.get(place).compareTo(heep.get(place / 2)) * woahdude > 0){
		String temmp = heep.get(place);
		heep.set(place, heep.get(place / 2));
		heep.set(place / 2, temmp);
		pushUp(place / 2);
	    }
	}
    }

    public void pushDown(int place){
	if (place * 2 <= heep.size()){
	    if (heep.get(place).compareTo(heep.get(place * 2)) * woahdude  < 0){
		String temmp = heep.get(place);
		heep.set(place, heep.get(place * 2));
		heep.set(place * 2, temmp);
		pushDown(place * 2);
	    }
	} else if (place * 2 <= heep.size() + 1){
	    if (heep.get(place).compareTo(heep.get(place * 2 + 1)) * woahdude < 0){
		String temmp = heep.get(place);
		heep.set(place, heep.get(place * 2 + 1));
		heep.set(place * 2 + 1, temmp);
		pushDown(place * 2 + 1);
	    }
	}
    }

    public String toString(){
	String ret = "";
	for (int i = 1; i <= heep.size(); i ++){
	    ret += heep.get(i) + " ";
	}
	return ret;
    }
	    
    
    public static void main(String[] args){
	MyHeap hey = new MyHeap();
        hey.add("point");
	hey.add("from");
	hey.add("kind of");
	hey.add("sometimes");
	hey.add("never");
	hey.toString();
    }
}
