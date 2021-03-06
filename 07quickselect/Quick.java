import java.io.*;
public class Quick{

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
	 // for ( int j: nums){
	 //     System.out.print(j + " ");
	 // }
	 // System.out.print("\n");
	 // System.out.println("Final Index: " + s);
	 return s;
    }
    
    public static int quickselect(int[] nums, int pos){
	if (!(pos < 0 || pos >= nums.length)){
	    int start = 0;
	    int end = nums.length;
	    int found = -100;
	    while( found != pos){
		//System.out.println("Start: " + start);
		//System.out.println("End: " + end);
		found = partition(nums, start, end);
		if (found > pos){
		    end = found;
		}
		if (found < pos){
		    start = found + 1;
		}
		//System.out.println("");
	    }
	    return nums[found];
	} else{
	    try{
		throw new IllegalArgumentException();
	    } catch (IllegalArgumentException e){
		System.out.println("You can't get a number at that index in this array.");
		throw e;
	    }
	}
    }

    public static void swap(int[] ary, int one, int two){
	int three = 0;
	three = ary[two];
	ary[two] = ary[one];
	ary[one] = three;
    }

    public static void quicksort(int[] ary){
	quickhelp(ary, 0, ary.length - 1);
    }

    public static void quickhelp(int[] ary, int start, int end){
	if (end - start > 1){
	    int pos = (int)(start + (Math.random() * (end - start)));
	    int s = start;
	    int r = start;
	    int e = end;
	    swap(ary, pos, start);
	    while (s <= e){
		if (ary[s] == ary[r]){
		    s ++;
		}
		else if (ary[s] < ary[r]){
		    swap(ary, s, r);
		    s ++;
		    r ++;
		}
		else if (ary[s] > ary[r]){
		    swap(ary, s, e);
		    e --;
		}
	    }
	// for(int i = 0; i < ary.length; i ++){
	//     System.out.print(ary[i] + " ");
	// }
	// System.out.println("");
	quickhelp(ary, start, r --);
	quickhelp(ary, e, end);
	}
    }

    // public static void main(String[] args){
    //  	int[] num = new int[10000];
    //  	for (int i = 0; i < 10000; i++){
    // 	    num[i] = 1;
    // 	}
    // 	quicksort(num);
    // 	for(int i = 0; i < num.length; i ++){
    // 	    System.out.print(num[i] + " ");
    // 	}
    // }
    // public static void main(String[] args){
    //  	int[] num = {999,999,999,4,1,0,3,2,999,999,999, -2345, -2, -3 ,0, 8 ,91};
    //  	System.out.println(quickFind(num, -1));
    // 	System.out.println(quickFind(num, 4));
    // 	System.out.println(quickFind(num, 6));
    // 	System.out.println(quickFind(num, 5));
    // 	System.out.println(quickFind(num, 7));
    //  }
}
