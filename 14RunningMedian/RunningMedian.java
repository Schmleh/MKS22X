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
	        maxus.add(median);
		maxus.add(number);
		median = maxus.remove();
	    }else {
		minus.add(median);
		minus.add(number);
		median = minus.remove;
	    }
	}
    }
    //fix so that the minus and maxus always stay within a size of each other
    
}
