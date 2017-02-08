public class Recursion{
    
    public static String name() {
        return "Yue,Min";
    }

    public static double sqrt(double n) {
	if (n < 0) {
	    throw new IllegalArgumentException();
	}
	return better(1.0, n);
    }

    public static double better(double guess, double n) {
	if (isCloseEnough((guess * guess), n)){
	    return guess;
	}
	return better((n / guess + guess) / 2, n);
    }

    public static boolean isCloseEnough(double one, double two) {
	return ((Math.abs(two - one)) < (0.00000000001));
    }

}
