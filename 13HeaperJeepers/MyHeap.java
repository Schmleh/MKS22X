import java.util.ArrayList;

public class MyHeap{

    private boolean max;
    private ArrayList<String> heep;
    private int woahdude;

    public MyHeap(){
	max = true;
	woahdude = 1;
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
	
    }

    public String remove(){
	if (ArrayList.size() > 1){
	    new String val =  heep.remove(1);
	    heep.add(1,heep.remove(heep.size()));
	    pushDown(1);
	} else {
	    throw new NoSuchElementException();
	}
    }
    
    public String peek(){
	return heep.get(1);
    }

    public void pushUp(int place){
	if (place != 1){
	    if (heep.get(place).compareTo(heep.get(place / 2)) > 0){
		String temmp = heep.get(place);
		heep.set(place, heep.get(place / 2));
		heep.set(place / 2, temmp);
	    }
	}
    }

    public void pushDown(int place){
	
    }

}
