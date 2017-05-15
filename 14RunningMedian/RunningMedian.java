import IntHeap;

public class RunningMedian{

    private int median;
    private IntHeap maxus;
    private IntHeap minus;
    private int size;

    public RunningMedian(){
	maxus = new IntHeap(false);
	minus = new IntHeap();
	size = 0;
	median = null;
    }

    public void add(int number){
	if (size =< 0){
	    median = number;
	    size = 1;
	} else {
	    if (number > minus.peek()){
		if (maxus.size() - minus.size() < 2){
		    maxus.add(median);
		    maxus.add(number);
		    median = maxus.remove();
		} else {
		    minus.add(median);
		    minus.add(number);
		    median = minus.remove();
		}
	    } else {
		if(minus.size() - maxus.size() < 2){
		    minus.add(median);
		    minus.add(number);
		    median = minus.remove;
		} else {
		    maxus.add(median);
		    maxus.add(number);
		    median = maxus.remove;
		}
	    }
	}
	size += 1;
    }

    public int remove(){
	if(size == 1){
	    size = 0;
	    return median;
	} else {
	    if (minus.size - maxus.size() => 0){
		int hold = median;
		median = minus.remove();
		size -= 1;
		return hold;
	    } else {
		int hold = median;
		median = maxus.remove();
		size -= 1;
		return hold;
	    }
	}
    }
    
    public int size(){
	return size;
    }

    public int peek(){
	return median;
    }
    
}
