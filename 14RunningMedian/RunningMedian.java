public class RunningMedian{

    private Integer median;
    private IntHeap maxus;
    private IntHeap minus;
    private Integer size;

    public RunningMedian(){
	maxus = new IntHeap(false);
	minus = new IntHeap();
	size = 0;
	median = null;
    }

    public void add(int number){
	if (size <= 0){
	    median = number;
	    size = 1;
	} else {
	    if (minus.size() == 0){
		minus.add(number);
		minus.add(median);
		median = minus.remove();
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
			median = minus.remove();
		    } else {
			maxus.add(median);
			maxus.add(number);
			median = maxus.remove();
		    }
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
	    if (minus.size() - maxus.size() >= 0){
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

    public int getMedian(){
	return median;
    }

    // public static void main(String[] args){
    //     RunningMedian hey = new RunningMedian();
    //  	hey.add(127);
    //   	hey.add(244);
    //   	hey.add(132);
    //   	hey.add(480);
    //   	hey.add(35);
    //   	hey.add(412);
    //   	hey.add(43770);
    //  	hey.add(67);
    //   	hey.add(81);
    //     System.out.println(hey.getMedian());
    // }
    
}
