public class Quickselect{

    public static int partition(int[] nums, int start, int end){
	int pos = (int)(start + (Math.random() * (end - start)));
	//	System.out.println("Random Index: " + pos);
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
	for (int j = 0; j < nums.length; j ++){
	    nums[j] = two[j];
	}
	 for ( int j: nums){
	     System.out.print(j + " ");
	 }
	 System.out.print("\n");
	 System.out.println("Final Index: " + s);
	 return s;
    }
    
    public static int quickFind(int[] nums, int pos){
     	int start = 0;
     	int end = nums.length;
     	int found = -100;
     	while( found != pos){
	    System.out.println("Start: " + start);
	    System.out.println("End: " + end);
     	    found = partition(nums, start, end);
     	    if (found > pos){
     		end = found - 1;
     	    }
     	    if (found < pos){
     		start = found + 1;
     	    }
	    System.out.println("");
    	}
    	return nums[found];
    }

    public static void main(String[] args){
     	int[] num = {999,999,999,4,1,0,3,2,999,999,999, 42, 32, 91, 912, -3, 8912, -23, 235, -23489, 923};
     	System.out.println(quickFind(num, 4));
     }
}
