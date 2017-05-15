import java.util.*;

public class IntHeap{

    private boolean max;
    private ArrayList<Integer> heep;
    private int woahdude;
    private int size;

    public IntHeap(){
	size = 0;
	max = true;
	woahdude = 1;
	heep = new ArrayList<Integer>(1);
	heep.add(null);
    }

    public IntHeap(boolean dank){
	size = 0;
	max = dank;
	if (max){
	    woahdude = 1;
	}else {
	    woahdude = -1;
	}
	heep = new ArrayList<Integer>(1);
	heep.add(null);
    }

    public int size(){
	return size;
    }

    public void add(Integer s){
	heep.add(s);
	pushUp(heep.size() - 1);
	size += 1;
    }

    public Integer remove(){
	if (heep.size() > 1){
	    Integer val =  heep.remove(1);
	    heep.add(1,heep.remove(heep.size() - 1));
	    pushDown(1);
	    size -= 1;
	    return val;
	} else {
	    throw new NoSuchElementException();
	}
    }
    
    public Integer peek(){
	return heep.get(1);
    }

    public void pushUp(int place){
	if (place != 1){
	    if ((place / 2) * 2 + 1 < heep.size()){
		int left = (place / 2) * 2;
		int right = (place / 2) * 2 + 1;
		if (heep.get(left) * woahdude > heep.get(right) * woahdude){
		    if (heep.get(left).compareTo(heep.get(place / 2)) * woahdude > 0){
			Integer temmp = heep.get(left);
			heep.set(left, heep.get(place / 2));
			heep.set(place / 2, temmp);
			pushUp(place / 2);
		    }
		} else if (heep.get(right).compareTo(heep.get(place / 2)) * woahdude > 0){
		    Integer temmp = heep.get(right);
		    heep.set(right, heep.get(place / 2));
		    heep.set(place / 2, temmp);
		    pushUp(place / 2);
		}
	    } else {
		if (heep.get(place).compareTo(heep.get(place / 2)) * woahdude > 0){
		    Integer temmp = heep.get(place);
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
		Integer temmp = heep.get(place);
		int question = 1;
		if ((heep.get(place * 2)) * woahdude > (heep.get(place * 2 + 1)) * woahdude){
		    question = 0;
		}
		heep.set(place, heep.get(place * 2 + question));
		heep.set(place * 2 + question, temmp);
		pushDown(place * 2 + question);
	    } else if (heep.get(place).compareTo(heep.get(place * 2)) * woahdude  < 0){
		Integer temmp = heep.get(place);
		heep.set(place, heep.get(place * 2));
		heep.set(place * 2, temmp);
		pushDown(place * 2);
	    }
	} else if (place * 2 < heep.size()){
	    if (heep.get(place).compareTo(heep.get(place * 2)) * woahdude  < 0){
		Integer temmp = heep.get(place);
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
	    
    
    // public static void main(String[] args){
    // 	IntHeap hey = new IntHeap(false);
    // 	hey.add(127);
    //  	System.out.println(hey.toString());
    //  	hey.add(244);
    //  	System.out.println(hey.toString());
    //  	hey.add(132);
    //  	System.out.println(hey.toString());
    //  	hey.add(480);
    //  	System.out.println(hey.toString());
    //  	hey.add(35);
    //  	System.out.println(hey.toString());
    //  	hey.add(412);
    // 	System.out.println(hey.toString());
    //  	hey.add(43770);
    //  	System.out.println(hey.toString());
    // 	hey.add(67);
    // 	System.out.println(hey.toString());
    //  	hey.add(81);
    //  	System.out.println(hey.toString());
    //  	hey.remove();
    //  	System.out.println(hey.toString());
    //  	hey.remove();	
    //  	System.out.println(hey.toString());
    //  	hey.remove();
    //  	System.out.println(hey.toString());
	
    //  }
}
