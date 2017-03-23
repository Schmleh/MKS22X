public class Merge {

    public static void mergesort(int[] ary){
	int[] a = new int[ary.length / 2];
	int[] b = new int[ary.length - a.length];
	for (int x = 0; x < a.length; x ++){
	    a[x] = ary[x];
	}
	for (int y = 0; y < b.length; y ++){
	    b[y] = ary[y + a.length];
	}
	if (ary.length > 1){
	    mergesort(a);
	    mergesort(b);
	}
	int[] c = new int[ary.length];
        int d = 0;
	int e = 0;
        for (int f = 0; f < c.length; f++){
	    if (d == a.length){
		c[f] = b[e];
		e ++;
	    } else if(e == b.length){
		c[f] = a[d];
		d ++;
	    } else {
		if (a[d] <= b[e]){
		    c[f] = a[d];
		    d ++;
		} else {
		    c[f] = b[e];
		    e ++;
		}
	    }
	}
	for (int z = 0; z < c.length; z ++){
	    ary[z] = c[z];
	}
	for(int i = 0; i < c.length; i ++){
	    System.out.print(c[i] + " ");
	}
	System.out.println("\n");
    }

    public static void main(String[] args){
	int[] nums = {1,2,8,3,0,12,2345,74,123,586,32,5,-1,234,-342};
	mergesort(nums);
	for(int i = 0; i < nums.length; i ++){
	    System.out.println(nums[i]);
	}
    }
}
