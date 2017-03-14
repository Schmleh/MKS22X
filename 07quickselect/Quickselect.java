public class Quickselect{

    public static int partition(int[] nums, int start, int end, int pos){
	System.out.println(start);
	System.out.println(end);
	int[] two = new int[nums.length];
	for(int i = 0; i < start; i ++){
	    two[i] = nums[i];
	}
	int s = start;
	int e = end - 1;
	for(int i = start; i < end; i ++){
	    if (i != pos){
		int j = nums[i];
		if (j < nums[pos]){
		    two[s] = j;
		    s ++;
		}
		if (j >= nums[pos]){
		    two[e] = j;
		    e --;
		}
	    }
	}
	two[s] = nums[pos];
	for(int i = end ; i < nums.length; i ++){
	    two[i] = nums[i];
	}
	 for (int j : two){
	     System.out.print(j);
	 }
	 System.out.println("");
	nums = two;
	System.out.println(s);
	return s;
    }
    
    // public static int quickFind(int[] nums, int pos){
    // 	int start = 0;
    // 	int end = nums.length;
    // 	int found = -1;
    // 	while( found != pos - 1){
    // 	    int ran = (int)(start + (Math.random() * (end - start)));
    // 	    System.out.println(ran);
    // 	    found = partition(nums, start, end, ran);
    // 	    if (found > pos - 1){
    // 		end = found;
    // 	    }
    // 	    if (found < pos - 1){
    // 		start = found;
    // 	    }
	    
    // 	}
    // 	return nums[found];
    // }

    // public static void main(String[] args){
    // 	int[] num = {5,6,2,8,1,0,3,8,6};
    // 	System.out.println(quickFind(num, 4));
    // }
}
