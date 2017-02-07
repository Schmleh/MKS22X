public class Recursion{
 
    public static String name() {
	System.out.println("Yue,Min");
    }

    public static double sqrt(double n) {
	if (n < 0) {
	    throw new IllegalArgumentException;
	}
	return sqrthelp(0, n);
    }

    public static double sqrthelp(int try, double n) {
	if (isCloseEnough((try * try), n)){
	    return try;
	}
    }

    public static boolean isCloseEnough(double one, double two) {
	
    }

}
