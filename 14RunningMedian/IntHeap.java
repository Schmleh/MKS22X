import java.util.ArrayList;

public class IntHeap{

    private boolean max;
    private ArrayList<Integer> heep;
    private int woahdude;

    public IntHeap(){
	max = true;
	woahdude = 1;
	heep = new ArrayList<Integer>(1);
	heep.add(null);
    }

    public IntHeap(boolean dank){
	max = dank;
	if (max){
	    woahdude = 1;
	}else {
	    woahdude = -1;
	}
	heep = new ArrayList<Integer>(1);
	heep.add(null);
    }

    public void add(Integer s){
	heep.add(s);
	pushUp(heep.size() - 1);
    }

    public Integer remove(){
	if (heep.size() > 1){
	    Integer val =  heep.remove(1);
	    heep.set(1,heep.remove(heep.size()));
	    pushDown(1);
	    return val;
	} else {
	    return -69;
	}
    }
    
    public Integer peek(){
	return heep.get(1);
    }

    public void pushUp(int place){
	if (place != 1){
	    if (heep.get(place).compareTo(heep.get(place / 2)) * woahdude > 0){
		Integer temmp = heep.get(place);
		heep.set(place, heep.get(place / 2));
		heep.set(place / 2, temmp);
		pushUp(place / 2);
	    }
	}
    }

    public void pushDown(int place){
	if (place * 2 <= heep.size()){
	    if (heep.get(place).compareTo(heep.get(place * 2)) * woahdude  < 0){
		Integer temmp = heep.get(place);
		heep.set(place, heep.get(place * 2));
		heep.set(place * 2, temmp);
		pushDown(place * 2);
	    }
	} else if (place * 2 <= heep.size() + 1){
	    if (heep.get(place).compareTo(heep.get(place * 2 + 1)) * woahdude < 0){
		Integer temmp = heep.get(place);
		heep.set(place, heep.get(place * 2 + 1));
		heep.set(place * 2 + 1, temmp);
		pushDown(place * 2 + 1);
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
	    
    
    public static void main(String[] args){
        IntHeap hey = new IntHeap();
        hey.add(1);
	System.out.println(hey.toString());
	hey.add(2);
	System.out.println(hey.toString());
	hey.add(3);
	System.out.println(hey.toString());
	hey.add(4);
	System.out.println(hey.toString());
	hey.add(5);
	System.out.println(hey.toString());
    }
}
